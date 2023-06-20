/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import java.util.List;
import javax.ejb.Local;
import sgs.Aluno;

/**
 *
 * @author franc
 */
@Local
public interface alunoBeanLocal {
    public String createAluno(String email, String nome, String senha, Integer idade, String cartao, Character genero, Integer ano, String nomeCurso);
    public String updateAluno(String email, String nome, Integer idade, String cartao, String senha, Character genero, Integer ano);
    public boolean deleteAluno(String email);
    public boolean inscreveAluno(List<String> discps, String email);
    public List<Aluno> getAllAlunos();
}
