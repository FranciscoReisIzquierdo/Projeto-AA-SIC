/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package sgs;

import java.util.*;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 *
 * @author franc
 */
public class DisciplinaFunctions{
    
    public boolean createDisciplina(String codigo, String nome, String nomeCurso, String emailDocente, String descricao, Integer carga) throws PersistentException{
    PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
    boolean result = false;
    try {
        sgs.Disciplina disc = sgs.DisciplinaDAO.createDisciplina();
        disc.setCodigo(codigo);
        disc.setNome(nome);
        disc.setDescricao(descricao);
        disc.setCargaHoraria(carga);
        
        sgs.Curso curso = sgs.CursoDAO.getCursoByORMID(nomeCurso);
        disc.setCurso(curso);
        sgs.Docente docente = sgs.DocenteDAO.getDocenteByORMID(emailDocente);
        disc.setDocente(docente);
        result = sgs.DisciplinaDAO.save(disc);
        t.commit();
    }
    catch (Exception e) {
        t.rollback();
    }
    return result;
}
    
    public boolean updateDisciplina(String codigo, String nome, String nomeCurso, String emailDocente, String descricao, Integer carga){
        try{
            PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
            if(codigo!= null && !codigo.equals("")){
                try{
                    sgs.Disciplina disc = sgs.DisciplinaDAO.getDisciplinaByORMID(codigo);
                    if(disc != null && emailDocente != null && !emailDocente.equals("") && nomeCurso != null && !nomeCurso.equals("")
                        && nome != null && !nome.equals("") && descricao != null && !descricao.equals("")
                        && carga != null && carga > 0){
                        disc.setNome(nome);
                        disc.setDescricao(descricao);
                        disc.setCargaHoraria(carga);
                    try {
                        sgs.Curso curso = sgs.CursoDAO.getCursoByORMID(nomeCurso);
                        sgs.Docente docente = sgs.DocenteDAO.getDocenteByORMID(emailDocente);
                        if(curso != null) disc.setCurso(curso);
                        if(docente != null) disc.setDocente(docente);
                        t.commit();
                        return true;
                    }
                    catch (Exception e){
                        t.rollback();
                        return false;
                    }
                    }
                }
                catch (Exception e){
                    t.rollback();
                    return false;
                }
            }
        }
        catch (Exception e){
            return false;
        }
        return false;

    }
    
    public boolean deleteDisciplina(String codigo){
        try{
            PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
            try {
                sgs.Disciplina disc = sgs.DisciplinaDAO.getDisciplinaByORMID(codigo);

                List<sgs.Aluno> allAlunos = Arrays.asList(disc.inscritos.toArray());
                for(sgs.Aluno aluno: allAlunos) aluno.disciplinas.remove(disc);
                AulaFunctions aulaFunctions = new sgs.AulaFunctions();

                List<sgs.Aula> allAulas = aulaFunctions.getAllAulas();
                for(Aula aula : allAulas) if(aula.getDisciplina() == disc) aulaFunctions.deleteAula(aula.getCodigo());

                boolean done = sgs.DisciplinaDAO.delete(disc);
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
    
    public sgs.Disciplina[] getAllDisciplinas(){
        try{
            return sgs.DisciplinaDAO.listDisciplinaByQuery(null, null);
        }
        catch (Exception e){
            return null;
        }
    }
}