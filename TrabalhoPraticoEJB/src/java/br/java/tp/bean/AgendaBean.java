/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.bean;

import br.java.tp.classes.AgendaPK;
import br.java.tp.classes.Exame;
import br.java.tp.classes.Medico;
import br.java.tp.classes.Paciente;
import br.java.tp.dao.AgendaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author paulo
 */
public class AgendaBean {
    protected AgendaPK agendaPK;
    private String obs;
    private String resultado;
    private Paciente paciente;
    private Exame exame;
    private Medico medico;
    private boolean achou;
    private List<AgendaBean> agendaBeans = new ArrayList();
    private String mensagemRetorno;

    public AgendaBean() {
    }

    public AgendaBean(AgendaPK agendaPK) {
        this.agendaPK = agendaPK;
    }
    
    public AgendaBean(AgendaPK agendaPK, String obs, String resultado, Paciente paciente, Exame exame, Medico medico) {
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
    
    public String cadastrarAgenda(){
        try{
        if(agendaPK.getDataHora() == null){
            limparDadosAgenda();
            setMensagemRetorno("Forneça uma data válida");
            return "error";
        }else if (medico.getIdMedico() == 0){
            limparDadosAgenda();
            setMensagemRetorno("Forneça o id do Médico");
            return "error";
        }else if (exame.getIdExame() == 0){
            limparDadosAgenda();
            setMensagemRetorno("Forneça o id do Exame");
            return "error";
        }else if (paciente.getIdPaciente() == 0){
            limparDadosAgenda();
            setMensagemRetorno("Forneça o id do Paciente");
            return "error";
        }else if (resultado.equalsIgnoreCase("")){
            limparDadosAgenda();
            setMensagemRetorno("Forneça um resultado válido");
            return "error";
        }else{
            if (validarAgenda().equals("ok")){
                AgendaDAO agendaDAO = new AgendaDAO();
                agendaDAO.setAgendaPK(agendaPK);
                agendaDAO.setExame(exame);
                agendaDAO.setMedico(medico);
                agendaDAO.setObs(obs);
                agendaDAO.setPaciente(paciente);
                agendaDAO.setResultado(resultado);
                agendaDAO.cadastrarAgenda();
                return "ok";
            }else{
                limparDadosAgenda();
                setMensagemRetorno("Agenda já cadastrada nesta data e hora");
                return "error";
            }
        }
        }catch(Exception e){
            e.printStackTrace();
            return "erros";
        }
    }
    
    public List<AgendaBean> listarAgendas(Date dataInicio, Date dataFim){
        AgendaDAO agendaDAO = new AgendaDAO();
        if (agendaDAO.getAgendaPK().getDataHora()!=null){
            List<AgendaBean> agendaBean = new ArrayList();
            for (AgendaDAO a: agendaDAO.getAgendas(dataInicio, dataFim)){
                agendaBean.add(new AgendaBean(a.getAgendaPK(), a.getObs(), a.getResultado(), 
                        a.getPaciente(), a.getExame(), a.getMedico()));
            }
            return agendaBean;
        }
        return null;
    }
    
    public void removerAgenda(Date data){
        AgendaDAO agendaDAO = new AgendaDAO(data);
        agendaDAO.deletarAgenda();
    }
    
    public AgendaBean obterAgenda(Date data){
        AgendaDAO a = new AgendaDAO(data);
        return new AgendaBean(a.getAgendaPK(), a.getObs(), a.getResultado(), a.getPaciente(), 
                a.getExame(), a.getMedico());
    }
    
    public String validarAgenda(){
        AgendaDAO agendaDAO = new AgendaDAO(agendaPK, obs, resultado, paciente, exame, medico);
        AgendaDAO agendaDAO2 = agendaDAO.getAgenda();
        if(agendaDAO2 != null){
            setMensagemRetorno("Agenda já cadastrada nesta ata e hora.");
            return "error";
        }
        else{
            return "ok";
        }
    }
       
    public void limparDadosAgenda(){
        setAgendaPK(null);
        setMedico(null);
        setExame(null);
        setObs("");
        setPaciente(null);
        setResultado("");
        setMensagemRetorno("");
    }
    
    public String listar(){
        return "listar";
    }    
    
    public void alterarAgenda(){
        AgendaDAO a = new AgendaDAO(agendaPK, obs, resultado, paciente, exame, medico);
        a.alterarAgenda();
    }
}
