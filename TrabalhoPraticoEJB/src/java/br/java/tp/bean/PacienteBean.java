/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.bean;

import br.java.tp.dao.PacienteDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.ListDataModel;

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
    private String mensagemRetornoErro, mensagemRetornoOK;

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

    public String getMensagemRetornoErro() {
        return mensagemRetornoErro;
    }

    public void setMensagemRetornoErro(String mensagemRetornoErro) {
        this.mensagemRetornoErro = mensagemRetornoErro;
    }

    public String getMensagemRetornoOK() {
        return mensagemRetornoOK;
    }

    public void setMensagemRetornoOK(String mensagemRetornoOK) {
        this.mensagemRetornoOK = mensagemRetornoOK;
    }

    public List<PacienteBean> getPacienteBeans() {
        return pacienteBeans;
    }

    public void setPacienteBeans(List<PacienteBean> pacienteBeans) {
        this.pacienteBeans = pacienteBeans;
    }
        
    public String cadastrarPaciente(){
        if(nome.equalsIgnoreCase("") || dataNasc == null || logradouro.equalsIgnoreCase("")
                || numero.equalsIgnoreCase("") || bairro.equalsIgnoreCase("") ||
                cidade.equalsIgnoreCase("") || uf.equalsIgnoreCase("")){
           limparDadosPaciente();
           setMensagemRetornoErro("preencha todos os campos corretamente");
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
                limparDadosPaciente();
                setMensagemRetornoOK("Paciente cadastrado com sucesso!");
                return "ok";
            }
            else{
                limparDadosPaciente();
                setMensagemRetornoErro("Paciente já cadastrado");
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
    
    public String alterarPaciente(){
        if(nome.equalsIgnoreCase("") || dataNasc == null || logradouro.equalsIgnoreCase("")
               || numero.equalsIgnoreCase("") || bairro.equalsIgnoreCase("") ||
              cidade.equalsIgnoreCase("") || uf.equalsIgnoreCase("")){
            setMensagemRetornoErro("preencha todos os campos corretamente");
           return "error";
        }else{
            PacienteDAO pacienteDAO = new PacienteDAO(idPaciente);
            if(pacienteDAO.getPaciente() == null){
                PacienteDAO p = new PacienteDAO(idPaciente, nome, dataNasc, logradouro, numero, bairro, cidade, uf);
                if (p.alterarPaciente()){
                    setMensagemRetornoOK("alteração realizada com sucesso");
                    return "ok";
                }else{
                    setMensagemRetornoErro("Erro ao alterar paciente");
                    return "erro";
                }
            }else{
                setMensagemRetornoErro("Paciente Já cadastrado");
                return "erro";
            }
        }
    }
    
    public String loadPaciente(Integer id){
        System.out.println("0");
        ListDataModel ldm = new ListDataModel(pacienteBeans);
        System.out.println("1");
        pacienteBeans = (List<PacienteBean>) ldm.getWrappedData();
                System.out.println("2");
        int pos = -1;
        for(int i = 0; i < pacienteBeans.size(); i++){
            if(pacienteBeans.get(i).getIdPaciente() == id){
                pos = i;
            }
        }
        System.out.println("3");
        if(pos > -1){
            System.out.println("4");
            nome = pacienteBeans.get(pos).getNome();
            idPaciente = pacienteBeans.get(pos).getIdPaciente();
            dataNasc = pacienteBeans.get(pos).getDataNasc();
            logradouro = pacienteBeans.get(pos).getLogradouro();
            numero = pacienteBeans.get(pos).getNumero();
            bairro = pacienteBeans.get(pos).getBairro();
            cidade = pacienteBeans.get(pos).getCidade();
            uf = pacienteBeans.get(pos).getUf();
            setMensagemRetornoOK("Paciente atualizado com sucesso");
            System.out.println("5");
            return "ok";
        }
        else{
            System.out.println("6");
            setMensagemRetornoErro("Por favor, selecione um cliente");
            return "error";
        }
    }    
    
    public void limparDadosPaciente(){
        setIdPaciente(null);
        setDataNasc(null);
        setNome("");
        setLogradouro("");
        setBairro("");
        setCidade("");
        setNumero("");
        setIdPaciente(null);
        setUf("");
        setMensagemRetornoErro("");
        setMensagemRetornoOK("");
    }
    
    public String listar(){
        return "listar";
    }    
}