/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgs;

import java.util.Arrays;
import java.util.List;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 *
 * @author franc
 */
public class DocenteFunctions {
    
    public boolean createDocente(String email, String nome, Integer idade, String cartao, String senha, String departamento, Character genero){
        try{
            if(UtilizadorDAO.getUtilizadorByORMID(email) != null || AlunoDAO.getAlunoByORMID(email) != null
                    || DocenteDAO.getDocenteByORMID(email) != null || AdministradorDAO.getAdministradorByORMID(email) != null) return false;
            PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
            boolean result = false;
            try {
            sgs.Docente docente = sgs.DocenteDAO.createDocente();

            docente.setNome(nome);
            docente.setSenha(senha);
            docente.setEmail(email);
            docente.setIdade(idade);
            docente.setNumero(cartao);
            docente.setDepartamento(departamento);
            docente.setGenero(genero);

            result = sgs.DocenteDAO.save(docente);
            t.commit();
            }
            catch (Exception e) {
                t.rollback();
            }
            return result;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    
    public String updateDocente(String email, String nome, Integer idade, String cartao, String senha, String departamento, Character genero){
        try{
            PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
            try {
                sgs.Docente docente = sgs.DocenteDAO.getDocenteByORMID(email);


                if (nome != null && !nome.equals("")){
                    docente.setNome(nome);
                }
                if (genero != null && !genero.equals("")){
                    docente.setGenero(genero);
                }
                if (idade != null && idade > 0){
                    docente.setIdade(idade);
                }
                if (cartao != null && !cartao.equals("")){
                    docente.setNumero(cartao);
                }
                if (email != null && !email.equals("")){
                    docente.setEmail(email);
                }
                if (senha != null && !senha.equals("")){
                    docente.setSenha(senha);
                }
                if (departamento != null && !departamento.equals("")){
                    docente.setDepartamento(departamento);
                }
                t.commit();
                return "true";
            }
            catch (Exception e){
                t.rollback();
                return "";
            }
        }
        catch (Exception e){
                return "";
            }
    }

          
    
    public boolean deleteDocente(String email){
        try{
            PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
            try {
                sgs.Docente docente = sgs.DocenteDAO.getDocenteByORMID(email);
                DisciplinaFunctions disciplinaFunctions = new sgs.DisciplinaFunctions();
                List<sgs.Disciplina> allDisciplinas = Arrays.asList(disciplinaFunctions.getAllDisciplinas());
                for(sgs.Disciplina disciplina: allDisciplinas) if(disciplina.getDocente() == docente) disciplina.setDocente(null);

                AulaFunctions aulaFunctions = new sgs.AulaFunctions();

                List<sgs.Aula> allAulas = aulaFunctions.getAllAulas();
                for(Aula aula : allAulas) if(aula.getDocente() == docente) aula.setDocente(null);

                ConferenciaFunctions conferenciaFunctions = new sgs.ConferenciaFunctions();

                List<sgs.Conferencia> allConferencias =  Arrays.asList(conferenciaFunctions.getAllConferencias());
                for(Conferencia conf : allConferencias){
                    if(!conf.getLivre() && conf.inscritos.contains(docente)) conf.inscritos.remove(docente);
                }

                boolean done = sgs.DocenteDAO.delete(docente);
                t.commit();
                return done;
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
    
    public sgs.Docente[] getAllDocentes(){
        try{
            return sgs.DocenteDAO.listDocenteByQuery(null, null);
        }
        catch (Exception e){
            return null;
        }
    }
}