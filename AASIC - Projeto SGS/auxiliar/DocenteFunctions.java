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
public class DocenteFunctions {
    
    public boolean createDocente(String nome, Integer idade, String cartao, String email, String senha, String departamento) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        boolean result = false;
        try {
        sgs.Docente docente = sgs.DocenteDAO.createDocente();
        
        docente.setNome(nome);
        docente.setSenha(senha);
        docente.setEmail(email);
        docente.setIdade(idade);
        docente.setCartao(cartao);
        docente.setDepartamento(departamento);
        
        result = sgs.DocenteDAO.save(docente);
        t.commit();
        }
        catch (Exception e) {
            t.rollback();
        }
        return result;
    }
    
    
    public boolean updateDocente(String nome, Integer idade, String cartao, String email, String senha, String departamento) throws PersistentException{
    PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
    try {
        sgs.Docente docente = sgs.DocenteDAO.getDocenteByORMID(email);


        if (nome != null && !nome.equals("")){
            docente.setNome(nome);
        }
        if (idade != null && idade > 0){
            docente.setIdade(idade);
        }
        if (cartao != null && !cartao.equals("")){
            docente.setCartao(cartao);
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
    }
    catch (Exception e){
        t.rollback();
        return false;
    }
    return true;
}
          
    
    public boolean deleteDocente(String email) throws PersistentException{
        sgs.Docente docente = sgs.DocenteDAO.getDocenteByORMID(email);
        boolean done = sgs.DocenteDAO.delete(docente);
        return done;
    }
    
    public sgs.Docente[] getAllDocentes() throws PersistentException{
        return sgs.DocenteDAO.listDocenteByQuery(null, null);
    }
}