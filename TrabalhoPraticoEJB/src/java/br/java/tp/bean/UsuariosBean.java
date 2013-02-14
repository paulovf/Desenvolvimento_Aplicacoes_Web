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
    
    public boolean cadastrarUsuarios(){
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.setId(null);
        usuariosDAO.setNome(nome);
        usuariosDAO.setLogin(login);
        usuariosDAO.setSenha(senha);
        return usuariosDAO.cadastrarUsuarios();
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
    
    public UsuariosBean obterClientes(){
        UsuariosDAO c = new UsuariosDAO(id);
        return new UsuariosBean(c.getNome(), c.getLogin(), c.getSenha(), c.getId());
    }
    
    public void alterarClientes(){
        UsuariosDAO c = new UsuariosDAO(nome, login, senha, id);
        c.alterarUsuarios();
    }
    
    public String validarUsuarios(String login, String senha){
        UsuariosDAO c = new UsuariosDAO(nome, login, senha, id);
        return c.validarUsuarios();
    }    
    
}
