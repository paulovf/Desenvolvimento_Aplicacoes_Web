/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.dao;

import br.java.tp.bd.Conexao;
import br.java.tp.classes.Exame;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author paulo
 */
public class ExameDAO {
    private String nome;
    private float valor;
    private Integer idExame;

    public ExameDAO() {
    }

    public ExameDAO(Integer idExame) {
        this.idExame = idExame;
    }

    public ExameDAO(String nome, float valor, Integer idExame) {
        this.nome = nome;
        this.valor = valor;
        this.idExame = idExame;
    }

    public Integer getIdExame() {
        return idExame;
    }

    public void setIdExame(Integer idExame) {
        this.idExame = idExame;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public EntityManager conecta(){
        EntityManager em = Conexao.getManager();
        return em;
    }
    
    public boolean cadastrarExame(){
        try{
            if(conecta() != null){
                Exame e = new Exame();
                e.setIdExame(null);
                e.setNome(nome);
                e.setValor(valor);

                conecta().getTransaction().begin();
                conecta().persist(e);
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
    
    public void alterarExame(){
        try{
            if(conecta() != null){
                Exame e = conecta().find(Exame.class, idExame);
                e.setNome(nome);
                e.setValor(valor);
                
                conecta().getTransaction().begin();
                conecta().persist(e);
                conecta().getTransaction().commit();
            }
        }catch(Exception e){
            if(conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }                                
        }          
    }

    public void deletarExame(){
        try{
            if(conecta() != null){
                Exame e = conecta().find(Exame.class, idExame);

                conecta().getTransaction().begin();
                conecta().remove(e);
                conecta().getTransaction().commit();
            }
        }catch(Exception e){
            if(conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }                                
        }        
    }
    
    public ExameDAO getExame(){
        try{
            if(conecta() != null){
                Query q = conecta().createQuery("SELECT e FROM Exame e WHERE e.nome =:nome");
                q.setParameter("nome", nome);
                if (q.getSingleResult()!=null){
                    Exame e = (Exame) q.getSingleResult();
                    ExameDAO exameDAO = new ExameDAO(e.getNome(), e.getValor(), e.getIdExame());
                    return exameDAO;
                }
            }
            return null;
        }catch(Exception e){
            if(conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }                
        }
        
        return null;
    }
    
    public List<ExameDAO> getExames(){
        try{
            if(conecta() != null){
                Query q = conecta().createQuery("SELECT e FROM Exame e");

                List<Exame> lista = q.getResultList();
                List<ExameDAO> listaExameDAO = new ArrayList();

                for(Exame e: lista){
                    listaExameDAO.add(new ExameDAO(e.getNome(), e.getValor(), e.getIdExame()));
                }
                return listaExameDAO;
            }else{
                return null;
            }
        }catch(Exception e){
            return null;
        }
    }  
}