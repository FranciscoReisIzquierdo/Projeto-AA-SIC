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
public class AdministradorFunctions {
    public boolean createAdministrador(String email, String nome, String senha) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        boolean result = false;
        try {
        sgs.Administrador admin = sgs.AdministradorDAO.createAdministrador();
        
        admin.setNome(nome);
        admin.setSenha(senha);
        admin.setEmail(email);
        
        result = sgs.AdministradorDAO.save(admin);
        t.commit();
        }
        catch (Exception e) {
            t.rollback();
        }
        return result;
    }
    
    public String login(String email, String pass) throws PersistentException{
        try{
            sgs.Administrador admin = sgs.AdministradorDAO.getAdministradorByORMID(email);
            if(pass.equals(admin.getSenha())) return "Administrador";
            else return "Senha incorreta";
        }
        catch(Exception e){
            return "Email invalido";
        }
    }
}
