/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import java.util.List;
import javax.ejb.Local;
import sgs.Conferencia;

/**
 *
 * @author franc
 */
@Local
public interface conferenciaBeanLocal {
    public String createConferencia(String codigo, String nome, String codigoSala, long inicio, long fim, boolean livre, 
            String descricao, String orador, String tema);
    public boolean checkHorario(String codigo, String codigoSala, long inicio, long fim);
    public String updateConferencia(String codigo, String nome, Long horainicio, Long horafim, boolean livre, 
        String descricao, String orador, String tema, String codigoSala);
    public boolean deleteConferencia(String codigo);
    public List<Conferencia> getAllConferencias();
    public List<Conferencia> getAllConfDisponiveis();
    public String inscreveConferencia(String codigo, String email);
    public String desinscreveConferencia(String codigo, String email);
}
