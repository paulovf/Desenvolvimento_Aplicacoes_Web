/**
 * Classe Agenda:
 * Esta classe implementa a funcionalidade de agendar uma consulta de um
 * paciente com um médico e os exames slicitados pelo médico. 
 **/
package br.java.tp.classes;

import java.util.Date;

/***
 *
 * @author Paulo Vitor
 **/
public class Agenda {
    
    private Date dataHora;
    private Medico medico;
    private Paciente paciente;
    private Exame exame;
    private String observacao;
    private String resultado;
    
    /*Construtor default*/
    public Agenda() 
    {}
    
    /*Construtor sobrecarregado*/
    public Agenda(Date dataHora, Medico medico, Paciente paciente, 
            Exame exame, String observacao, String resultado) {
        this.dataHora = dataHora;
        this.medico = medico;
        this.paciente = paciente;
        this.exame = exame;
        this.observacao = observacao;
        this.resultado = resultado;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String toString() {
        return "Agenda{" + "dataHora=" + dataHora + ", medico=" + 
                medico + ", paciente=" + paciente + ", exame=" + 
                exame + ", observacao=" + observacao + ", resultado=" + 
                resultado + '}';
    }

}
