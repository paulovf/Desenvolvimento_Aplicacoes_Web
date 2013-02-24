/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.bean;

import br.java.tp.dao.PacienteDAO;
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
    private Date dataNasc;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private boolean achou;
    private List<PacienteBean> pacienteBeans = new ArrayList();
    private String mensagemRetorno;     

    public PacienteBean() 
    {}

    public PacienteBean(Integer idPasciente) {
        this.idPaciente = idPasciente;
    }

    public PacienteBean(Integer idPaciente, String nome, Date dataNasc, 
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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
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
        
    public String cadastrarPaciente(){
        if(nome.equalsIgnoreCase("") || dataNasc == null || logradouro.equalsIgnoreCase("")
                || numero.equalsIgnoreCase("") || bairro.equalsIgnoreCase("") ||
                cidade.equalsIgnoreCase("") || uf.equalsIgnoreCase("")){
           limparDadosPaciente();
           setMensagemRetorno("preencha todos os campos corretamente");
           return "error";
        }else{
            PacienteDAO pacienteDAO = new PacienteDAO();
            pacienteDAO.setIdPaciente(null);
            pacienteDAO.setNome(nome);
            pacienteDAO.setDataNasc(dataNasc);
            pacienteDAO.setLogradouro(logradouro);
            pacienteDAO.setNumero(numero);
            pacienteDAO.setBairro(bairro);
            pacienteDAO.setCidade(cidade);
            pacienteDAO.setUf(uf);
            if(pacienteDAO.getPaciente() == null){
                pacienteDAO.cadastrarPaciente();
                return "ok";
            }
            else{
                limparDadosPaciente();
                setMensagemRetorno("Paciente já cadastrado");
                return "error";
            }            
        }
    }
    
    public List<PacienteBean> listarPacientes(){
        PacienteDAO pacienteDAO = new PacienteDAO();
        if (pacienteDAO.getPacientes()!=null){
            List<PacienteBean> pacienteBeans = new ArrayList();
            for (PacienteDAO p: pacienteDAO.getPacientes()){
                pacienteBeans.add(new PacienteBean(p.getIdPaciente(), p.getNome(), p.getDataNasc(), 
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
        return new PacienteBean(p.getIdPaciente(), p.getNome(), p.getDataNasc(),
              p.getLogradouro(), p.getNumero(), p.getBairro(), p.getCidade(), p.getUf());
    }
    
    public void alterarPaciente(){       
        PacienteDAO p = new PacienteDAO(idPaciente, nome, dataNasc, logradouro, 
                numero, bairro, cidade, uf);
        p.alterarPaciente();
    }
    
    public void limparDadosPaciente(){
        setIdPaciente(null);
        setNome("");
        setLogradouro("");
        setBairro("");
        setCidade("");
        setNumero("");
        setIdPaciente(null);
        setUf("");
        setMensagemRetorno("");
    }
    
    public String listar(){
        return "listar";
    }    
}