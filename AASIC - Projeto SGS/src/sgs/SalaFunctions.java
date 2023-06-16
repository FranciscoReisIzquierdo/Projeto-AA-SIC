/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgs;

import java.util.*;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 *
 * @author franc
 */
public class SalaFunctions {
    
    public boolean createSala(String codigo, String localizacao, int capacidade) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        boolean result = false;
        try {
        sgs.Sala sGSSala = sgs.SalaDAO.createSala();
        
        sGSSala.setCodigo(codigo);
        sGSSala.setLocalizacao(localizacao);
        sGSSala.setCapacidade(capacidade);
        
        result = sgs.SalaDAO.save(sGSSala);
        t.commit();
        }
        catch (Exception e) {
            t.rollback();
        }
        return result;
    }
    
    public boolean updateCapacidade(String codigo, Integer capacidade) throws PersistentException{
    PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
    try {
        sgs.Sala sala = sgs.SalaDAO.getSalaByORMID(codigo);

        if (capacidade > 0){
            sala.setCapacidade(capacidade);
        }
        sgs.SalaDAO.save(sala);
        t.commit();
    }
    catch (Exception e){
        t.rollback();
        return false;
    }
    return true;
}
    
    public Integer updateLotacao(String codigo, int value) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        int lot = 0;
        try {
            sgs.Sala sala = sgs.SalaDAO.getSalaByORMID(codigo);
            
            lot = sala.getLotacao() + value;
            if(lot >= 0 || lot <= sala.getCapacidade()){
                sala.setLotacao(lot);
                sgs.SalaDAO.save(sala);
            }
            else lot = -1;
            t.commit();
            
        }
        catch (Exception e){
            t.rollback();
            return -1;
        }
        return lot;
    }

    public boolean deleteSala(String codigo) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        try {
            sgs.Sala sala = sgs.SalaDAO.getSalaByORMID(codigo);
            List<sgs.Evento> allEventos = Arrays.asList(sala.eventos.toArray());
            for(Evento evento : allEventos) evento.sala = null;

            boolean done = sgs.SalaDAO.delete(sala);
            t.commit();
            return done;
        }
        catch (Exception e){
            t.rollback();
            return false;
        }
    }
    
    
    public Evento getEvento(sgs.Sala sala){
        long time = System.currentTimeMillis();
        Evento atual = null;
        Iterator<Evento> iterator = sala.eventos.getIterator();
        while (iterator.hasNext()) {
            Evento evento = iterator.next();

            if(evento.getHoraInicio() <=  time && evento.getHoraFim() >= time){
                atual = evento;
                break;
            }
            if((evento.getHoraInicio() > time && evento.getHoraInicio() < atual.getHoraInicio()) || atual == null){
                atual = evento;
            }
        }
        return atual;
    }
    
    public List<String> salaInfo(String codSala) throws PersistentException{
        sgs.Sala sala = sgs.SalaDAO.getSalaByORMID(codSala);
        Evento atual = getEvento(sala);
        List<String> result = new ArrayList();
        
        result.add(sala.getCodigo());
        result.add(Integer.toString(sala.getCapacidade()));
        result.add(Integer.toString(sala.getLotacao()));
        if(atual != null){
            result.add(atual.getNome());
            result.add(Long.toString(atual.getHoraInicio()));
            result.add(Long.toString(atual.getHoraFim()));
            if(atual instanceof sgs.Aula){
                result.add("Aula");
                result.add(((Aula) atual).getDisciplina().getNome());
                result.add(((Aula) atual).getDisciplina().getCurso().getNome());
                result.add(((Aula) atual).getDocente().getNome());
                result.add(((Aula) atual).getTurno());
            }
            else{
                result.add("Conferencia");
                result.add(((Conferencia) atual).getOrador());
                result.add(((Conferencia) atual).getTema());
                result.add(((Conferencia) atual).getDescrição());
                if(((Conferencia) atual).getLivre()) result.add("Entrada livre");
                else result.add("Entrada restrita");
            }
        }
        return result;
    }
    
    public boolean checkCartao(String codSala, String email) throws PersistentException{
        sgs.Sala sala = sgs.SalaDAO.getSalaByORMID(codSala);
        Evento evento = getEvento(sala);
        sgs.Utilizador utilizador = sgs.UtilizadorDAO.getUtilizadorByORMID(email);
        
        if(evento instanceof sgs.Aula && (utilizador instanceof sgs.Aluno || utilizador instanceof Docente)){
            if(utilizador instanceof sgs.Aluno){
                sgs.Aluno aluno = (sgs.Aluno) utilizador;
            
                if(!((sgs.Aula) evento).inscritos.contains(aluno)) return false;
                else{
                    if(((sgs.Aula) evento).presentes.contains(aluno)){
                        updateLotacao(codSala, -1);
                        return true;
                    }
                    else{
                        marcaPresenca(aluno, (sgs.Aula) evento);
                        updateLotacao(codSala, 1);
                        return true;
                    }
                }
            }
            else{
                if(((sgs.Aula) evento).getDocente().equals((sgs.Docente) utilizador)) return true;
                return false;
            }
        }
        else if(evento instanceof sgs.Conferencia){
            sgs.Conferencia conf = (sgs.Conferencia) evento;
            if((conf.getLivre() && conf.getSala().getLotacao() < conf.getSala().getCapacidade()) ||
                    (!conf.getLivre() && conf.inscritos.contains(utilizador))){
                updateLotacao(codSala, 1);
                return true;
            }
            else return false;
        }
        return false;
    }
    
    
    public void marcaPresenca(sgs.Aluno aluno, sgs.Aula aula) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        
        try {
            aula.presentes.add(aluno);
            t.commit();
        }
        catch (Exception e){
            t.rollback();
        }
    }
    
    public sgs.Sala[] getAllSalas() throws PersistentException{
        return sgs.SalaDAO.listSalaByQuery(null, null);
    }
}
