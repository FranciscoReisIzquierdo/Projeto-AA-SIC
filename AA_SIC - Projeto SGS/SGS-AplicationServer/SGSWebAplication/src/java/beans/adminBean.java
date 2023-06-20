/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import javax.ejb.Stateless;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

/**
 *
 * @author franc
 */
@Stateless
public class adminBean implements adminBeanLocal {

    private static PersistentSession session = null;
    private static sgs.AdministradorFunctions adminFunctions = new sgs.AdministradorFunctions();
    
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
    public boolean createAdministrador(String email, String nome, String senha){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            boolean result = true;
            try{
                result = adminFunctions.createAdministrador(email, nome, senha);
                t.commit();
                return result;
            }
            catch (Exception e) {
                t.rollback();
            }
        }
        catch (Exception e) {
            return false;
        }
        return false;
    }
    
    @Override
    public String login(String email, String pass){
        try{
            return adminFunctions.login(email, pass);
        }
        catch(Exception e){
            return "";
        }
    }
}
