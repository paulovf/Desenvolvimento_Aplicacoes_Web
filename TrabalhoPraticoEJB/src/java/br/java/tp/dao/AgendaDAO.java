/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.dao;

import br.java.tp.bd.Conexao;
import br.java.tp.classes.Agenda;
import br.java.tp.classes.AgendaPK;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author paulo
 */

public class AgendaDAO{
    private Date dataHora;
    private Integer idPaciente;
    private Integer idMedico;
    private Integer idExame;
    private String obs;
    private String resultado;

    public AgendaDAO() {
    }

    public AgendaDAO(Date dataHora, Integer idPaciente, Integer idMedico, Integer idExame) {
        this.dataHora = dataHora;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.idExame = idExame;
    }

    public AgendaDAO(Date dataHora, Integer idPaciente, Integer idMedico, Integer idExame, String obs, String resultado) {
        this.dataHora = dataHora;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.idExame = idExame;
        this.obs = obs;
        this.resultado = resultado;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getIdExame() {
        return idExame;
    }

    public void setIdExame(Integer idExame) {
        this.idExame = idExame;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
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

    public EntityManager conecta() {
        EntityManager em = Conexao.getManager();
        return em;
    }

    public boolean cadastrarAgenda() {
        EntityManager em = conecta();
        try {
            if (em != null) {
                AgendaPK a = new AgendaPK(dataHora, idMedico, idExame, idPaciente);
                Agenda agenda = new Agenda();
                agenda.setAgendaPK(a);
                agenda.setObs(obs);
                agenda.setResultado(resultado);

                em.getTransaction().begin();
                em.persist(agenda);
                em.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    public List<AgendaDAO> obterAgendas(String dataInicial, String dataFinal) {
        EntityManager em = conecta();
        System.out.println(dataFinal);
        System.out.println(dataInicial);
        try {
            String consulta;
            Query q;
            if (dataInicial != null) {
                consulta = "SELECT a FROM Agenda a WHERE dataHora BETWEEN :dataInicio AND :dataFinal";
                q = em.createQuery(consulta).setParameter("dataInicio", dataInicial).setParameter("dataFinal", dataFinal);
            } else {
                consulta = "SELECT a FROM Agenda a";
                q = em.createQuery(consulta);
            }
            List<Agenda> a = q.getResultList();
            List<AgendaDAO> agenda = new ArrayList<AgendaDAO>();
            for (Agenda ag : a) {
                AgendaPK apk = ag.getAgendaPK();
                agenda.add(new AgendaDAO(apk.getDataHora(), apk.getIdPaciente(), apk.getIdMedico(), apk.getIdExame(),
                        ag.getObs(), ag.getResultado()));
            }
            return agenda;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }
    
    public AgendaDAO obterAgenda(){
        try{
            if(conecta() != null){
                Query q = conecta().createQuery("SELECT a FROM Agenda a WHERE a.dataHora =:dataHora");
                q.setParameter("dataHora", dataHora);
                if (q.getSingleResult()!=null){
                    Agenda a = (Agenda) q.getSingleResult();
                    AgendaDAO agendaDAO = new AgendaDAO(a.getAgendaPK().getDataHora(), a.getAgendaPK().getIdPaciente(), 
                            a.getAgendaPK().getIdMedico(), a.getAgendaPK().getIdExame(), a.getObs(), a.getResultado());
                    return agendaDAO;
                }
            }
            return null;
        }catch(Exception e){
            if(conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
                e.printStackTrace();
            }                
        }
        
        return null;
    }

    public void alterarAgenda() {
        EntityManager em = conecta();
        try {
            AgendaPK agendaPK = new AgendaPK(dataHora, idMedico, idExame, idPaciente);
            Agenda agenda = em.find(Agenda.class, agendaPK);
            agenda.setObs(obs);
            agenda.setResultado(resultado);

            em.getTransaction().begin();
            em.persist(agenda);
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public void removerAgenda() {
        EntityManager em = conecta();
        try {
            AgendaPK agendaPK = new AgendaPK(dataHora, idMedico, idExame, idPaciente);
            Agenda agenda = em.find(Agenda.class, agendaPK);

            em.getTransaction().begin();
            em.remove(agenda);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
}
