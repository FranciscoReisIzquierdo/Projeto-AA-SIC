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
public class CursoFunctions {
    
    private String encodeString(String s){
        return "_" + s.replace(" ", "_");
    }
    
    public boolean updateCurso(String nome, Integer duracao, String descricao) throws PersistentException{
    PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
    try {
        sgs.Curso curso = sgs.CursoDAO.getCursoByORMID(nome);

        if (duracao != null && duracao > 0){
            curso.setDuracao(duracao);
        }
        if (descricao != null && descricao.equals("")){
            curso.setDescricao(descricao);
        }
        sgs.CursoDAO.save(curso);
        t.commit();
    }
    catch (Exception e){
        t.rollback();
        return false;
    }
    return true;
}
    
    public boolean createCurso(String nome, Integer duracao, String descricao) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        boolean result = false;
        try {
        sgs.Curso curso = sgs.CursoDAO.createCurso();
        curso.setNome(nome);
        curso.setDuracao(duracao);
        curso.setDescricao(descricao);
        
        result = sgs.CursoDAO.save(curso);
        t.commit();
        }
        catch (Exception e) {
            t.rollback();
        }
        return result;
    }
    
    
    public boolean deleteCurso(String nome) throws PersistentException{
        sgs.Curso curso = sgs.CursoDAO.getCursoByORMID(nome);
        boolean done = sgs.CursoDAO.delete(curso);
        return done;
    }
    
    public sgs.Curso[] getAllCursos() throws PersistentException{
        return sgs.CursoDAO.listCursoByQuery(null, null);
    }
}
