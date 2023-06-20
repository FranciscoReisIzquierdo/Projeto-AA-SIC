/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

/**
 *
 * @author franc
 */
@Stateless
public class docenteBean implements docenteBeanLocal {

    private static PersistentSession session = null;
    private static sgs.DocenteFunctions docenteFunctions = new sgs.DocenteFunctions();
    
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
    public boolean createDocente(String email, String nome, Integer idade, 
            String cartao, String senha, String departamento, Character genero){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                boolean result = docenteFunctions.createDocente(email, nome, idade, cartao, senha, departamento, genero);
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
    public String updateDocente(String email, String nome, Integer idade, String cartao, String senha,
            String departamento, Character genero){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = docenteFunctions.updateDocente(email, nome, idade, cartao, senha, departamento, genero);
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
    public boolean deleteDocente(String email){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                boolean result = docenteFunctions.deleteDocente(email);
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
    public List<sgs.Docente> getAllDocentes(){
        try{
            return docenteFunctions.getAllDocentes();
        }
        catch (Exception e) {
            return null;
        }
    }
}
