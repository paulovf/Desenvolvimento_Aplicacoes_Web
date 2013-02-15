/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.bean;

import br.java.tp.dao.PacienteDAO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author paulo
 */
public class PacienteBean {
    private Integer idPaciente;
    private String nome;
    private String dataNasc;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;

    public PacienteBean() 
    {}

    public PacienteBean(Integer idPasciente) {
        this.idPaciente = idPasciente;
    }

    public PacienteBean(Integer idPaciente, String nome, String dataNasc, 
            String logradouro, String numero, String bairro, String cidade, 
            String uf) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
     public boolean cadastrarPaciente(){
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.setIdPaciente(null);
        pacienteDAO.setNome(nome);
        Timestamp d = new Timestamp(Integer.parseInt(dataNasc.substring(0, 4)), 
                Integer.parseInt(dataNasc.substring(5, 7)), 
                Integer.parseInt(dataNasc.substring(8, 10)), 0, 0, 0, 0);
        pacienteDAO.setDataNasc(d);
        pacienteDAO.setLogradouro(logradouro);
        pacienteDAO.setNumero(numero);
        pacienteDAO.setBairro(bairro);
        pacienteDAO.setCidade(cidade);
        pacienteDAO.setUf(uf);
        return pacienteDAO.cadastrarPaciente();
    }
    
    public List<PacienteBean> listarPacientes(){
        PacienteDAO pacienteDAO = new PacienteDAO();
        Date d = new Date(2010, 10, 5);
        if (pacienteDAO.getPacientes()!=null){
            List<PacienteBean> pacienteBeans = new ArrayList();
            for (PacienteDAO p: pacienteDAO.getPacientes()){
                pacienteBeans.add(new PacienteBean(p.getIdPaciente(), p.getNome(), p.getDataNasc().toString(), 
                        p.getLogradouro(), p.getNumero(), p.getBairro(), p.getCidade(), p.getUf()));
            }
            return pacienteBeans;
        }
        return null;
    }
    
    public void removerPaciente(Integer idPaciente){
        PacienteDAO pacienteDAO = new PacienteDAO(idPaciente);
        pacienteDAO.deletarPaciente();
    }
    
    public PacienteBean obterPaciente(){
        PacienteDAO p = new PacienteDAO(idPaciente);
        return new PacienteBean(p.getIdPaciente(), p.getNome(), p.getDataNasc().toString(), 
              p.getLogradouro(), p.getNumero(), p.getBairro(), p.getCidade(), p.getUf());
    }
    
    public void alterarPaciente(){
        Timestamp d = new Timestamp(Integer.parseInt(dataNasc.substring(0, 4)), 
                Integer.parseInt(dataNasc.substring(6, 8)), 
                Integer.parseInt(dataNasc.substring(9, (dataNasc.length()-1))), 0, 0, 0, 0);        
        PacienteDAO p = new PacienteDAO(idPaciente, nome, d, logradouro, 
                numero, bairro, cidade, uf);
        p.alterarPaciente();
    }
    
}
