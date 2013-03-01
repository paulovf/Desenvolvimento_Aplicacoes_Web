/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.bean;

import br.java.tp.dao.AgendaDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author paulo
 */
public class AgendaBean {
    private Date dataHora;
    private Integer idPaciente;
    private Integer idMedico;
    private Integer idExame;
    private String obs;
    private String resultado;
    private List<AgendaBean> agendaBeans = new ArrayList<AgendaBean>();
    private PacienteBean pacienteBean;
    private MedicoBean medicoBean;
    private ExameBean exameBean;
    private String mensagemRetornoErro[] = new String[6], mensagemRetornoOK;

    public AgendaBean() {
    }

    public AgendaBean(Date dataHora, Integer idPaciente, Integer idMedico, Integer idExame, String obs, String resultado) {
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

    public ExameBean getExameBean() {
        return exameBean;
    }

    public void setExameBean(ExameBean exameBean) {
        this.exameBean = exameBean;
    }

    public MedicoBean getMedicoBean() {
        return medicoBean;
    }

    public void setMedicoBean(MedicoBean medicoBean) {
        this.medicoBean = medicoBean;
    }

    public PacienteBean getPacienteBean() {
        return pacienteBean;
    }

    public void setPacienteBean(PacienteBean pacienteBean) {
        this.pacienteBean = pacienteBean;
    }

    public List<AgendaBean> getAgendaBeans() {
        return agendaBeans;
    }

    public void setAgendaBeans(List<AgendaBean> agendaBeans) {
        this.agendaBeans = agendaBeans;
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

    public String cadastrarAgenda() {
        System.out.println("0");
        limparMensagemErro();
        if(idMedico == null){
            setMensagemRetornoErro("selecione um médico!", 0);
            System.out.println("1");
            return "error";
        }
        if(idPaciente == null){
            setMensagemRetornoErro("selecione um paciente!", 1);
            System.out.println("2");
            return "error";
        }
        if(idExame == null){
            setMensagemRetornoErro("selecione um exame!", 2);
            System.out.println("3");
            return "error";
        }if(dataHora == null){
            setMensagemRetornoErro("Forneça uma data e hora para o agendamento!", 3);
            System.out.println("4");
            return "error";
        }if(resultado.length() <= 3){
            setMensagemRetornoErro("Forneça um resultado!", 4);
            System.out.println("5");
            return "error";
        }else{
            System.out.println("6");
            AgendaDAO agendaDAO = new AgendaDAO();
            agendaDAO.setIdExame(idExame);
            agendaDAO.setIdMedico(idMedico);
            agendaDAO.setIdPaciente(idPaciente);
            agendaDAO.setDataHora(dataHora);
            agendaDAO.setObs(obs);
            agendaDAO.setResultado(resultado);
            if (agendaDAO.obterAgenda() == null){
                agendaDAO.cadastrarAgenda();
                limparDsdosAgenda();
                setMensagemRetornoOK("Agenda cadastarda com sucesso!");
                System.out.println("7");
                return "ok";
            }else{
                limparDsdosAgenda();
                setMensagemRetornoErro("Agenda já cadastrada nesta data", 5);
                System.out.println("8");
                return "error";
            }
        }
    }

    public DataModel<AgendaBean> obterAgendas() {
        AgendaDAO ag = new AgendaDAO();
        if (ag.obterAgendas() != null) {
            agendaBeans.removeAll(agendaBeans);
            for (AgendaDAO a : ag.obterAgendas()) {
                AgendaBean agenda = new AgendaBean(a.getDataHora(), a.getIdPaciente(), a.getIdMedico(), a.getIdExame(),
                        a.getObs(), a.getResultado());
                
                PacienteBean paciente = new PacienteBean();
                paciente.setIdPaciente(a.getIdPaciente());
                pacienteBean = paciente.obterPaciente(paciente.getNome());
                
                MedicoBean medico = new MedicoBean();
                medico.setIdMedico(a.getIdMedico());
                medicoBean = medico.obterMedico(medico.getNome());
                
                ExameBean exame = new ExameBean();
                exame.setIdExame(a.getIdExame());
                exameBean = exame.obterExames(exame.getNome());
                
                agenda.setPacienteBean(pacienteBean);
                agenda.setMedicoBean(medicoBean);
                agenda.setExameBean(exameBean);
                
                agendaBeans.add(agenda);
                System.out.println();
            }
            return new ListDataModel(agendaBeans);
        }
        return null;
    }

    public String loadAgendamento() throws ParseException {
        Map parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String dataStr = parametros.get("dataHora").toString();
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        Date data2 = inputFormat.parse(dataStr);
            
        String idPac = parametros.get("idPaciente").toString();
        Integer idPac2 = Integer.parseInt(idPac);
        
        String idMed = parametros.get("idMedico").toString();
        Integer idMed2 = Integer.parseInt(idMed);
        
        String idExa = parametros.get("idExame").toString();
        Integer idExa2 = Integer.parseInt(idExa);
        
        int i;
        for (i=0;i<agendaBeans.size();i++){
            if (agendaBeans.get(i).getDataHora().compareTo(data2)==0 && idExa2==agendaBeans.get(i).getIdExame()
                    && idPac2==agendaBeans.get(i).getIdPaciente() && idMed2==agendaBeans.get(i).getIdMedico()){
                break;
            }
        }
        
        this.dataHora = data2;
        this.idPaciente = idPac2;
        this.idMedico = idMed2;
        this.idExame = idExa2;
        this.obs = agendaBeans.get(i).getObs();
        this.resultado = agendaBeans.get(i).getResultado();
        this.pacienteBean = agendaBeans.get(i).getPacienteBean();
        this.exameBean = agendaBeans.get(i).getExameBean();
        this.medicoBean = agendaBeans.get(i).getMedicoBean();
        
        return "carrega";
    }
    
    public void alterarAgenda(){
        AgendaDAO agendaDAO = new AgendaDAO(dataHora, idPaciente, idMedico, idExame);
        agendaDAO.alterarAgenda();
    }

    public String buscaPaciente(){
        Map parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String idPac = parametros.get("idPaciente").toString();
        Integer idPac2 = Integer.parseInt(idPac);
        
        AgendaBean agenda = new AgendaBean();
        agenda.setIdPaciente(idPaciente);
        String nomePaciente = agenda.buscaPaciente();
        return null;
    }
    
    public String remove() throws ParseException {
        Map parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String dataStr = parametros.get("dataHora").toString();
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        Date data2 = inputFormat.parse(dataStr);
            
        String idPac = parametros.get("idPaciente").toString();
        Integer idPac2 = Integer.parseInt(idPac);
        
        String idMed = parametros.get("idMedico").toString();
        Integer idMed2 = Integer.parseInt(idMed);
        
        String idExa = parametros.get("idExame").toString();
        Integer idExa2 = Integer.parseInt(idExa);
        
        AgendaDAO agendaDAO = new AgendaDAO(data2, idPac2, idMed2, idExa2);
        agendaDAO.removerAgenda();
        return "";
    }
    
    public void limparDsdosAgenda(){
        setDataHora(null);
        setIdExame(null);
        setIdMedico(null);
        setIdPaciente(null);
        setObs("");
        setResultado("");
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
