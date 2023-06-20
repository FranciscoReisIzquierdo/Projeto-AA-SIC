/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import java.util.List;
import javax.ejb.Local;
import sgs.Curso;

/**
 *
 * @author franc
 */
@Local
public interface cursoBeanLocal {
    public boolean createCurso(String codigo, String nome, Integer duracao, String descricao);
    public boolean updateCurso(String codigo, String nome, Integer duracao, String descricao);
    public boolean deleteCurso(String codigo);
    public List<Curso> getAllCursos();
}
