/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;
import sgs.Utilizador;

/**
 *
 * @author franc
 */
@Stateless
public class utilizadorBean implements utilizadorBeanLocal {

    private static PersistentSession session = null;
    private static sgs.UtilizadorFunctions userFunctions = new sgs.UtilizadorFunctions();
    
    private static PersistentSession getSession() {
        if (session == null) {
            try {
                session = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return session;
    }
    
    @Override
    public String createUtilizador(String email, String nome, String senha, 
            Integer idade, String cartao, Character genero){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = userFunctions.createUtilizador(email, nome, senha, idade, cartao, genero);
                t.commit();
                return result;
            }
            catch (Exception e) {
                t.rollback();
                return "";
            }
        }
        catch (Exception e) {
            return "";
        }
    }
    
    @Override
    public String updateUtilizador(String email, String nome, String senha, 
            Integer idade, String cartao, Character genero){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = userFunctions.updateUtilizador(email, nome, senha, idade, cartao, genero);
                t.commit();
                return result;
            }
            catch (Exception e) {
                t.rollback();
                return "";
            }
        }
        catch (Exception e) {
            return "";
        }
    }
    
    @Override
    public boolean deleteUtilizador(String email){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                boolean result = userFunctions.deleteUtilizador(email);
                t.commit();
                return result;
            }
            catch (Exception e) {
                t.rollback();
                return false;
            }
        }
        catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public Utilizador getUtilizador(String email){
        try{
            return userFunctions.getUtilizador(email);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public String login(String email, String pass){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = userFunctions.login(email, pass);
                t.commit();
                return result;
            }
            catch (Exception e) {
                t.rollback();
                return "";
            }
        }
        catch (Exception e) {
            return "";
        }
    }
    
    @Override
    public String getNome(String email){
        try{
            return userFunctions.getNome(email);
        }
        catch (Exception e) {
            return "";
        }
    }
    
    @Override
    public List<String> getInfoUser(String email){
        try{
            return userFunctions.getInfoUser(email);
        }
        catch (Exception e) {
            return null;
        }
    }
}
