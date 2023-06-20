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
public class CursoFunctions {
    
    public boolean updateCurso(String codigo, String nome, Integer duracao, String descricao) throws PersistentException{
        sgs.Curso curso = sgs.CursoDAO.getCursoByORMID(codigo);
        if (nome != null && !nome.equals("")){
            curso.setNome(nome);
        }
        if (duracao != null && duracao > 0){
            curso.setDuracao(duracao);
        }
        if (descricao != null && !descricao.equals("")){
            curso.setDescricao(descricao);
        }
        sgs.CursoDAO.save(curso);
        return true;
    }   
    
    public boolean createCurso(String codigo, String nome, Integer duracao, String descricao) throws PersistentException{
        if(sgs.CursoDAO.getCursoByORMID(codigo) != null) return false;
        boolean result = false;
        sgs.Curso curso = sgs.CursoDAO.createCurso();
        curso.setCodigo(codigo);
        curso.setNome(nome);
        curso.setDuracao(duracao);
        curso.setDescricao(descricao);

        result = sgs.CursoDAO.save(curso);
        return result;
    }
    
    
    public boolean deleteCurso(String codigo) throws PersistentException{
        sgs.Curso curso = sgs.CursoDAO.getCursoByORMID(codigo);
        sgs.DisciplinaFunctions discpFunctions = new sgs.DisciplinaFunctions();
        List<sgs.Disciplina> allDisciplinas = discpFunctions.getAllDisciplinas();
        for(Disciplina disp : allDisciplinas){
            if(disp.getCurso().getCodigo().equals(codigo)) discpFunctions.deleteDisciplina(disp.getCodigo());
        } 
        boolean done = sgs.CursoDAO.delete(curso);
        return done;
    }
    
    public List<Curso> getAllCursos() throws PersistentException{
        return Arrays.asList(sgs.CursoDAO.listCursoByQuery(null, null));
    }
}
