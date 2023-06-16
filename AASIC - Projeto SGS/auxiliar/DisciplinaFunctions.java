/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package sgs;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 *
 * @author franc
 */
public class DisciplinaFunctions{
    
    public boolean createDsciplina(String nome, String nomeCurso, String emailDocente, String descricao, Integer carga) throws PersistentException{
    PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
    boolean result = false;
    try {
        sgs.Disciplina disc = sgs.DisciplinaDAO.createDisciplina();
        
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
    
    public boolean updateDisciplina(String nome, String nomeCurso, String emailDocente, String descricao, Integer carga) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        try {
            sgs.Disciplina disc = sgs.DisciplinaDAO.getDisciplinaByORMID(nome);

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
    
    public boolean deleteDisciplina(String nome) throws PersistentException{
        sgs.Disciplina disc = sgs.DisciplinaDAO.getDisciplinaByORMID(nome);
        boolean done = sgs.DisciplinaDAO.delete(disc);
        return done;
    }   
    
    public sgs.Disciplina[] getAllDisciplinas() throws PersistentException{
        return sgs.DisciplinaDAO.listDisciplinaByQuery(null, null);
    }
}