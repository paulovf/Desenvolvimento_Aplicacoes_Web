/**
 * Classe Médico:
 * Esta classe implementa os métodos e atributos referêntes aos dados dos 
 * médicos queserão cadastrados/consultados no banco de dados. 
 **/
package br.java.tp.classes;

/***
 *
 * @author Paulo Vitor
 **/
public class Medico 
{
    public String nomeMedico; //Nome do médico
    public int idMedico; //ID do Médico
    public int crmMedico; // Número do CRM do médico
    
    /** 
     * Construtor default
     **/
    public Medico() 
    {}
    
    /*
     * Construtor sobrecarregado da classe Médico
     */
    public Medico(String nomeMedico, int idMedico, int crmMedico) {
        this.nomeMedico = nomeMedico;
        this.idMedico = idMedico;
        this.crmMedico = crmMedico;
    }

    public int getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(int crmMedico) {
        this.crmMedico = crmMedico;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String toString() {
        return "Medico{" + "nomeMedico=" + nomeMedico + ", idMedico=" + idMedico + ", crmMedico=" + crmMedico + '}';
    } 
}
