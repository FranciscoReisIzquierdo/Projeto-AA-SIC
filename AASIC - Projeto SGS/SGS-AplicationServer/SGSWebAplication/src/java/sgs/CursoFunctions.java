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
    
    public boolean updateCurso(String codigo, String nome, Integer duracao, String descricao){
        try{
            PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
            try {
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
                t.commit();
            }
            catch (Exception e){
                t.rollback();
                return false;
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
}
    
    public boolean createCurso(String nome, String codigo, Integer duracao, String descricao) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        boolean result = false;
        try {
        sgs.Curso curso = sgs.CursoDAO.createCurso();
        curso.setCodigo(codigo);
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
    
    
    public boolean deleteCurso(String codigo){
        try{
            sgs.Curso curso = sgs.CursoDAO.getCursoByORMID(codigo);
            boolean done = sgs.CursoDAO.delete(curso);
            return done;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public sgs.Curso[] getAllCursos(){
        try{
            return sgs.CursoDAO.listCursoByQuery(null, null);
        }
        catch (Exception e) {
            return null;
        }
    }
}
