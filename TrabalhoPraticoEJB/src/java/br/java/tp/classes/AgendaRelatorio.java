/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.classes;


/**
 *
 * @author paulo
 */
public class AgendaRelatorio {
    private String dataInicial;
    private String dataFinal;
    private boolean tipoRelatorio;

    public AgendaRelatorio() {
    }

    public AgendaRelatorio(String datainicial, String dataFinal) {
        this.dataInicial = datainicial;
        this.dataFinal = dataFinal;
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
    
    public String relatorio() {
        dataInicial = dataInicial.substring(6, 10) + "/" + dataInicial.substring(3, 5) + "/" + dataInicial.substring(0, 2);
        dataFinal = dataFinal.substring(6, 10) + "/" + dataFinal.substring(3, 5) + "/" + dataFinal.substring(0, 2);
        if (tipoRelatorio) {
            return "ok_valor";
        }
        return "ok";
    }    
}
