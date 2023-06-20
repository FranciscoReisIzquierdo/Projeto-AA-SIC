/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;
import sgs.AdministradorDAO;
import sgs.Aluno;
import sgs.AlunoDAO;
import sgs.DocenteDAO;
import sgs.UtilizadorDAO;

/**
 *
 * @author franc
 */
@Stateless
public class alunoBean implements alunoBeanLocal {
    
    private static PersistentSession session = null;
    private static sgs.AlunoFunctions alunoFunctions = new sgs.AlunoFunctions();
    
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
     public String createAluno(String email, String nome, String senha, Integer idade, String cartao, Character genero, Integer ano, String nomeCurso){
        try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = alunoFunctions.createAluno(email, nome, senha, idade, cartao, genero, ano, nomeCurso);
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
     public String updateAluno(String email, String nome, Integer idade, String cartao, String senha, Character genero, Integer ano){
         try{
            PersistentTransaction t = getSession().beginTransaction();
            try{
                String result = alunoFunctions.updateAluno(email, nome, idade, cartao, senha, genero, ano);
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
    public boolean deleteAluno(String email){
       try{
           PersistentTransaction t = getSession().beginTransaction();
           try{
               boolean result = alunoFunctions.deleteAluno(email);
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
    public boolean inscreveAluno(List<String> discps, String email){
        try{
           PersistentTransaction t = getSession().beginTransaction();
           try{
               boolean result = alunoFunctions.inscreveAluno(discps, email);
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
    public List<Aluno> getAllAlunos(){
        try{
            return alunoFunctions.getAllAlunos();
        }
        catch (Exception e) {
            return null;
       }
    }
}
