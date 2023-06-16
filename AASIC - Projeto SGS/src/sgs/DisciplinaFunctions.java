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
    
    public boolean createDsciplina(String nome, String codigo, String nomeCurso, String emailDocente, String descricao, Integer carga) throws PersistentException{
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
    
    public boolean updateDisciplina(String nome, String codigo, String nomeCurso, String emailDocente, String descricao, Integer carga) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        try {
            sgs.Disciplina disc = sgs.DisciplinaDAO.getDisciplinaByORMID(codigo);
            if (nome != null && !nome.equals("")){
                disc.setNome(nome);
            }
            if (nomeCurso != null && !nomeCurso.equals("")){
                sgs.Curso curso = sgs.CursoDAO.getCursoByORMID(nomeCurso);
                disc.setCurso(curso);
            }
            if (emailDocente != null && !emailDocente.equals("")){
                sgs.Docente docente = sgs.DocenteDAO.getDocenteByORMID(emailDocente);
                disc.setDocente(docente);
            }
            if (descricao != null && !descricao.equals("")){
                disc.setDescricao(descricao);
            }
            if (carga != null && carga > 0){
                disc.setCargaHoraria(carga);
            }
            t.commit();
        }
        catch (Exception e){
            t.rollback();
            return false;
        }
        return true;
    }
    
    public boolean deleteDisciplina(String codigo) throws PersistentException{
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
    
    public sgs.Disciplina[] getAllDisciplinas() throws PersistentException{
        return sgs.DisciplinaDAO.listDisciplinaByQuery(null, null);
    }
}