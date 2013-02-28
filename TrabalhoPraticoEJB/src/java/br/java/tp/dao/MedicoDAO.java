/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.dao;

import br.java.tp.bd.Conexao;
import br.java.tp.classes.Medico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author paulo
 */
public class MedicoDAO {
    private String nome;
    private String crm;
    private Integer idMedico;

    public MedicoDAO() 
    {}

    public MedicoDAO(String nome) {
        this.nome = nome;
    }
    
    public MedicoDAO(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public MedicoDAO(String nome, String crm, Integer idMedico) {
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
    
    public EntityManager conecta(){
        EntityManager em = Conexao.getManager();
        return em;
    }
    
    public boolean cadastrarMedico(){
        try{
            if(conecta() != null){
                Medico m = new Medico();
                m.setIdMedico(null);
                m.setNome(nome);
                m.setCrm(crm);
                System.out.println(nome);
                System.out.println(crm);

                conecta().getTransaction().begin();
                conecta().persist(m);
                conecta().getTransaction().commit();
                return true;
            }
            else{
                return false;
            }
        }catch(Exception e){
            if (conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
                return false;
            }
            return false;
        }
    }
    
    public boolean alterarMedico(){
        try{
            if(conecta() != null){
                Medico m = conecta().find(Medico.class, idMedico);
                m.setNome(nome);
                m.setCrm(crm);
                
                conecta().getTransaction().begin();
                conecta().persist(m);
                conecta().getTransaction().commit();
                return true;
            }
        }catch(Exception e){
            if(conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }
            return false;
        }
        return false;
    }

    public void deletarMedico(){
        try{
            if(conecta() != null){
                Medico m = conecta().find(Medico.class, idMedico);

                conecta().getTransaction().begin();
                conecta().remove(m);
                conecta().getTransaction().commit();
            }
        }catch(Exception e){
            if(conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }                                
        }        
    }
    
    public MedicoDAO getMedico(){
        try{
            if(conecta() != null){
                Query q = conecta().createQuery("SELECT m FROM Medico m WHERE m.nome =:nome");
                q.setParameter("nome", nome);
                if (q.getSingleResult()!=null){
                    Medico m = (Medico) q.getSingleResult();
                    MedicoDAO medicoDAO = new MedicoDAO(m.getNome(), m.getCrm(), m.getIdMedico());
                    return medicoDAO;
                }
            }
            return null;
        }catch(Exception e){
            if(conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }
            e.printStackTrace();
        }
        
        return null;
    }
    
    public List<MedicoDAO> getMedicos(){
        try{
            if(conecta() != null){
                Query q = conecta().createQuery("SELECT m FROM Medico m");

                List<Medico> lista = q.getResultList();
                List<MedicoDAO> listaMedicoDAO = new ArrayList();

                for(Medico m: lista){
                    listaMedicoDAO.add(new MedicoDAO(m.getNome(), m.getCrm(), m.getIdMedico()));
                }
                return listaMedicoDAO;
            }else{
                return null;
            }
        }catch(Exception e){
            return null;
        }
    }    
}