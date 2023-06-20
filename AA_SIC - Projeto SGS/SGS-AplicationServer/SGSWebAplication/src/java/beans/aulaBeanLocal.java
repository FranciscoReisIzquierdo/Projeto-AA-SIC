/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import java.util.List;
import javax.ejb.Local;
import sgs.Aula;

/**
 *
 * @author franc
 */
@Local
public interface aulaBeanLocal {
    public String createAula(String codigo, String nome, long inicio, long fim, String codigoSala, String discNome, String turno);
    public String updateAula(String codigo, String nome, Long horainicio, Long horafim, 
            String codigoSala, String discNome, String turno);
    public boolean deleteAula(String codigo);
    public boolean checkHorario(String codigo, String codigoSala, long inicio, long fim);
    public List<sgs.Aula> getAllAulas();
    public List<sgs.Aula> getAllAulasPerDocente(String email);
    public List<sgs.Aluno> getPresencas(String nome);
    public Aula getAula(String codigo);
    public String inscreveAula(String codigo, String email);
    public String desinscreveAula(String codigo, String email);
}
