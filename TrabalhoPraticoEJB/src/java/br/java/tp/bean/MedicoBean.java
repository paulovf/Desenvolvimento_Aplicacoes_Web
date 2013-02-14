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
    
    public boolean cadastrarMedico(){
        MedicoDAO medicoDAO = new MedicoDAO();
        medicoDAO.setIdMedico(null);
        medicoDAO.setNome(nome);
        medicoDAO.setCrm(crm);
        return medicoDAO.cadastrarMedico();
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
    
    public void alterarMedico(){
        MedicoDAO m = new MedicoDAO(nome, crm, idMedico);
        m.alterarMedico();
    }    
}
