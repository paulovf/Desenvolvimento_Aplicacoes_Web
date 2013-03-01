/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.dao;

import br.java.tp.bd.Conexao;
import br.java.tp.classes.Paciente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author paulo
 */
public class PacienteDAO {
    private Integer idPaciente;
    private String nome;
    private Date dataNasc;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;

    public PacienteDAO() 
    {}

    public PacienteDAO(String nome) {
        this.nome = nome;
    }

    public PacienteDAO(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public PacienteDAO(Integer idPasciente, String nome, Date dataNasc, 
            String logradouro, String numero, String bairro, String cidade, 
            String uf) {
        this.idPaciente = idPasciente;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    public EntityManager conecta(){
        EntityManager em = Conexao.getManager();
        return em;
    }
    
    public boolean cadastrarPaciente(){
        try{
            if(conecta() != null){
                Paciente p = new Paciente();
                
                p.setIdPaciente(null);
                p.setNome(nome);
                p.setDataNasc(dataNasc);
                p.setLogradouro(logradouro);
                p.setNumero(numero);
                p.setBairro(bairro);
                p.setCidade(cidade);
                p.setUf(uf);
                
                conecta().getTransaction().begin();
                conecta().persist(p);
                conecta().getTransaction().commit();
                return true;
            }
            else{
                return false;
            }
        }catch(Exception e){
            if (conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }
            return false;
        }
    }
    
    public boolean alterarPaciente(){
        try{
            if(conecta() != null){
                Paciente p = conecta().find(Paciente.class, idPaciente);
                p.setNome(nome);
                p.setDataNasc(dataNasc);
                p.setLogradouro(logradouro);
                p.setNumero(numero);
                p.setBairro(bairro);
                p.setCidade(cidade);
                p.setUf(uf);
                
                conecta().getTransaction().begin();
                conecta().persist(p);
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

    public void deletarPaciente(){
        try{
            if(conecta() != null){
                Paciente p = conecta().find(Paciente.class, idPaciente);
                conecta().getTransaction().begin();
                conecta().remove(p);
                conecta().getTransaction().commit();
            }
        }catch(Exception e){
            if(conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }
        }        
    }
    
    public PacienteDAO getPaciente(){
       try{
            EntityManager em = conecta();
            if (em!=null){
                String consulta = "SELECT p FROM Paciente p WHERE p.idPaciente="+idPaciente;
                Query q = em.createQuery(consulta);
                List<Paciente> resultado = q.getResultList();
                PacienteDAO paciente = new PacienteDAO();
                for (Paciente p: resultado){
                    paciente = new PacienteDAO(p.getIdPaciente(), p.getNome(), p.getDataNasc(), 
                            p.getLogradouro(), p.getNumero(), p.getBairro(), p.getCidade(), p.getUf());
                }
                return paciente;
            }
            return null;
        } catch (Exception e){
            return null;
        }
    }
    
    public List<PacienteDAO> getPacientes(){
        try{
            if(conecta() != null){
                Query q = conecta().createQuery("SELECT p FROM Paciente p");

                List<Paciente> lista = q.getResultList();
                List<PacienteDAO> listarPacienteDAO = new ArrayList();

                for(Paciente p: lista){
                    listarPacienteDAO.add(new PacienteDAO(p.getIdPaciente(), p.getNome(), p.getDataNasc(), 
                            p.getLogradouro(), p.getNumero(), p.getBairro(), p.getCidade(), p.getUf()));
                }
                return listarPacienteDAO;
            }else{
                return null;
            }
        }catch(Exception e){
            return null;
        }
    }   
}
