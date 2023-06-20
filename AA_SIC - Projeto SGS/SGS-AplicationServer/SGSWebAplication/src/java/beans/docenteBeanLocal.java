/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author franc
 */
@Local
public interface docenteBeanLocal {
    public boolean createDocente(String email, String nome, Integer idade, 
            String cartao, String senha, String departamento, Character genero);
    public String updateDocente(String email, String nome, Integer idade, String cartao, String senha,
            String departamento, Character genero);
    public boolean deleteDocente(String email);
    public List<sgs.Docente> getAllDocentes();
}
