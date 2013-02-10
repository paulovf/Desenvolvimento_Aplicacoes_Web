/**
 * Classe Conexao
 * Esta classe é responsável por criar o gerente de entidade.
 */
package br.java.tp.bd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author paulo
 */
public class Conexao {
    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;
    
        public static EntityManager getManager(){
        try{
            if (entityManagerFactory == null){
                entityManagerFactory = Persistence.createEntityManagerFactory("JPATeste2PU");
                entityManager = entityManagerFactory.createEntityManager();
            }else{
                if(entityManager == null){
                    entityManager = entityManagerFactory.createEntityManager();
                }
            }//if/else
            return entityManager;
            
        }catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Erro na conexãocom o banco de dados");
            return null;
        }//try/catch
    }
}
