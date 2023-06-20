/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgs;

import org.orm.PersistentException;

/**
 *
 * @author franc
 */
public class AdministradorFunctions {
    public boolean createAdministrador(String email, String nome, String senha) throws PersistentException{
        boolean result = false;
        if(UtilizadorDAO.getUtilizadorByORMID(email) != null || AlunoDAO.getAlunoByORMID(email) != null
                    || DocenteDAO.getDocenteByORMID(email) != null || AdministradorDAO.getAdministradorByORMID(email) != null)
                return false;
        sgs.Administrador admin = sgs.AdministradorDAO.createAdministrador();
        admin.setNome(nome);
        admin.setSenha(senha);
        admin.setEmail(email);
        
        result = sgs.AdministradorDAO.save(admin);
        return result;
    }
    
    public String login(String email, String pass) throws PersistentException{
        sgs.Administrador admin = sgs.AdministradorDAO.getAdministradorByORMID(email);
        if(admin == null) return "Email invalido";
        if(pass.equals(admin.getSenha())) return "Administrador";
        else return "Senha incorreta";
        
    }
}
