/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.bean;

import br.java.tp.classes.AgendaPK;
import java.util.Date;

/**
 *
 * @author paulo
 */
public class AgendaPKBean {
    private Date dataHora;
    private int idMedico;
    private int idExame;
    private int idPaciente;

    public AgendaPKBean() {
    }

    public AgendaPKBean(Date dataHora, int idMedico, int idExame, int idPaciente) {
        this.dataHora = dataHora;
        this.idMedico = idMedico;
        this.idExame = idExame;
        this.idPaciente = idPaciente;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdExame() {
        return idExame;
    }

    public void setIdExame(int idExame) {
        this.idExame = idExame;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    public String cadastrarAgendaPK(){
        AgendaBean agendaBean = new AgendaBean(new AgendaPK(dataHora, idMedico, idExame, idPaciente));
        return agendaBean.cadastrarAgenda();
    }
}
