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
public class AlunoFunctions {
    
    public boolean createAluno(String nome, Integer idade, String cartao, String email, String senha, Integer ano, String nomeCurso) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        boolean result = false;
        try {
        sgs.Aluno aluno = sgs.AlunoDAO.createAluno();
        
        aluno.setNome(nome);
        aluno.setSenha(senha);
        aluno.setEmail(email);
        aluno.setIdade(idade);
        aluno.setCartao(cartao);
        aluno.setAno(ano);
        
        sgs.Curso curso = sgs.CursoDAO.getCursoByORMID(nomeCurso);
        aluno.setCurso(curso);
        
        result = sgs.AlunoDAO.save(aluno);
        t.commit();
        }
        catch (Exception e) {
            t.rollback();
        }
        return result;
    }
    
    
    public boolean updateAluno(String nome, Integer idade, String cartao, String email, String senha, Integer ano) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        try {
            sgs.Aluno aluno = sgs.AlunoDAO.getAlunoByORMID(email);


            if (nome != null && !nome.equals("")){
                aluno.setNome(nome);
            }
            if (idade != null && idade > 0){
                aluno.setIdade(idade);
            }
            if (cartao != null && !cartao.equals("")){
                aluno.setCartao(cartao);
            }
            if (senha != null && !senha.equals("")){
                aluno.setSenha(senha);
            }
            
            if (ano != null && ano > 0){
                aluno.setSenha(senha);
            }
            t.commit();
        }
        catch (Exception e){
            t.rollback();
            return false;
        }
        return true;
    }
          
    
    public boolean deleteAluno(String email) throws PersistentException{
        sgs.Aluno aluno = sgs.AlunoDAO.getAlunoByORMID(email);
        boolean done = sgs.AlunoDAO.delete(aluno);
        return done;
    }
    
}
