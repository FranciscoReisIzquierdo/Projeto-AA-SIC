/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import java.util.List;
import javax.ejb.Local;
import sgs.Utilizador;

/**
 *
 * @author franc
 */
@Local
public interface utilizadorBeanLocal {
    public String createUtilizador(String email, String nome, String senha, 
            Integer idade, String cartao, Character genero);
    public String updateUtilizador(String email, String nome, String senha, 
            Integer idade, String cartao, Character genero);
    public boolean deleteUtilizador(String email);
    public Utilizador getUtilizador(String email);
    public String login(String email, String pass);
    public String getNome(String email);
    public List<String> getInfoUser(String email);
}
