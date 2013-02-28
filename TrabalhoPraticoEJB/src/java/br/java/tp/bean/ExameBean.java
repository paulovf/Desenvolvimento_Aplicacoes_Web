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
    private String mensagemRetornoErro[] = new String[3], mensagemRetornoOK;

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

    public String[] getMensagemRetornoErro() {
        return mensagemRetornoErro;
    }

    public void setMensagemRetornoErro(String mensagemRetornoErro, Integer indice) {
        this.mensagemRetornoErro[indice] = mensagemRetornoErro;
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
        limparMensagemErro();
        if(nome.length() < 3){
            setMensagemRetornoErro("Forneça um nome válido", 0);
            return "error";
        }
        if(valor <= 0.0){
            setMensagemRetornoErro("Forneça um valor válido!", 1);
            return "error";
        }else{
            ExameDAO exameDAO = new ExameDAO();
            exameDAO.setIdExame(null);
            exameDAO.setValor(valor);
            exameDAO.setNome(nome);
            if (exameDAO.getExame() == null){
                exameDAO.cadastrarExame();
                limparDadosExame();
                setMensagemRetornoOK("Exame cadastardo com sucesso!");
                return "ok";
            }else{
                limparDadosExame();
                setMensagemRetornoErro("Exame já cadastrado", 2);
                return "error";
            }
        }
    }
    
    public List<ExameBean> listarExames(){
        limparDadosExame();
        ExameDAO exameDAO = new ExameDAO();
        if (exameDAO.getExames()!=null){
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
    
    public ExameBean obterExames(String nome){
        limparDadosExame();
        ExameDAO e = new ExameDAO(nome);
        e = e.getExame();
        return new ExameBean(e.getNome(), e.getValor(), e.getIdExame());
    }
    
    public String obterExame(){
        try{
            ExameDAO e = new ExameDAO(nome);
            ExameDAO exameDAO2 = e.getExame();
            if (exameDAO2.getIdExame() != null){
                idExame = exameDAO2.getIdExame();
                nome = exameDAO2.getNome();
                valor = exameDAO2.getValor();
                return "ok";
            }else{
                setMensagemRetornoErro("Exame não cadastrado.", 2);
                return "error";
            }
        }catch(Exception e){
            setMensagemRetornoErro("Exame não cadastrado.", 2);
            return "error";
        }
    }    
    
    public String alterarExame(){
        limparMensagemErro();
        if(nome.length() < 3){
            setMensagemRetornoErro("Forneça um nome válido", 0);
            return "error";
        }
        if(valor <= 0){
            setMensagemRetornoErro("Forneça um valor válido!", 1);
            return "error";
        }else{
            ExameDAO e = new ExameDAO(nome, valor, idExame);
            if (e.alterarExame()){
                limparDadosExame();
                setMensagemRetornoOK("alteração realizada com sucesso");
                return "ok";
            }else{
                setMensagemRetornoErro("Erro ao alterar Exame", 2);
                return "erro";
            }
        }
    }
    
    public String loadExame(String nome){
        limparDadosExame();
        ExameDAO exameDAO = new ExameDAO(nome);
        ExameDAO e = exameDAO.getExame();
        if(e != null){
            limparDadosExame();
            idExame = e.getIdExame();
            this.nome = e.getNome();
            valor = e.getValor();
            return "ok_alterar";
        }
        else{
            setMensagemRetornoErro("Por favor, selecione um Exame", 2);
            return "error";
        }
    }    
       
    public void limparDadosExame(){
        setIdExame(null);
        setNome("");
        setValor(0);
        limparMensagemErro();
    }
    
    public void limparMensagemErro(){
        int i = 0;
        while(i < mensagemRetornoErro.length){
            mensagemRetornoErro[i] = null;
            i++;
        }
    }
     
    

}