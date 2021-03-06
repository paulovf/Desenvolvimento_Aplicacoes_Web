/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.bean;

import br.java.tp.dao.MedicoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author paulo
 */
public class MedicoBean {
    private String nome;
    private String crm;
    private Integer idMedico;
    private boolean achou;
    private List<MedicoBean> medicoBeans = new ArrayList<MedicoBean>();
    private List<SelectItem> medicos = new ArrayList<SelectItem>();
    private String mensagemRetornoErro[] = new String[3], mensagemRetornoOK;
    
    public MedicoBean() 
    {}

    public MedicoBean(Integer idMedico) {
        this.idMedico = idMedico;
    }
    
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

    public String[] getMensagemRetornoErro() {
        return mensagemRetornoErro;
    }

    public void setMensagemRetornoErro(String mensagemRetornoErro, Integer indice) {
        this.mensagemRetornoErro[indice] = mensagemRetornoErro;
    }

    public String getMensagemRetornoOK() {
        return mensagemRetornoOK;
    }

    public void setMensagemRetornoOK(String mensagemRetornoOK) {
        this.mensagemRetornoOK = mensagemRetornoOK;
    }

    public List<SelectItem> getMedicoBeans() {
        MedicoDAO medico = new MedicoDAO();
        medicos.removeAll(medicos);
        for (MedicoDAO e : medico.getMedicos()) {
            medicos.add(new SelectItem(e.getIdMedico(), e.getNome()));

        }
        return medicos;
    }

    public void setMedicoBeans(List<MedicoBean> medicoBeans) {
        this.medicoBeans = medicoBeans;
    }
        
    public String cadastrarMedico(){
        if(nome.length() < 3){
            setMensagemRetornoErro("Forneça um nome válido", 0);
            return "error";
        }
        if(crm.length() > 0){
            try{
                Integer.parseInt(crm);
            }catch(Exception e){
                setMensagemRetornoErro("CRM inválido!", 1);
                return "error";
            }
        }
        if(crm.length() <= 0){
            setMensagemRetornoErro("CRM inválido!", 1);
            return "error";
        }else{
            MedicoDAO medicoDAO = new MedicoDAO();
            medicoDAO.setIdMedico(null);
            medicoDAO.setCrm(crm);
            medicoDAO.setNome(nome);
            if (medicoDAO.getMedico2() == null){
                medicoDAO.cadastrarMedico();
                limparDadosMedico();
                setMensagemRetornoOK("Médico cadastardo com sucesso!");
                return "ok";
            }else{
                limparDadosMedico();
                setMensagemRetornoErro("Médico já cadastrado", 2);
                return "error";
            }
        }
    }
    
    public List<MedicoBean> listarMedicos(){
        limparDadosMedico();
        MedicoDAO medicoDAO = new MedicoDAO();
        if (medicoDAO.getMedicos()!=null){
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
    
    public MedicoBean obterMedico(){
        limparDadosMedico();
        MedicoDAO m = new MedicoDAO(idMedico);
        m = m.getMedico();
        return new MedicoBean(m.getNome(), m.getCrm(), m.getIdMedico());
    }
    
    public String obterMedico2(){
        limparDadosMedico();
        MedicoDAO m = new MedicoDAO(idMedico);
        if (m.getMedico() != null)            
            return "ok";
        else
            return "error";
    }
    
    public String alterarMedico(){
        limparMensagemErro();
        if(nome.length() < 3){
            setMensagemRetornoErro("Forneça um nome válido", 0);
            return "error";
        }
        if(crm.length() < 0){
            try{
                Integer.parseInt(crm);
            }catch(Exception e){
                setMensagemRetornoErro("CRM inválido!", 1);
                return "error";
            }
            setMensagemRetornoErro("CRM inválido!", 1);
            return "error";
        }
        else{
            MedicoDAO m = new MedicoDAO(nome, crm, idMedico);
            if (m.alterarMedico()){
                limparDadosMedico();
                setMensagemRetornoOK("alteração realizada com sucesso");
                return "ok";
            }else{
                setMensagemRetornoErro("Erro ao alterar médico", 2);
                return "erro";
            }
        }
    }
    
    public String loadMedico(String nome){
        limparDadosMedico();
        MedicoDAO medicoDAO = new MedicoDAO(nome);
        MedicoDAO m = medicoDAO.getMedico();
        if(m.getMedico() != null){
            limparDadosMedico();
            idMedico = m.getIdMedico();
            this.nome = m.getNome();
            crm = m.getCrm();
            return "ok_alterar";
        }
        else{
            setMensagemRetornoErro("Por favor, selecione um Médico", 2);
            return "error";
        }
    }
    
    public String getNomeMedico(Integer idMedico){
        MedicoDAO m = new MedicoDAO(idMedico);
        return m.getMedico().getNome();
    }
       
    public void limparDadosMedico(){
        setIdMedico(null);
        setNome("");
        setCrm("");
        setMensagemRetornoOK("");
        limparMensagemErro();
    }
    
    public void limparMensagemErro(){
        int i = 0;
        while(i < mensagemRetornoErro.length){
            mensagemRetornoErro[i] = null;
            i++;
        }
    }
}
