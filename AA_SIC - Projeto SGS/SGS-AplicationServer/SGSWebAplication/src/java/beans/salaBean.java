/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;
import sgs.Evento;

/**
 *
 * @author franc
 */
@Stateless
public class salaBean implements salaBeanLocal {
    
    private static PersistentSession session = null;
    private static sgs.SalaFunctions salaFunctions = new sgs.SalaFunctions();
    
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
    public boolean createSala(String codigo, String localizacao, int capacidade){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            boolean result = true;
            try{
                result = salaFunctions.createSala(codigo, localizacao, capacidade);
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
    public boolean updateCapacidade(String codigo, Integer capacidade){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            boolean result = true;
            try {
                result = salaFunctions.updateCapacidade(codigo, capacidade);
                t.commit();
                return result;
            }
            catch (Exception e){
                t.rollback();
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }
    
    @Override
    public boolean deleteSala(String codigo){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            boolean result = true;
            try {
                result = salaFunctions.deleteSala(codigo);
                t.commit();
                return result;
            }
            catch (Exception e){
                t.rollback();
                return false;
            }
        }
        catch (Exception e){
                return false;
            }
    }
    
    @Override
    public boolean isValid(String codSala){
        try{
            return salaFunctions.isValid(codSala);
        }
        catch (Exception e){
            return false;
        }
    }
    
    @Override
    public List<String> salaInfo(String codSala){
        try{
            return salaFunctions.salaInfo(codSala);
        }
        catch (Exception e){
            return null;
        }
    }
    
    @Override
    public boolean checkCartao(String codSala, String email){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            boolean result = true;
            try {
                result = salaFunctions.checkCartao(codSala, email);
                t.commit();
                return result;
            }
            catch (Exception e){
                t.rollback();
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }
    
    @Override
    public List<sgs.Sala> getAllSalas(){
        try {
            return salaFunctions.getAllSalas();
        }
        catch (Exception e){
            return null;
        }
    }
}
