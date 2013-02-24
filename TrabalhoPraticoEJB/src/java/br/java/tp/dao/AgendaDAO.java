/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.dao;

import br.java.tp.bd.Conexao;
import br.java.tp.classes.Agenda;
import br.java.tp.classes.AgendaPK;
import br.java.tp.classes.Exame;
import br.java.tp.classes.Medico;
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
public class AgendaDAO {
    protected AgendaPK agendaPK;
    private String obs;
    private String resultado;
    private Paciente paciente;
    private Exame exame;
    private Medico medico;

    public AgendaDAO() {
    }

    public AgendaDAO(Date data) {
        agendaPK.setDataHora(data);
    }

    public AgendaDAO(AgendaPK agendaPK, String obs, String resultado, Paciente paciente, Exame exame, Medico medico) {
        this.agendaPK = agendaPK;
        this.obs = obs;
        this.resultado = resultado;
        this.paciente = paciente;
        this.exame = exame;
        this.medico = medico;
    }

    public AgendaPK getAgendaPK() {
        return agendaPK;
    }

    public void setAgendaPK(AgendaPK agendaPK) {
        this.agendaPK = agendaPK;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public EntityManager conecta(){
        EntityManager em = Conexao.getManager();
        return em;
    }
    
    public boolean cadastrarAgenda(){
        try{
            if(conecta() != null){
                Agenda a = new Agenda();
                a.setAgendaPK(agendaPK);
                a.setExame(exame);
                a.setMedico(medico);
                a.setPaciente(paciente);
                a.setResultado(resultado);
                a.setObs(obs);

                conecta().getTransaction().begin();
                conecta().persist(a);
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
    
    public void alterarAgenda(){
        try{
            if(conecta() != null){
                Agenda a = conecta().find(Agenda.class, agendaPK);
                a.setExame(exame);
                a.setMedico(medico);
                a.setObs(obs);
                a.setPaciente(paciente);
                a.setResultado(resultado);
                
                conecta().getTransaction().begin();
                conecta().persist(a);
                conecta().getTransaction().commit();
            }
        }catch(Exception e){
            if(conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }                                
        }          
    }

    public void deletarAgenda(){
        try{
            if(conecta() != null){
                Agenda a = conecta().find(Agenda.class, agendaPK);

                conecta().getTransaction().begin();
                conecta().remove(a);
                conecta().getTransaction().commit();
            }
        }catch(Exception e){
            if(conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }                                
        }        
    }
    
    public AgendaDAO getAgenda(){
        try{
            if(conecta() != null){
                Query q = conecta().createQuery("SELECT a FROM Agenda a WHERE a.dataHora =:agendaPK.getDataHora()");
                q.setParameter("dataHora", agendaPK.getDataHora());
                if (q.getSingleResult()!=null){
                    Agenda a = (Agenda) q.getSingleResult();
                    AgendaDAO agendaDAO = new AgendaDAO(a.getAgendaPK(), a.getObs(), a.getResultado(), 
                            a.getPaciente(), a.getExame(), a.getMedico());
                    return agendaDAO;
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
    
    public List<AgendaDAO> getAgendas(Date dataInicio, Date dataFim){
        try{
            if(conecta() != null){
                Query q = conecta().createQuery("SELECT a FROM Agenda a WHERE a.dataHora BETWEEN " + dataInicio + 
                        " AND " + dataFim);

                List<Agenda> lista = q.getResultList();
                List<AgendaDAO> listaAgendaDAO = new ArrayList();

                for(Agenda a: lista){
                    listaAgendaDAO.add(new AgendaDAO(a.getAgendaPK(), a.getObs(), a.getResultado(), a.getPaciente(), 
                            a.getExame(), a.getMedico()));
                }
                return listaAgendaDAO;
            }else{
                return null;
            }
        }catch(Exception e){
            return null;
        }
    }    
}
