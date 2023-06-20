/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;
import sgs.Conferencia;

/**
 *
 * @author franc
 */
@Stateless
public class conferenciaBean implements conferenciaBeanLocal {

    private static PersistentSession session = null;
    private static sgs.ConferenciaFunctions confFunctions = new sgs.ConferenciaFunctions();
    
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
    public String createConferencia(String codigo, String nome, String codigoSala, long inicio, long fim, boolean livre, 
            String descricao, String orador, String tema){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = confFunctions.createConferencia(codigo, nome, codigoSala, inicio, fim, livre, descricao, orador, tema);
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
    public boolean checkHorario(String codigo, String codigoSala, long inicio, long fim){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                boolean result = confFunctions.checkHorario(codigo, codigoSala, inicio, fim);
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
    public String updateConferencia(String codigo, String nome, Long horainicio, Long horafim, boolean livre, 
        String descricao, String orador, String tema, String codigoSala){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = confFunctions.updateConferencia(codigo, nome, horainicio, horafim, livre, descricao, orador, tema, codigoSala);
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
    public boolean deleteConferencia(String codigo){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                boolean result = confFunctions.deleteConferencia(codigo);
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
    public List<Conferencia> getAllConferencias(){
        try{
            return confFunctions.getAllConferencias();
        }
        catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<Conferencia> getAllConfDisponiveis(){
        try{
            return confFunctions.getAllConfDisponiveis();
        }
        catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public String inscreveConferencia(String codigo, String email){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = confFunctions.inscreveConferencia(codigo, email);
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
    public String desinscreveConferencia(String codigo, String email){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = confFunctions.desinscreveConferencia(codigo, email);
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
}
