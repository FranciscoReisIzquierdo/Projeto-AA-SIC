/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;
import sgs.Aluno;
import sgs.Aula;
import sgs.AulaDAO;
import sgs.DisciplinaDAO;
import sgs.SalaDAO;

/**
 *
 * @author franc
 */
@Stateless
public class aulaBean implements aulaBeanLocal {

    private static PersistentSession session = null;
    private static sgs.AulaFunctions aulaFunctions = new sgs.AulaFunctions();
    
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
    public String createAula(String codigo, String nome, long inicio, long fim, String codigoSala, String discNome, String turno){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = aulaFunctions.createAula(codigo, nome, inicio, fim, codigoSala, discNome, turno);
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
    public String updateAula(String codigo, String nome, Long horainicio, Long horafim, 
            String codigoSala, String discNome, String turno){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = aulaFunctions.updateAula(codigo, nome, horainicio, horafim, codigoSala, discNome, turno);
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
    public boolean deleteAula(String codigo){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                boolean result = aulaFunctions.deleteAula(codigo);
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
    public boolean checkHorario(String codigo, String codigoSala, long inicio, long fim){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                boolean result = aulaFunctions.checkHorario(codigo, codigoSala, inicio, fim);
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
    public List<sgs.Aula> getAllAulas(){
        try{
            return aulaFunctions.getAllAulas();
        }
        catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<sgs.Aula> getAllAulasPerDocente(String email){
        try{
            return aulaFunctions.getAllAulasPerDocente(email);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<sgs.Aluno> getPresencas(String nome){
        try{
            return aulaFunctions.getPresencas(nome);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public Aula getAula(String codigo){
        try{
            return aulaFunctions.getAula(codigo);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public String inscreveAula(String codigo, String email){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = aulaFunctions.inscreveAula(codigo, email);
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
    public String desinscreveAula(String codigo, String email){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = aulaFunctions.desinscreveAula(codigo, email);
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
