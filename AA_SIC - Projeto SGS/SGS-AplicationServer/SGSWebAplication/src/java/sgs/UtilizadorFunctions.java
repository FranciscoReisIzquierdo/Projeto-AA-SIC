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
    
    public String createUtilizador(String email, String nome, String senha, 
            Integer idade, String cartao, Character genero) throws PersistentException{
        
        if(UtilizadorDAO.getUtilizadorByORMID(email) != null || AlunoDAO.getAlunoByORMID(email) != null
                || DocenteDAO.getDocenteByORMID(email) != null || AdministradorDAO.getAdministradorByORMID(email) != null)
            return "Ja existe um utilizador com o email indicado";
        sgs.Utilizador utilizador = sgs.UtilizadorDAO.createUtilizador();

        utilizador.setNome(nome);
        utilizador.setSenha(senha);
        utilizador.setEmail(email);
        utilizador.setIdade(idade);
        utilizador.setNumero(cartao);
        utilizador.setGenero(genero);

        sgs.UtilizadorDAO.save(utilizador);
        return "true";
    }
    
    public String updateUtilizador(String email, String nome, String senha, 
            Integer idade, String cartao, Character genero) throws PersistentException{
        
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
        return "true";
    }
    
    public boolean deleteUtilizador(String email) throws PersistentException{
        sgs.Utilizador utilizador = sgs.UtilizadorDAO.getUtilizadorByORMID(email);
        ConferenciaFunctions conferenciaFunctions = new sgs.ConferenciaFunctions();

        List<sgs.Conferencia> allConferencias = conferenciaFunctions.getAllConferencias();
        for(Conferencia conf : allConferencias){
            if(!conf.getLivre() && conf.inscritos.contains(utilizador)) conf.inscritos.remove(utilizador);
        }

        boolean done = sgs.UtilizadorDAO.delete(utilizador);
        return done;
    }
    
    
    public Utilizador getUtilizador(String email) throws PersistentException{
        Utilizador user = UtilizadorDAO.getUtilizadorByORMID(email);
        return user != null ? user : null;
    }
    
    public String login(String email, String pass) throws PersistentException{
        sgs.Utilizador user = sgs.UtilizadorDAO.getUtilizadorByORMID(email);
        if (user == null) return "Email invalido";
        if(pass.equals(user.getSenha())){
            if(user instanceof sgs.Aluno) return "Aluno";
            else if(user instanceof sgs.Docente) return "Docente";
            else return "Utilizador";
        }
        else return "Senha incorreta";
    }
    
    
    public String getNome(String email) throws PersistentException{
        sgs.Utilizador user = sgs.UtilizadorDAO.getUtilizadorByORMID(email);
        return user != null ? user.getNome() : "";
    }
    
    public List<String> getInfoUser(String email) throws PersistentException{
        List<String> info = new ArrayList<>();
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
        return info;
    }
}
