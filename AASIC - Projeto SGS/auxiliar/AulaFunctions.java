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
    public boolean createAula(String nome, long data, long inicio, long fim, String turno, String codigoSala, String discNome) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        boolean result = false;
        try {
            sgs.Aula aula = sgs.AulaDAO.createAula();

            aula.setNome(nome);
            aula.setData(data);
            aula.setHoraInicio(inicio);
            aula.setHoraFim(fim);
            aula.setTurno(turno);
            
            sgs.Disciplina disc = sgs.DisciplinaDAO.getDisciplinaByORMID(discNome);
            aula.setDisciplina(disc);
            
            aula.setDocente(disc.getDocente());
            
            sgs.Sala sala = sgs.SalaDAO.getSalaByORMID(codigoSala);
            sala.eventos.add(aula);
            aula.sala = sala;
            

            result = sgs.AulaDAO.save(aula);
            t.commit();
        }
        catch (Exception e) {
            t.rollback();
        }
        return result;
    }
    
    public boolean updateAula(String nome, Long horainicio, Long horafim, Long data, String turno, String codigoSala, String discNome) throws PersistentException{
        PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
        try {
            sgs.Aula aula = sgs.AulaDAO.getAulaByORMID(nome);

            if (horainicio != null && horainicio > 0){
                aula.setHoraInicio(horainicio);
            }
            if (horafim != null && horafim > 0){
                aula.setHoraFim(horafim);
            }
            if (data != null && data > 0){
                aula.setData(data);
            }
            if (turno != null && !turno.equals("")){
                aula.setTurno(turno);
            }
            
            if(codigoSala != null && !codigoSala.equals("") && !codigoSala.equals(sgs.SalaDAO.getSalaByORMID(codigoSala).getCodigo())){
                sgs.Sala salaantiga = sgs.SalaDAO.getSalaByORMID(aula.sala.getCodigo());
                salaantiga.eventos.remove(aula);
                aula.sala = null;
                
                sgs.Sala salanova = sgs.SalaDAO.getSalaByORMID(codigoSala);
                salanova.eventos.add(aula);
                aula.sala = salanova;
            }
            
            if(discNome != null && discNome.equals("")){
                sgs.Disciplina disc = sgs.DisciplinaDAO.getDisciplinaByORMID(discNome);
                aula.setDisciplina(disc);
                
                aula.setDocente(disc.getDocente());
            }
            
            t.commit();
        }
        catch (Exception e){
            t.rollback();
            return false;
        }
        return true;
    }
    
    public boolean deleteAula(String nome) throws PersistentException{
        sgs.Aula aula = sgs.AulaDAO.getAulaByORMID(nome);
        aula.sala.eventos.remove(aula);
        boolean done = sgs.AulaDAO.delete(aula);
        return done;
    }
    
    
    public List<sgs.Aula> getAllAulas() throws PersistentException{
        List<sgs.Aula> aulas = Arrays.asList(sgs.AulaDAO.listAulaByQuery(null, null));
        return aulas;
    }
    
    
    public List<sgs.Aula> getAllAulasPerDocente(String email) throws PersistentException{
        List<sgs.Aula> allAulas = getAllAulas();
        List<sgs.Aula> filter = new ArrayList<>();
        
        for(sgs.Aula aula : allAulas){
            if(aula.getDocente().getEmail().equals(email)) filter.add(aula);
        }
        return filter;
    }
    
    public List<sgs.Aluno> getPresencas(String nome) throws PersistentException{
        sgs.Aula aula = sgs.AulaDAO.getAulaByORMID(nome);
        List<sgs.Aluno> presentes = Arrays.asList(aula.alunos.toArray());
        return presentes;
    }
}
