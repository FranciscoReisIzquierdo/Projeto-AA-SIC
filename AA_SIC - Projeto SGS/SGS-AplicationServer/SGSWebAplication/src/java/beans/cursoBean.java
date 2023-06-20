/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;
import sgs.Curso;

/**
 *
 * @author franc
 */
@Stateless
public class cursoBean implements cursoBeanLocal {

    private static PersistentSession session = null;
    private static sgs.CursoFunctions cursoFunctions = new sgs.CursoFunctions();
    
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
    public boolean createCurso(String codigo, String nome, Integer duracao, String descricao){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                boolean result = cursoFunctions.createCurso(codigo, nome, duracao, descricao);
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
    public boolean updateCurso(String codigo, String nome, Integer duracao, String descricao){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                boolean result = cursoFunctions.updateCurso(codigo, nome, duracao, descricao);
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
    public boolean deleteCurso(String codigo){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                boolean result = cursoFunctions.deleteCurso(codigo);
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
    public List<Curso> getAllCursos(){
        try{
            return cursoFunctions.getAllCursos();
        }
        catch (Exception e) {
            return null;
        }
    }
}
