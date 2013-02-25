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
    private String mensagemRetornoErro, mensagemRetornoOK;
    
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

    public String getMensagemRetornoErro() {
        return mensagemRetornoErro;
    }

    public void setMensagemRetornoErro(String mensagemRetornoErro) {
        this.mensagemRetornoErro = mensagemRetornoErro;
    }

    public String getMensagemRetornoOK() {
        return mensagemRetornoOK;
    }

    public void setMensagemRetornoOK(String mensagemRetornoOK) {
        this.mensagemRetornoOK = mensagemRetornoOK;
    }

    public List<MedicoBean> getMedicoBeans() {
        return medicoBeans;
    }

    public void setMedicoBeans(List<MedicoBean> medicoBeans) {
        this.medicoBeans = medicoBeans;
    }
        
    public String cadastrarMedico(){
        if(nome.equalsIgnoreCase("")){
            setMensagemRetornoErro("Forneça um nome válido");
            return "error";
        }else if (crm.equalsIgnoreCase("")){
            setMensagemRetornoErro("Forneça um valor válido para o campo crm");
            return "error";
        }
        else{
                if (validarMedico().equals("ok")){
                    MedicoDAO medicoDAO = new MedicoDAO();
                    medicoDAO.setIdMedico(null);
                    medicoDAO.setNome(nome);
                    medicoDAO.setCrm(crm);
                    medicoDAO.cadastrarMedico();
                    limparDadosMedico();
                    setMensagemRetornoOK("Médico cadastardo com sucesso!");
                    return "ok";
                }else{
                    limparDadosMedico();
                    setMensagemRetornoErro("Médico já cadastrado");
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
        MedicoDAO medicoDAO2 = medicoDAO.getMedico();
        if(medicoDAO2 != null){
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
        setMensagemRetornoOK("");
        setMensagemRetornoErro("");
    }
    
    public String listar(){
        return "listar";
    }    
    
    public void alterarMedico(){
        MedicoDAO m = new MedicoDAO(nome, crm, idMedico);
        m.alterarMedico();
    }    
}
