/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.bean;

import br.java.tp.dao.UsuariosDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Vitor
 */
public class UsuariosBean {
    private String nome;
    private String login;
    private String senha;
    private Integer id;
    private boolean achou;
    private List<UsuariosBean> usuariosBeans = new ArrayList();
    private String mensagemRetornoErro, mensagemRetornoOK;      

    public UsuariosBean() 
    {}

    public UsuariosBean(String nome, String login, String senha, Integer id) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<UsuariosBean> getUsuariosBeans() {
        return usuariosBeans;
    }

    public void setUsuariosBeans(List<UsuariosBean> usuariosBeans) {
        this.usuariosBeans = usuariosBeans;
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
    
    public void cadastrarUsuario(){
        
        if(!login.equalsIgnoreCase("") || !senha.equalsIgnoreCase("")){
            UsuariosDAO usuariosDAO = new UsuariosDAO();
            usuariosDAO.setId(null);
            usuariosDAO.setNome(nome);
            usuariosDAO.setLogin(login);
            usuariosDAO.setSenha(senha);
           
            if (usuariosDAO.cadastrarUsuarios()){
                limparDadosUsuario();
                setMensagemRetornoOK("Usuario cadstrado com sucesso.");
            }
            else{
                setMensagemRetornoErro("Usuario já cadastrado ou incorreto.");
            }            
        }
    }
    
    public List<UsuariosBean> listarUsuarios(){
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        if (usuariosDAO.getUsuarios()!=null){
            List<UsuariosBean> clientesBean = new ArrayList();
            for (UsuariosDAO c: usuariosDAO.getUsuarios()){
                clientesBean.add(new UsuariosBean(c.getNome(), c.getLogin(), c.getSenha(), c.getId()));
            }
            return clientesBean;
        }
        return null;
    }
    
    public void removerUsuarios(Integer id){
        UsuariosDAO usuariosDAO = new UsuariosDAO(id);
        usuariosDAO.deletarUsuarios();
    }
    
    public UsuariosBean obterUsuarios(){
        UsuariosDAO c = new UsuariosDAO(id);
        return new UsuariosBean(c.getNome(), c.getLogin(), c.getSenha(), c.getId());
    }
    
    public void alterarUsuarios(){
        UsuariosDAO c = new UsuariosDAO(nome, login, senha, id);
        c.alterarUsuarios();
    }
        
    public String validarLogin(){
        UsuariosDAO usuariosDAO = new UsuariosDAO(nome, login, senha, id);
        UsuariosDAO usuarioDAO2 = usuariosDAO.validarUsuarios();
        if(usuarioDAO2 != null){
            if(usuarioDAO2.getSenha().equalsIgnoreCase(senha)){
                return "ok";
            }else{
                setMensagemRetornoErro("Usuário não cadastrado ou login incorreto");
                return "error";
            }
        }
        else{
            setMensagemRetornoOK("Usuário não cadastrado ou login incorreto");
            return "error";
        }
    }
       
    public void limparDadosUsuario(){
        setId(null);
        setLogin("");
        setSenha("");
        setMensagemRetornoErro("");
        setMensagemRetornoOK("");
    }
    
    public String listar(){
        return "listar";
    }    
    
}
