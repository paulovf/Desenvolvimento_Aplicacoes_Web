/**
 * Classe Agenda:
 * Esta classe implementa os métodos e atributos referentes ao cadastramento
 * e/ou consulta de um exame médico.
 **/
package br.java.tp.classes;

/***
 *
 * @author Paulo Vitor
 **/
public class Exame {
    
    private int idExame;
    private String nomeExame;
    private float valorExame;
    
    /*Construtor default*/
    public Exame() 
    {}
    
    /*Construtor sobrecarregado*/
    public Exame(int idExame, String nomeExame, float valorExame) {
        this.idExame = idExame;
        this.nomeExame = nomeExame;
        this.valorExame = valorExame;
    }

    public int getIdExame() {
        return idExame;
    }

    public void setIdExame(int idExame) {
        this.idExame = idExame;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public float getValorExame() {
        return valorExame;
    }

    public void setValorExame(float valorExame) {
        this.valorExame = valorExame;
    }

    public String toString() {
        return "Exame{" + "idExame=" + idExame + ", nomeExame=" + 
                nomeExame + ", valorExame=" + valorExame + '}';
    }    
}
