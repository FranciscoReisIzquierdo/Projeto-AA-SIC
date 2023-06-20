/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgs;

import java.util.*;
import org.orm.PersistentException;

/**
 *
 * @author franc
 */
public class AlunoFunctions {
    
    public String createAluno(String email, String nome, String senha, Integer idade, 
        String cartao, Character genero, Integer ano, String nomeCurso) throws PersistentException{
        if(UtilizadorDAO.getUtilizadorByORMID(email) != null || AlunoDAO.getAlunoByORMID(email) != null
                || DocenteDAO.getDocenteByORMID(email) != null || AdministradorDAO.getAdministradorByORMID(email) != null)
            return "Ja existe um utilizador com o email indicado";
        if(sgs.CursoDAO.getCursoByORMID(nomeCurso) == null) return "Nao existe nenhum curso com o codigo " + nomeCurso;
        sgs.Aluno aluno = sgs.AlunoDAO.createAluno();

        aluno.setNome(nome);
        aluno.setSenha(senha);
        aluno.setEmail(email);
        aluno.setIdade(idade);
        aluno.setNumero(cartao);
        aluno.setAno(ano);
        aluno.setGenero(genero);

        sgs.Curso curso = sgs.CursoDAO.getCursoByORMID(nomeCurso);
        aluno.setCurso(curso);

        sgs.AlunoDAO.save(aluno);
        return "true";
    }
    
    
    public String updateAluno(String email, String nome, Integer idade, String cartao, 
            String senha, Character genero, Integer ano) throws PersistentException{
            
        sgs.Aluno aluno = sgs.AlunoDAO.getAlunoByORMID(email);

        if (nome != null && !nome.equals("")){
            aluno.setNome(nome);
        }
        if (genero != null && !genero.equals("")){
            aluno.setGenero(genero);
        }
        if (idade != null && idade > 0){
            aluno.setIdade(idade);
        }
        if (cartao != null && !cartao.equals("")){
            aluno.setNumero(cartao);
        }
        if (senha != null && !senha.equals("")){
            aluno.setSenha(senha);
        }

        if (ano != null && ano > 0){
            aluno.setSenha(senha);
        }
        return "true";
    }
          
    
    public boolean deleteAluno(String email) throws PersistentException{
        sgs.Aluno aluno = sgs.AlunoDAO.getAlunoByORMID(email);
        List<sgs.Disciplina> allDisciplinas = Arrays.asList(aluno.disciplinas.toArray());
        for(sgs.Disciplina disciplina: allDisciplinas) disciplina.inscritos.remove(aluno);

        AulaFunctions aulaFunctions = new sgs.AulaFunctions();

        List<sgs.Aula> allAulas = aulaFunctions.getAllAulas();
        for(Aula aula : allAulas){
            if(aula.inscritos.contains(aluno)) aula.inscritos.remove(aluno);
            if(aula.presentes.contains(aluno)) aula.presentes.remove(aluno);
        }

        ConferenciaFunctions conferenciaFunctions = new sgs.ConferenciaFunctions();

        List<sgs.Conferencia> allConferencias = conferenciaFunctions.getAllConferencias();
        for(Conferencia conf : allConferencias){
            if(!conf.getLivre() && conf.inscritos.contains(aluno)) conf.inscritos.remove(aluno);
        }

        boolean done = sgs.AlunoDAO.delete(aluno);
        return done;
    }
    
    public boolean inscreveAluno(List<String> discps, String email) throws PersistentException{
        sgs.Aluno aluno = sgs.AlunoDAO.getAlunoByORMID(email);
        for(String codigoDiscp : discps){
            sgs.Disciplina disciplina = sgs.DisciplinaDAO.getDisciplinaByORMID(codigoDiscp);
            if(disciplina.curso.equals(aluno.getCurso())){
                disciplina.inscritos.add(aluno);
                aluno.disciplinas.add(disciplina);
            }
        }
        return true;
    }
    
    public List<Aluno> getAllAlunos() throws PersistentException{
        return Arrays.asList(sgs.AlunoDAO.listAlunoByQuery(null, null));
    }
}
