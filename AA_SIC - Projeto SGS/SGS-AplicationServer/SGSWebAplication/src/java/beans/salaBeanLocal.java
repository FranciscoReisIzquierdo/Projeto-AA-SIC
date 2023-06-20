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
public interface salaBeanLocal {
    public boolean createSala(String codigo, String localizacao, int capacidade);
    public boolean updateCapacidade(String codigo, Integer capacidade);
    public boolean deleteSala(String codigo);
    public boolean isValid(String codSala);
    public List<String> salaInfo(String codSala);
    public boolean checkCartao(String codSala, String email);
    public List<sgs.Sala> getAllSalas();
}
