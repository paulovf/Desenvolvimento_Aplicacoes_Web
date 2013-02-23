/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.tp.dao;

import br.java.tp.bd.Conexao;
import br.java.tp.classes.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Paulo Vitor
 */
public class UsuariosDAO {
    private String nome;
    private String login;
    private String senha;
    private Integer id;

    public UsuariosDAO() 
    {}

    public UsuariosDAO(Integer id) {
        this.id = id;
    }
    
    public UsuariosDAO(String nome, String login, String senha, Integer id) {
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
    
    public EntityManager conecta(){
        EntityManager em = Conexao.getManager();
        return em;
    }
    
    public boolean cadastrarUsuarios(){
        try{
            if(conecta() != null){
                Usuarios c = new Usuarios();

                c.setId(null);
                c.setNome(nome);
                c.setLogin(login);
                c.setSenha(senha);

                conecta().getTransaction().begin();
                conecta().persist(c);
                conecta().getTransaction().commit();
                return true;
            }
            else{
                return false;
            }
        }catch(Exception e){
            if (conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }
            return false;
        }
    }
    
    public void alterarUsuarios(){
        try{
            if(conecta() != null){
                Usuarios c = conecta().find(Usuarios.class, id);
                c.setNome(nome);
                c.setLogin(login);
                c.setSenha(senha);
                
                conecta().getTransaction().begin();
                conecta().persist(c);
                conecta().getTransaction().commit();
            }
        }catch(Exception e){
            if(conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }                                
        }          
    }

    public void deletarUsuarios(){
        try{
            if(conecta() != null){
                Usuarios c = conecta().find(Usuarios.class, id);

                conecta().getTransaction().begin();
                conecta().remove(c);
                conecta().getTransaction().commit();
            }
        }catch(Exception e){
            if(conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }                                
        }        
    }
    
    public UsuariosDAO getCliente(){
        try{
            if(conecta() != null){
                Query q = conecta().createQuery("SELECT u FROM Usuarios u WHERE u.id =:id");
                q.setParameter("id", id);
                if (q.getSingleResult()!=null){
                    Usuarios c = (Usuarios) q.getSingleResult();
                    UsuariosDAO clienteDAO = new UsuariosDAO(c.getNome(), c.getLogin(), c.getSenha(), c.getId());
                    return clienteDAO;
                }
            }
            return null;
        }catch(Exception e){
            if(conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }                
        }
        
        return null;
    }
    
    public List<UsuariosDAO> getUsuarios(){
        try{
            if(conecta() != null){
                Query q = conecta().createQuery("SELECT u FROM Usuarios u");

                List<Usuarios> lista = q.getResultList();
                List<UsuariosDAO> listaClienteDao = new ArrayList();

                for(Usuarios c: lista){
                    listaClienteDao.add(new UsuariosDAO(c.getNome(), c.getLogin(), c.getSenha(), c.getId()));
                }
                return listaClienteDao;
            }else{
                return null;
            }
        }catch(Exception e){
            return null;
        }
    }
    
    public UsuariosDAO validarUsuarios(){
        try{
            if(conecta() != null){
                Query query = conecta().createQuery("SELECT u FROM Usuarios u WHERE u.login =:login");
                query.setParameter("login", login);
                if (query.getSingleResult()!= null){
                    Usuarios u = (Usuarios) query.getSingleResult();
                    UsuariosDAO usuariosDAO = new UsuariosDAO(u.getNome(), u.getLogin(), 
                            u.getSenha(), u.getId());
                    return usuariosDAO;
                }
            }
            return null;
        }catch(Exception e){
            if(conecta().getTransaction().isActive()){
                conecta().getTransaction().rollback();
            }                
        }
        return null;
    }
    
}
