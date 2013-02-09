/**
 * Classe Paciente:
 * Esta classe implementa os métodos e atributos referêntes aos dados dos 
 * pacientes que serão cadastrados/consultados no banco de dados. 
 **/
package br.java.tp.classes;

import java.util.Date;

/***
 *
 * @author Paulo Vitor
 **/
public class Paciente {
    
    private int id;
    private String nome;
    private Date dataNasc;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String uf;
    

    /*Construtor default */
    public Paciente() 
    {}
     
    /*Construtor sobrecarregado*/
    public Paciente(int id, String nome, Date dataNasc, String logradouro, 
            int numero, String bairro, String cidade, String uf) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String toString() {
        return "Paciente{" + "id=" + id + ", nome=" + nome + ", dataNasc=" + 
                dataNasc + ", logradouro=" + logradouro + ", numero=" + 
                numero + ", bairro=" + bairro + ", cidade=" + 
                cidade + ", uf=" + uf + '}';
    }
}
