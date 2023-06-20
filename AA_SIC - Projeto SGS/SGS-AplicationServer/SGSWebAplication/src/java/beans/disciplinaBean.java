/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;
import sgs.Aluno;
import sgs.Disciplina;

/**
 *
 * @author franc
 */
@Stateless
public class disciplinaBean implements disciplinaBeanLocal {

    private static PersistentSession session = null;
    private static sgs.DisciplinaFunctions discpFunctions = new sgs.DisciplinaFunctions();
    
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
    public String createDisciplina(String codigo, String nome, String nomeCurso, String emailDocente, 
            String descricao, Integer carga){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = discpFunctions.createDisciplina(codigo, nome, nomeCurso, emailDocente, descricao, carga);
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
    public String updateDisciplina(String codigo, String nome, String nomeCurso, String emailDocente, 
            String descricao, Integer carga){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = discpFunctions.updateDisciplina(codigo, nome, nomeCurso, emailDocente, descricao, carga);
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
    public boolean deleteDisciplina(String codigo){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                boolean result = discpFunctions.deleteDisciplina(codigo);
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
    public List<Disciplina> getAllDisciplinas(){
        try{
            return discpFunctions.getAllDisciplinas();
        }
        catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public String inscreveDisciplina(String codigo, String email){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = discpFunctions.inscreveDisciplina(codigo, email);
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
    public String desinscreveDisciplina(String codigo, String email){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = discpFunctions.desinscreveDisciplina(codigo, email);
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
    public List<Disciplina> getAllDisciplinasPerCurso(String codigoCurso){
        try{
            return discpFunctions.getAllDisciplinasPerCurso(codigoCurso);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public List<Aluno> getAllAlunosPerDiscp(String codigoDiscp){
        try{
            return discpFunctions.getAllAlunosPerDiscp(codigoDiscp);
        }
        catch (Exception e) {
            return null;
        }
    }
}
