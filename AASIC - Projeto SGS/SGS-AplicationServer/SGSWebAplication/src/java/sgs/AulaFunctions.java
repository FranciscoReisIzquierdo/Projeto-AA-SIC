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
public class AulaFunctions {
    public String createAula(String codigo, String nome, long inicio, long fim, String codigoSala, String discNome, String turno){
        try{
            PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
            if(inicio < System.currentTimeMillis()) return "Nao e possivel criar aulas com data de inicio passada";
            if(AulaDAO.getAulaByORMID(codigo) != null) return "Aula " + codigo + " ja existe";
            if(SalaDAO.getSalaByORMID(codigoSala) == null) return "Sala " + codigoSala + " inexistente";
            if(DisciplinaDAO.getDisciplinaByORMID(discNome) == null) return "Disciplina " + discNome + " inexistente";
            if(!checkHorario(codigo, codigoSala, inicio, fim)) return "Horario indisponivel. Ja existe outro evento agendado no horario fornecido na sala " + codigoSala;
            if(inicio >= fim) return "Data de inicio da aula tem de ser antes da data de fim";
            try {
                sgs.Aula aula = sgs.AulaDAO.createAula();
                aula.setCodigo(codigo);
                aula.setNome(nome);
                aula.setHoraInicio(inicio);
                aula.setHoraFim(fim);
                aula.setTurno(turno);

                sgs.Disciplina disc = sgs.DisciplinaDAO.getDisciplinaByORMID(discNome);
                aula.setDisciplina(disc);
                
                aula.setDocente(disc.getDocente());

                sgs.Sala sala = sgs.SalaDAO.getSalaByORMID(codigoSala);
                sala.eventos.add(aula);
                aula.sala = sala;

                Iterator<Aluno> iterator = disc.inscritos.getIterator();
                while (iterator.hasNext()) {
                    Aluno aluno = iterator.next();
                    aula.inscritos.add(aluno);
                }

                sgs.AulaDAO.save(aula);
                t.commit();
                return "true";
            }
            catch (Exception e) {
                t.rollback();
                return e.toString();
            }
        }
        catch (Exception e) {
            return e.toString();
        }
    }
    
    public String updateAula(String codigo, String nome, Long horainicio, Long horafim, String codigoSala, String discNome, String turno){
        
        if(horainicio < System.currentTimeMillis()) return "Aula finalizada/ a decorrer";
        try {
            PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
            String result = "true";
            if(SalaDAO.getSalaByORMID(codigoSala) == null) result = "Sala " + codigoSala + " inexistente";
            if(DisciplinaDAO.getDisciplinaByORMID(discNome) == null) result = "Disciplina " + codigoSala + " inexistente";
            if(!checkHorario(codigo, codigoSala, horainicio, horafim)) result = "Horário indisponivel. Já existe outro evento agendado no horário fornecido na sala " + codigoSala;
            if(horainicio >= horafim) result = "Data de inicio da aula tem de ser antes da data de fim";
            try{
                sgs.Aula aula = sgs.AulaDAO.getAulaByORMID(codigo);

                if (nome != null && !nome.equals("")){
                    aula.setNome(nome);
                }
                if(horainicio < horafim){
                    if (horainicio != null && horainicio > 0){
                        aula.setHoraInicio(horainicio);
                    }
                    if (horafim != null && horafim > 0){
                        aula.setHoraFim(horafim);
                    }
                }

                if (turno != null && !turno.equals("")){
                    aula.setTurno(turno);
                }

                sgs.Sala salanova = sgs.SalaDAO.getSalaByORMID(codigoSala);
                if(salanova != null){
                    if(codigoSala != null && !codigoSala.equals("") && !codigoSala.equals(sgs.SalaDAO.getSalaByORMID(codigoSala).getCodigo())){
                        sgs.Sala salaantiga = sgs.SalaDAO.getSalaByORMID(aula.sala.getCodigo());
                        salaantiga.eventos.remove(aula);
                        aula.sala = null;

                        salanova.eventos.add(aula);
                        aula.sala = salanova;
                    }
                }

                sgs.Disciplina disc = sgs.DisciplinaDAO.getDisciplinaByORMID(discNome);
                if(disc != null){
                    if(discNome != null && !discNome.equals("")){
                        aula.setDisciplina(disc);
                        aula.setDocente(disc.getDocente());
                    }
                }
                t.commit();
                return result;
            }
            catch (Exception e){
                t.rollback();
                return "";
            }
        }
        catch (Exception e){
            return "";
        }
    }
    
    public boolean deleteAula(String codigo){
        try{
            sgs.Aula aula = sgs.AulaDAO.getAulaByORMID(codigo);
            aula.sala.eventos.remove(aula);
            boolean done = sgs.AulaDAO.delete(aula);
            return done;
        }
        catch (Exception e){
            return false;
        }
    }
    
    
    public boolean checkHorario(String codigo, String codigoSala, long inicio, long fim){
        try{
            Sala sala = SalaDAO.getSalaByORMID(codigoSala);
            List<sgs.Evento> allEventos = Arrays.asList(sala.eventos.toArray()); 
            for(Evento evento : allEventos){
                if(!evento.getCodigo().equals(codigo) && ((evento.getHoraInicio() <= inicio && evento.getHoraFim() > inicio) || (evento.getHoraInicio() < fim && evento.getHoraFim() >= fim)
                        || (evento.getHoraInicio() >= inicio && evento.getHoraFim() < inicio) || (evento.getHoraInicio() > fim && evento.getHoraFim() <= fim))) return false;
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    
    public List<sgs.Aula> getAllAulas(){
        try{
            List<sgs.Aula> aulas = Arrays.asList(sgs.AulaDAO.listAulaByQuery(null, null));
            return aulas;
        }
        catch (Exception e){
            return null;
        }
    }
    
    
    public List<sgs.Aula> getAllAulasPerDocente(String email){
        List<sgs.Aula> allAulas = getAllAulas();
        List<sgs.Aula> filter = new ArrayList<>();
        
        for(sgs.Aula aula : allAulas){
            if(aula.getDocente().getEmail().equals(email)) filter.add(aula);
        }
        return filter;
    }
    
    public List<sgs.Aluno> getPresencas(String nome) throws PersistentException{
        sgs.Aula aula = sgs.AulaDAO.getAulaByORMID(nome);
        List<sgs.Aluno> presentes = Arrays.asList(aula.presentes.toArray());
        return presentes;
    }
    
    public Aula getAula(String codigo){
        try{
            sgs.Aula aula = sgs.AulaDAO.getAulaByORMID(codigo);
            return aula != null ? aula : null;
        }
        catch (Exception e){
            return null;
        }
    }
    
    public String inscreveAula(String codigo, String email){
        try{
            PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
            try{
                sgs.Aula aula = sgs.AulaDAO.getAulaByORMID(codigo);
                sgs.Aluno aluno = sgs.AlunoDAO.getAlunoByORMID(email);

                aula.inscritos.add(aluno);
                return "true";
            }
            catch (Exception e) {
                t.rollback();
                return "";
            }
        }
        catch (Exception e) {
            return "";
        }
    }
    
    public String desinscreveAula(String codigo, String email){
        try{
            PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
            try{
                sgs.Aula aula = sgs.AulaDAO.getAulaByORMID(codigo);
                sgs.Aluno aluno = sgs.AlunoDAO.getAlunoByORMID(email);
                
                aula.inscritos.remove(aluno);
                return "false";
            }
            catch (Exception e) {
                t.rollback();
                return "";
            }
        }
        catch (Exception e) {
            return "";
        }
    }
}
