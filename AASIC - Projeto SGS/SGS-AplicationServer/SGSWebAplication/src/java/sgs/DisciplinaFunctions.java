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
    
    public String createDisciplina(String codigo, String nome, String nomeCurso, String emailDocente, String descricao, Integer carga){
    try{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        if(DisciplinaDAO.getDisciplinaByORMID(codigo) != null) return "Já existe uma disciplina com o código " + codigo;
        boolean result = false;
        sgs.Curso curso = sgs.CursoDAO.getCursoByORMID(nomeCurso);
        if(curso == null) return "Nao existe nenhum curso com o codigo " + nomeCurso;
        sgs.Docente docente = sgs.DocenteDAO.getDocenteByORMID(emailDocente);
        if(docente == null) return "Nao existe nenhum docente com o email " + emailDocente;
        try {
            sgs.Disciplina disc = sgs.DisciplinaDAO.createDisciplina();
            disc.setCodigo(codigo);
            disc.setNome(nome);
            disc.setDescricao(descricao);
            disc.setCargaHoraria(carga);
            
            disc.setCurso(curso);
            disc.setDocente(docente);
            result = sgs.DisciplinaDAO.save(disc);
            t.commit();
            return "true";
        }
        catch (Exception e) {
            t.rollback();
        }
        return "";
    }
    catch (Exception e) {
        return "";
    }
}
    
    public String updateDisciplina(String codigo, String nome, String nomeCurso, String emailDocente, String descricao, Integer carga){
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
                        String message = "true";
                        sgs.Curso curso = sgs.CursoDAO.getCursoByORMID(nomeCurso);
                        sgs.Docente docente = sgs.DocenteDAO.getDocenteByORMID(emailDocente);
                        if(curso == null){
                            message = "Nao existe nenhum curso com o codigo " + nomeCurso;
                            
                        }
                        else disc.setCurso(curso);
                        
                        if(docente == null){
                            message = "Nao existe nenhum docente com o email " + emailDocente;
                            
                        }
                        else disc.setDocente(docente);
                        t.commit();
                        return message;
                    }
                    catch (Exception e){
                        t.rollback();
                        return "catch 1";
                    }
                    }
                }
                catch (Exception e){
                    t.rollback();
                    return "catch 2";
                }
            }
        }
        catch (Exception e){
            return "catch 3";
        }
        return "aaaaaaa";

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
    
    
    public String inscreveDisciplina(String codigo, String email){
        try{
            PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
            try{
                sgs.Disciplina discp = sgs.DisciplinaDAO.getDisciplinaByORMID(codigo);
                sgs.Aluno aluno = sgs.AlunoDAO.getAlunoByORMID(email);

                discp.inscritos.add(aluno);
                aluno.disciplinas.add(discp);
                t.commit();
                return "true";
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
    
    public String desinscreveDisciplina(String codigo, String email){
        try{
            PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
            try{
                sgs.Disciplina discp = sgs.DisciplinaDAO.getDisciplinaByORMID(codigo);
                sgs.Aluno aluno = sgs.AlunoDAO.getAlunoByORMID(email);

                discp.inscritos.remove(aluno);
                aluno.disciplinas.remove(discp);
                t.commit();
                return "false";
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
    
    
    public List<Disciplina> getAllDisciplinasPerCurso(String codigoCurso){
        try{
            List<Disciplina> filter = new ArrayList<>();
            List<Disciplina> allDisciplinas = Arrays.asList(getAllDisciplinas());
            for(Disciplina discp : allDisciplinas) if(discp.getCurso().getCodigo().equals(codigoCurso)) filter.add(discp);
            return filter;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public List<Aluno> getAllAlunosPerDiscp(String codigoDiscp){
        try{
            return Arrays.asList(DisciplinaDAO.getDisciplinaByORMID(codigoDiscp).inscritos.toArray());
        }
        catch (Exception e) {
            return null;
        }
    }
}