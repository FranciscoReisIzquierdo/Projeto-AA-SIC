/**
 * Licensee: Francisco Izquierdo(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteSistemadeGestãodeSalasData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
		try {
			sgs.Sala sGSSala = sgs.SalaDAO.loadSalaByQuery(null, null);
			// Delete the persistent object
			sgs.SalaDAO.delete(sGSSala);
			sgs.Aula sGSAula = sgs.AulaDAO.loadAulaByQuery(null, null);
			// Delete the persistent object
			sgs.AulaDAO.delete(sGSAula);
			sgs.Conferencia sGSConferencia = sgs.ConferenciaDAO.loadConferenciaByQuery(null, null);
			// Delete the persistent object
			sgs.ConferenciaDAO.delete(sGSConferencia);
			sgs.Utilizador sGSUtilizador = sgs.UtilizadorDAO.loadUtilizadorByQuery(null, null);
			// Delete the persistent object
			sgs.UtilizadorDAO.delete(sGSUtilizador);
			sgs.Aluno sGSAluno = sgs.AlunoDAO.loadAlunoByQuery(null, null);
			// Delete the persistent object
			sgs.AlunoDAO.delete(sGSAluno);
			sgs.Docente sGSDocente = sgs.DocenteDAO.loadDocenteByQuery(null, null);
			// Delete the persistent object
			sgs.DocenteDAO.delete(sGSDocente);
			sgs.Disciplina sGSDisciplina = sgs.DisciplinaDAO.loadDisciplinaByQuery(null, null);
			// Delete the persistent object
			sgs.DisciplinaDAO.delete(sGSDisciplina);
			sgs.Curso sGSCurso = sgs.CursoDAO.loadCursoByQuery(null, null);
			// Delete the persistent object
			sgs.CursoDAO.delete(sGSCurso);
			sgs.Administrador sGSAdministrador = sgs.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Delete the persistent object
			sgs.AdministradorDAO.delete(sGSAdministrador);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteSistemadeGestãodeSalasData deleteSistemadeGestãodeSalasData = new DeleteSistemadeGestãodeSalasData();
			try {
				deleteSistemadeGestãodeSalasData.deleteTestData();
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
