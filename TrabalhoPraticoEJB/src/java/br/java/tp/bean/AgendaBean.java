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
    private String dataInicial, dataFinal;
    private boolean tipoRelatorio;
    private float total;
    private Date dataHora;
    private Integer idPaciente;
    private Integer idMedico;
    private Integer idExame;
    private String obs;
    private String resultado;
    private List<AgendaBean> agendaBeans = new ArrayList();
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

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public boolean isTipoRelatorio() {
        return tipoRelatorio;
    }

    public void setTipoRelatorio(boolean tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }    

    public String cadastrarAgenda() {
        limparMensagemErro();
        if(idMedico == null){
            setMensagemRetornoErro("selecione um médico!", 0);
            return "error";
        }
        if(idPaciente == null){
            setMensagemRetornoErro("selecione um paciente!", 1);
            return "error";
        }
        if(idExame == null){
            setMensagemRetornoErro("selecione um exame!", 2);
            return "error";
        }if(dataHora == null){
            setMensagemRetornoErro("Forneça uma data e hora para o agendamento!", 3);
            return "error";
        }if(resultado.length() < 3){
            setMensagemRetornoErro("Forneça um resultado!", 4);
            return "error";
        }else{
            AgendaDAO agendaDAO = new AgendaDAO();
            agendaDAO.setIdExame(idExame);
            agendaDAO.setIdMedico(idMedico);
            agendaDAO.setIdPaciente(idPaciente);
            agendaDAO.setDataHora(dataHora);
            agendaDAO.setObs(obs);
            agendaDAO.setResultado(resultado);
            if (agendaDAO.cadastrarAgenda()){
                limparDsdosAgenda();                
                setMensagemRetornoOK("Agenda cadastarda com sucesso!");
                return "ok";
            }else{
                limparDsdosAgenda();
                setMensagemRetornoErro("Agenda já cadastrada nesta data", 5);
                return "error";
            }
        }
    }
    
    public String relatorio() {
        dataInicial = dataInicial.substring(6, 10) + "/" + dataInicial.substring(3, 5) + "/" + dataInicial.substring(0, 2);
        dataFinal = dataFinal.substring(6, 10) + "/" + dataFinal.substring(3, 5) + "/" + dataFinal.substring(0, 2);
        if (tipoRelatorio) {
            return "ok_valor";
        }
        return "ok";
    }    

    public DataModel<AgendaBean> listaAgendas() {
        AgendaDAO agendaDAO = new AgendaDAO();

        List<AgendaDAO> listaAgenda = agendaDAO.obterAgendas(dataInicial, dataFinal);
        if (listaAgenda != null) {
            agendaBeans.removeAll(agendaBeans);
            for (AgendaDAO a : listaAgenda) {
                AgendaBean ag = new AgendaBean(a.getDataHora(), a.getIdPaciente(), a.getIdMedico(), a.getIdExame(),
                        a.getObs(), a.getResultado());
                
                try{
                    System.out.println(ag.getIdExame());                    
                    exameBean = new ExameBean(ag.getIdExame());
                    pacienteBean = new PacienteBean(ag.getIdPaciente());
                    medicoBean = new MedicoBean(ag.getIdMedico());

                    PacienteBean p = pacienteBean.obterPaciente();
                    MedicoBean m = medicoBean.obterMedico();
                    ExameBean e = exameBean.obterExames();
                    
                    System.out.println("----" + e.getValor());

                    ag.setPacienteBean(p);
                    ag.setMedicoBean(m);
                    ag.setExameBean(e);
                    agendaBeans.add(ag);
                }catch(Exception e){
                    e.printStackTrace();
                }                
            }
            total = calcula();
            return new ListDataModel(agendaBeans);
        }
        return null;
    }
    
    public float calcula() {
         float total = 0;
         for (AgendaBean a : agendaBeans) {
             total += a.getExameBean().getValor();
         }
         return total;
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
