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
public class UtilizadorFunctions {
    
    public boolean createUtilizador(String nome, Integer idade, String cartao, String email, String senha, Character genero) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        boolean result = false;
        try {
            sgs.Utilizador utilizador = sgs.UtilizadorDAO.createUtilizador();

            utilizador.setNome(nome);
            utilizador.setSenha(senha);
            utilizador.setEmail(email);
            utilizador.setIdade(idade);
            utilizador.setNumero(cartao);
            utilizador.setGenero(genero);
            
            result = sgs.UtilizadorDAO.save(utilizador);
            t.commit();
        }
        catch (Exception e) {
            t.rollback();
        }
        return result;
    }
    
    public boolean updateUtilizador(String nome, Integer idade, String cartao, String email, String senha, Character genero) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        try {
            sgs.Utilizador utilizador = sgs.UtilizadorDAO.getUtilizadorByORMID(email);
            
            if (nome != null && !nome.equals("")){
                utilizador.setNome(nome);
            }
            if (genero != null && !genero.equals("")){
                utilizador.setGenero(genero);
            }
            if (idade != null && idade > 0){
                utilizador.setIdade(idade);
            }
            if (cartao != null && !cartao.equals("")){
                utilizador.setNumero(cartao);
            }
           
            if (senha != null && !senha.equals("")){
                utilizador.setSenha(senha);
            }
            t.commit();
        }
        catch (Exception e){
            t.rollback();
            return false;
        }
        return true;
    }
    
    public boolean deleteUtilizador(String email) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        try {
            sgs.Utilizador utilizador = sgs.UtilizadorDAO.getUtilizadorByORMID(email);
            ConferenciaFunctions conferenciaFunctions = new sgs.ConferenciaFunctions();

            List<sgs.Conferencia> allConferencias =  Arrays.asList(conferenciaFunctions.getAllConferencias());
            for(Conferencia conf : allConferencias){
                if(!conf.getLivre() && conf.inscritos.contains(utilizador)) conf.inscritos.remove(utilizador);
            }

            boolean done = sgs.UtilizadorDAO.delete(utilizador);
            t.commit();
            return done;
        }
        catch (Exception e){
            t.rollback();
            return false;
        }
    }
    
    public String login(String email, String pass) throws PersistentException{
        try{
            sgs.Utilizador user = sgs.UtilizadorDAO.getUtilizadorByORMID(email);
            if(pass.equals(user.getSenha())){
                if(user instanceof sgs.Aluno) return "Aluno";
                else if(user instanceof sgs.Docente) return "Docente";
                else return "Utilizador";
            }
            else return "Senha incorreta";
        }
        catch(Exception e){
            return "Email invalido";
        }
    }
    
    
    public List<String> getInfoUser(String email) throws PersistentException{
        List<String> info = new ArrayList<>();
        try{
            sgs.Utilizador user = sgs.UtilizadorDAO.getUtilizadorByORMID(email);
            if(user instanceof Aluno){
                info.add("Aluno");
                info.add(((sgs.Aluno) user).getCurso().getNome());
                info.add(Integer.toString(((sgs.Aluno) user).getAno()));
            }
            else if(user instanceof Docente){
                info.add("Docente");
                info.add(((sgs.Docente) user).getDepartamento());
            }
            else info.add("Utilizador");
            
            info.add(user.getNome());
            info.add(Integer.toString(user.getIdade()));
            info.add(user.getNumero());
            info.add(user.getEmail());
            info.add(Character.toString(user.getGenero()));
        }
        catch(Exception e){
            return null;
        }
        return info;
    }
}