/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 *
 * @author franc
 */
public class ConferenciaFunctions {
    public String createConferencia(String codigo, String nome, String codigoSala, long inicio, long fim, boolean livre, 
            String descricao, String orador, String tema) throws PersistentException{
        
        if(inicio < System.currentTimeMillis()) return "Nao e possivel criar conferencias com data de inicio passada";
        if(ConferenciaDAO.getConferenciaByORMID(codigo) != null) return "Conferencia " + codigo + " ja existe";
        if(SalaDAO.getSalaByORMID(codigoSala) == null) return "Sala " + codigoSala + " inexistente";
        if(!checkHorario(codigo, codigoSala, inicio, fim)) return "Horario indisponivel. Ja existe outro evento agendado no horario definido na sala " + codigoSala;
        if(inicio >= fim) return "Data de inicio da conferencia tem de ser antes da data de fim";

        sgs.Conferencia conferencia = sgs.ConferenciaDAO.createConferencia();
        conferencia.setCodigo(codigo);
        conferencia.setNome(nome);
        conferencia.setHoraInicio(inicio);
        conferencia.setHoraFim(fim);
        conferencia.setLivre(livre);
        conferencia.setDescrição(descricao);
        conferencia.setOrador(orador);
        conferencia.setTema(tema);
        sgs.Sala sala = sgs.SalaDAO.getSalaByORMID(codigoSala);
        sala.eventos.add(conferencia);
        conferencia.sala = sala;

        sgs.ConferenciaDAO.save(conferencia);
        return "true";
    }
    
    
    public boolean checkHorario(String codigo, String codigoSala, long inicio, long fim) throws PersistentException{
        Sala sala = SalaDAO.getSalaByORMID(codigoSala);
        List<sgs.Evento> allEventos = Arrays.asList(sala.eventos.toArray()); 
        for(Evento evento : allEventos){
            if(!evento.getCodigo().equals(codigo) && ((evento.getHoraInicio() <= inicio && evento.getHoraFim() > inicio) || (evento.getHoraInicio() < fim && evento.getHoraFim() >= fim)
                    || (evento.getHoraInicio() >= inicio && evento.getHoraFim() < inicio) || (evento.getHoraInicio() > fim && evento.getHoraFim() <= fim))) return false;
        }
        return true;
    }
    
    public String updateConferencia(String codigo, String nome, Long horainicio, Long horafim, boolean livre, 
        String descricao, String orador, String tema, String codigoSala) throws PersistentException{
        
        if(horainicio < System.currentTimeMillis()) return "Conferencia finalizada/ a decorrer";
        
            String result = "true";
            if(SalaDAO.getSalaByORMID(codigoSala) == null) result = "Sala " + codigoSala + " inexistente";
            if(!checkHorario(codigo, codigoSala, horainicio, horafim)) result = "Horario indisponivel. Ja existe outro evento agendado no horario fornecido na sala " + codigoSala;
            if(horainicio >= horafim) result = "Data de inicio da conferencia tem de ser antes da data de fim";
            sgs.Conferencia conferencia = sgs.ConferenciaDAO.getConferenciaByORMID(codigo);
            if (nome != null && !nome.equals("")){
                conferencia.setNome(nome);
            }
            if(horainicio < horafim){
                if (horainicio != null && horainicio > 0){
                    conferencia.setHoraInicio(horainicio);
                }
                if (horafim != null && horafim > 0){
                    conferencia.setHoraFim(horafim);
                }
            }

            conferencia.setLivre(livre);

            if (descricao != null && !descricao.equals("")){
                conferencia.setDescrição(descricao);
            }
            if (orador != null && !orador.equals("")){
                conferencia.setOrador(orador);
            }
            if (tema != null && !tema.equals("")){
                conferencia.setTema(tema);
            }
            sgs.Sala salanova = sgs.SalaDAO.getSalaByORMID(codigoSala);
            if(salanova != null){
                if (codigoSala != null && !codigoSala.equals("") && !codigoSala.equals(sgs.SalaDAO.getSalaByORMID(codigoSala).getCodigo())){
                    sgs.Sala salaantiga = sgs.SalaDAO.getSalaByORMID(conferencia.sala.getCodigo());
                    salaantiga.eventos.remove(conferencia);
                    conferencia.sala = null;

                    salanova.eventos.add(conferencia);
                    conferencia.sala = salanova;
                }
            }
            return result;
    }
    
    public boolean deleteConferencia(String codigo) throws PersistentException{
        sgs.Conferencia conferencia = sgs.ConferenciaDAO.getConferenciaByORMID(codigo);
        conferencia.sala.eventos.remove(conferencia);
        boolean done = sgs.ConferenciaDAO.delete(conferencia);
        return done;
    }
    
    public List<Conferencia> getAllConferencias() throws PersistentException{
        return Arrays.asList(sgs.ConferenciaDAO.listConferenciaByQuery(null, null));
    }
    
    public List<Conferencia> getAllConfDisponiveis() throws PersistentException{
        long time = System.currentTimeMillis();
        List<Conferencia> allConf = getAllConferencias();
        List<Conferencia> restritas = new ArrayList<>();
        for(Conferencia conf : allConf){
            if(conf.inscritos.size() < conf.getSala().getCapacidade() && conf.getHoraInicio() > time) restritas.add(conf);
        }
        return restritas;
    }
    
    
    public String inscreveConferencia(String codigo, String email) throws PersistentException{
        sgs.Conferencia conferencia = sgs.ConferenciaDAO.getConferenciaByORMID(codigo);
        sgs.Utilizador user = sgs.UtilizadorDAO.getUtilizadorByORMID(email);

        if(conferencia.getLivre()) return "";
        else{
            if(conferencia.inscritos.size() < conferencia.getSala().getCapacidade()){
                conferencia.inscritos.add(user);
                return "true";
            }
            else return "";
        }
    }
    
    public String desinscreveConferencia(String codigo, String email) throws PersistentException{
        sgs.Conferencia conferencia = sgs.ConferenciaDAO.getConferenciaByORMID(codigo);
        sgs.Utilizador user = sgs.UtilizadorDAO.getUtilizadorByORMID(email);

        if(conferencia.getLivre()) return "";
        else{
            if(conferencia.inscritos.contains(user)){
                conferencia.inscritos.remove(user);
                return "false";
            }
            else return "";
        }
    }
}
