/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.bean;

import br.java.tp.dao.MedicoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulo
 */
public class MedicoBean {
    private String nome;
    private String crm;
    private Integer idMedico;
    private boolean achou;
    private List<MedicoBean> medicoBeans = new ArrayList();
    private String mensagemRetorno; 
    
    public MedicoBean() 
    {}

    public MedicoBean(String nome, String crm, Integer idMedico) {
        this.nome = nome;
        this.crm = crm;
        this.idMedico = idMedico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }
    
    public boolean isAchou() {
        return achou;
    }

    public void setAchou(boolean achou) {
        this.achou = achou;
    }

    public String getMensagemRetorno() {
        return mensagemRetorno;
    }

    public void setMensagemRetorno(String mensagemRetorno) {
        this.mensagemRetorno = mensagemRetorno;
    }    
        
    public String cadastrarMedico(){
        if(nome.equalsIgnoreCase("")){
            setMensagemRetorno("Forneça um nome válido");
            return "error";
        }else if (crm.equalsIgnoreCase("")){
            setMensagemRetorno("Forneça um valor válido para o campo crm");
            return "error";
        }
        else{
                if (validarMedico().equals("ok")){
                    MedicoDAO medicoDAO = new MedicoDAO();
                    medicoDAO.setIdMedico(null);
                    medicoDAO.setNome(nome);
                    medicoDAO.setCrm(crm);
                    medicoDAO.cadastrarMedico();
                    return "ok";
                }else{
                    limparDadosMedico();
                    setMensagemRetorno("Médico já cadastrado");
                    return "error";
                }
        }
    }
    
    public List<MedicoBean> listarMedico(){
        MedicoDAO medicoDAO = new MedicoDAO();
        if (medicoDAO.getIdMedico()!=null){
            List<MedicoBean> medicoBean = new ArrayList();
            for (MedicoDAO m: medicoDAO.getMedicos()){
                medicoBean.add(new MedicoBean(m.getNome(), m.getCrm(), m.getIdMedico()));
            }
            return medicoBean;
        }
        return null;
    }
    
    public void removerMedico(Integer idMedico){
        MedicoDAO medicoDAO = new MedicoDAO(idMedico);
        medicoDAO.deletarMedico();
    }
    
    public MedicoBean obterMedicos(){
        MedicoDAO m = new MedicoDAO(idMedico);
        return new MedicoBean(m.getNome(), m.getCrm(), m.getIdMedico());
    }
    
    public String validarMedico(){
        MedicoDAO medicoDAO = new MedicoDAO(nome, crm, idMedico);
        MedicoDAO medicoDAO2 = medicoDAO.validarMedico();
        if(medicoDAO2 != null){
            setMensagemRetorno("Médico já cadastrado.");
            return "error";
        }
        else{
            return "ok";
        }
    }
       
    public void limparDadosMedico(){
        setIdMedico(null);
        setNome("");
        setCrm("");
        setMensagemRetorno("");
    }
    
    public String listar(){
        return "listar";
    }    
    
    public void alterarMedico(){
        MedicoDAO m = new MedicoDAO(nome, crm, idMedico);
        m.alterarMedico();
    }    
}
