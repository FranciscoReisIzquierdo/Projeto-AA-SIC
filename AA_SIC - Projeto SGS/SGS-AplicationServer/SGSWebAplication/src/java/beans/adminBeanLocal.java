/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import javax.ejb.Local;

/**
 *
 * @author franc
 */
@Local
public interface adminBeanLocal {
    public boolean createAdministrador(String email, String nome, String senha);
    public String login(String email, String pass);
}
