/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgs;

import java.util.Iterator;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 *
 * @author franc
 */
public class ConferenciaFunctions {
    public boolean createConferencia(String codigo, String nome, String codigoSala, long inicio, long fim, boolean livre, String descricao, String orador, String tema) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        boolean result = false;
        try {
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
            /*
            System.out.println("Eventos da sala " + sala.getCodigo() + ": ");
            
            Iterator<Evento> iterator = sala.eventos.getIterator();
            while (iterator.hasNext()) {
                Evento elemento = iterator.next();
                System.out.println(elemento);
            }*/
            
            
            result = sgs.ConferenciaDAO.save(conferencia);
            t.commit();
        }
        catch (Exception e) {
            t.rollback();
        }
        return result;
    }
    
    public boolean updateConferencia(String codigo, String nome, Long horainicio, Long horafim, boolean livre, 
        String descricao, String orador, String tema, String codigoSala){
        try{
            PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
           
            try {
                sgs.Conferencia conferencia = sgs.ConferenciaDAO.getConferenciaByORMID(codigo);
                if (nome != null && !nome.equals("")){
                    conferencia.setNome(nome);
                }
                if (horainicio != null && horainicio > 0){
                    conferencia.setHoraInicio(horainicio);
                }
                if (horafim != null && horafim > 0){
                    conferencia.setHoraFim(horafim);
                }

                conferencia.setLivre(conferencia.getLivre());

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
                t.commit();
            }
            catch (Exception e){
                t.rollback();
                return false;
            }
        }
        
        catch (Exception e){
            return false;
        }
        return true;
    }
    
    public boolean deleteConferencia(String codigo){
        try{
            sgs.Conferencia conferencia = sgs.ConferenciaDAO.getConferenciaByORMID(codigo);
            conferencia.sala.eventos.remove(conferencia);
            boolean done = sgs.ConferenciaDAO.delete(conferencia);
            return done;
        }
        catch (Exception e){
            return false;
        }
    }
    
    public sgs.Conferencia[] getAllConferencias(){
        try{
            return sgs.ConferenciaDAO.listConferenciaByQuery(null, null);
        }
        catch (Exception e){
            return null;
        }
    }
    
    
    public boolean inscreveConferencia(String codigo, String email) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        try{
            sgs.Conferencia conferencia = sgs.ConferenciaDAO.getConferenciaByORMID(codigo);
            sgs.Utilizador user = sgs.UtilizadorDAO.getUtilizadorByORMID(email);

            if(conferencia.getLivre()) return true;
            else{
                if(conferencia.inscritos.size() < conferencia.getSala().getCapacidade()){
                    conferencia.inscritos.add(user);
                    t.commit();
                    return true;
                }
                else return false;
            }
        }
        catch (Exception e) {
            t.rollback();
            return false;
        }
    }
    
    public boolean desinscreveConferencia(String codigo, String email) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        try{
            sgs.Conferencia conferencia = sgs.ConferenciaDAO.getConferenciaByORMID(codigo);
            sgs.Utilizador user = sgs.UtilizadorDAO.getUtilizadorByORMID(email);

            if(conferencia.getLivre()) return true;
            else{
                if(conferencia.inscritos.contains(user)){
                    conferencia.inscritos.remove(user);
                    t.commit();
                    return true;
                }
                else return false;
            }
        }
        catch (Exception e) {
            t.rollback();
            return false;
        }
    }
}
