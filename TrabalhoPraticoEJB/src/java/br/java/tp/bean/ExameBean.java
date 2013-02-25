/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.bean;

import br.java.tp.dao.ExameDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulo
 */
public class ExameBean {
    private String nome;
    private float valor;
    private Integer idExame;
    private boolean achou;
    private List<ExameBean> exameBeans = new ArrayList();
    private String mensagemRetornoErro, mensagemRetornoOK;

    public ExameBean() {
    }

    public ExameBean(String nome, float valor, Integer idExame) {
        this.nome = nome;
        this.valor = valor;
        this.idExame = idExame;
    }

    public boolean isAchou() {
        return achou;
    }

    public void setAchou(boolean achou) {
        this.achou = achou;
    }

    public List<ExameBean> getExameBeans() {
        return exameBeans;
    }

    public void setExameBeans(List<ExameBean> exameBeans) {
        this.exameBeans = exameBeans;
    }

    public Integer getIdExame() {
        return idExame;
    }

    public void setIdExame(Integer idExame) {
        this.idExame = idExame;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public String cadastrarExame(){
        if(nome.equalsIgnoreCase("")){
            limparDadosExame();
            setMensagemRetornoErro("Forneça um nome válido");
            return "error";
        }else if (valor <= 0.0){
            limparDadosExame();
            setMensagemRetornoErro("Forneça um valor válido");
            return "error";
        }
        else{
                if (validarExame().equals("ok")){
                    ExameDAO exameDAO = new ExameDAO();
                    exameDAO.setIdExame(null);
                    exameDAO.setNome(nome);
                    exameDAO.setValor(valor);
                    exameDAO.cadastrarExame();
                    limparDadosExame();
                    setMensagemRetornoOK("Exame cadastrado com sucesso!");
                    return "ok";
                }else{
                    limparDadosExame();
                    setMensagemRetornoErro("Exame já cadastrado");
                    return "error";
                }
        }
    }
    
    public List<ExameBean> listarExame(){
        ExameDAO exameDAO = new ExameDAO();
        if (exameDAO.getIdExame()!=null){
            List<ExameBean> exameBean = new ArrayList();
            for (ExameDAO e: exameDAO.getExames()){
                exameBean.add(new ExameBean(e.getNome(), e.getValor(), e.getIdExame()));
            }
            return exameBean;
        }
        return null;
    }
    
    public void removerExame(Integer idExame){
        ExameDAO exameDAO = new ExameDAO(idExame);
        exameDAO.deletarExame();
    }
    
    public ExameBean obterExames(){
        ExameDAO e = new ExameDAO(idExame);
        return new ExameBean(e.getNome(), e.getValor(), e.getIdExame());
    }
    
    public String validarExame(){
        ExameDAO exameDAO = new ExameDAO(nome, valor, idExame);
        ExameDAO exameDAO2 = exameDAO.getExame();
        if(exameDAO2 != null){
            return "error";
        }
        else{
            return "ok";
        }
    }
       
    public void limparDadosExame(){
        setIdExame(null);
        setNome("");
        setValor(0);
        setMensagemRetornoOK("");
        setMensagemRetornoErro("");
    }
    
    public String listar(){
        return "listar";
    }    
    
    public void alterarExame(){
        ExameDAO e = new ExameDAO(nome, valor, idExame);
        e.alterarExame();
    }
}