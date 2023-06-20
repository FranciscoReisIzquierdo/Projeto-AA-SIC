/**
 * Licensee: Francisco Izquierdo(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateSistemadeGestãodeSalasData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
		try {
			sgs.Sala sGSSala = sgs.SalaDAO.loadSalaByQuery(null, null);
			// Update the properties of the persistent object
			sgs.SalaDAO.save(sGSSala);
			sgs.Aula sGSAula = sgs.AulaDAO.loadAulaByQuery(null, null);
			// Update the properties of the persistent object
			sgs.AulaDAO.save(sGSAula);
			sgs.Conferencia sGSConferencia = sgs.ConferenciaDAO.loadConferenciaByQuery(null, null);
			// Update the properties of the persistent object
			sgs.ConferenciaDAO.save(sGSConferencia);
			sgs.Utilizador sGSUtilizador = sgs.UtilizadorDAO.loadUtilizadorByQuery(null, null);
			// Update the properties of the persistent object
			sgs.UtilizadorDAO.save(sGSUtilizador);
			sgs.Aluno sGSAluno = sgs.AlunoDAO.loadAlunoByQuery(null, null);
			// Update the properties of the persistent object
			sgs.AlunoDAO.save(sGSAluno);
			sgs.Docente sGSDocente = sgs.DocenteDAO.loadDocenteByQuery(null, null);
			// Update the properties of the persistent object
			sgs.DocenteDAO.save(sGSDocente);
			sgs.Disciplina sGSDisciplina = sgs.DisciplinaDAO.loadDisciplinaByQuery(null, null);
			// Update the properties of the persistent object
			sgs.DisciplinaDAO.save(sGSDisciplina);
			sgs.Curso sGSCurso = sgs.CursoDAO.loadCursoByQuery(null, null);
			// Update the properties of the persistent object
			sgs.CursoDAO.save(sGSCurso);
			sgs.Administrador sGSAdministrador = sgs.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Update the properties of the persistent object
			sgs.AdministradorDAO.save(sGSAdministrador);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Sala by SalaCriteria");
		sgs.SalaCriteria sGSSalaCriteria = new sgs.SalaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sGSSalaCriteria.Codigo.eq();
		System.out.println(sGSSalaCriteria.uniqueSala());
		
		System.out.println("Retrieving Aula by AulaCriteria");
		sgs.AulaCriteria sGSAulaCriteria = new sgs.AulaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sGSAulaCriteria.Codigo.eq();
		System.out.println(sGSAulaCriteria.uniqueAula());
		
		System.out.println("Retrieving Conferencia by ConferenciaCriteria");
		sgs.ConferenciaCriteria sGSConferenciaCriteria = new sgs.ConferenciaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sGSConferenciaCriteria.Codigo.eq();
		System.out.println(sGSConferenciaCriteria.uniqueConferencia());
		
		System.out.println("Retrieving Utilizador by UtilizadorCriteria");
		sgs.UtilizadorCriteria sGSUtilizadorCriteria = new sgs.UtilizadorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sGSUtilizadorCriteria.Email.eq();
		System.out.println(sGSUtilizadorCriteria.uniqueUtilizador());
		
		System.out.println("Retrieving Aluno by AlunoCriteria");
		sgs.AlunoCriteria sGSAlunoCriteria = new sgs.AlunoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sGSAlunoCriteria.Email.eq();
		System.out.println(sGSAlunoCriteria.uniqueAluno());
		
		System.out.println("Retrieving Docente by DocenteCriteria");
		sgs.DocenteCriteria sGSDocenteCriteria = new sgs.DocenteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sGSDocenteCriteria.Email.eq();
		System.out.println(sGSDocenteCriteria.uniqueDocente());
		
		System.out.println("Retrieving Disciplina by DisciplinaCriteria");
		sgs.DisciplinaCriteria sGSDisciplinaCriteria = new sgs.DisciplinaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sGSDisciplinaCriteria.Codigo.eq();
		System.out.println(sGSDisciplinaCriteria.uniqueDisciplina());
		
		System.out.println("Retrieving Curso by CursoCriteria");
		sgs.CursoCriteria sGSCursoCriteria = new sgs.CursoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sGSCursoCriteria.Codigo.eq();
		System.out.println(sGSCursoCriteria.uniqueCurso());
		
		System.out.println("Retrieving Administrador by AdministradorCriteria");
		sgs.AdministradorCriteria sGSAdministradorCriteria = new sgs.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sGSAdministradorCriteria.Email.eq();
		System.out.println(sGSAdministradorCriteria.uniqueAdministrador());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateSistemadeGestãodeSalasData retrieveAndUpdateSistemadeGestãodeSalasData = new RetrieveAndUpdateSistemadeGestãodeSalasData();
			try {
				retrieveAndUpdateSistemadeGestãodeSalasData.retrieveAndUpdateTestData();
				//retrieveAndUpdateSistemadeGestãodeSalasData.retrieveByCriteria();
			}
			finally {
				sgs.SistemadeGestãodeSalasPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
