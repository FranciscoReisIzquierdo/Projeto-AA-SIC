/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import java.util.List;
import javax.ejb.Local;
import sgs.Aluno;
import sgs.Disciplina;

/**
 *
 * @author franc
 */
@Local
public interface disciplinaBeanLocal {
    public String createDisciplina(String codigo, String nome, String nomeCurso, String emailDocente, 
            String descricao, Integer carga);
    public String updateDisciplina(String codigo, String nome, String nomeCurso, String emailDocente, 
            String descricao, Integer carga);
    public boolean deleteDisciplina(String codigo);
    public List<Disciplina> getAllDisciplinas();
    public String inscreveDisciplina(String codigo, String email);
    public String desinscreveDisciplina(String codigo, String email);
    public List<Disciplina> getAllDisciplinasPerCurso(String codigoCurso);
    public List<Aluno> getAllAlunosPerDiscp(String codigoDiscp);
}
