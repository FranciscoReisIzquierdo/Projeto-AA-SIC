/**
 * Licensee: Francisco Izquierdo(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateSistemadeGestãodeSalasData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = sgs.SistemadeGestãodeSalasPersistentManager.instance().getSession().beginTransaction();
		try {
			sgs.Sala sGSSala = sgs.SalaDAO.createSala();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Lotacao, Capacidade, Codigo
			sgs.SalaDAO.save(sGSSala);
			sgs.Aula sGSAula = sgs.AulaDAO.createAula();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : inscritos, presentes
			sgs.AulaDAO.save(sGSAula);
			sgs.Conferencia sGSConferencia = sgs.ConferenciaDAO.createConferencia();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : inscritos
			sgs.ConferenciaDAO.save(sGSConferencia);
			sgs.Utilizador sGSUtilizador = sgs.UtilizadorDAO.createUtilizador();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Genero, Email
			sgs.UtilizadorDAO.save(sGSUtilizador);
			sgs.Aluno sGSAluno = sgs.AlunoDAO.createAluno();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : disciplinas
			sgs.AlunoDAO.save(sGSAluno);
			sgs.Docente sGSDocente = sgs.DocenteDAO.createDocente();
			// Initialize the properties of the persistent object here
			sgs.DocenteDAO.save(sGSDocente);
			sgs.Disciplina sGSDisciplina = sgs.DisciplinaDAO.createDisciplina();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : inscritos, CargaHoraria, curso, Codigo
			sgs.DisciplinaDAO.save(sGSDisciplina);
			sgs.Curso sGSCurso = sgs.CursoDAO.createCurso();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Duracao, Codigo
			sgs.CursoDAO.save(sGSCurso);
			sgs.Administrador sGSAdministrador = sgs.AdministradorDAO.createAdministrador();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Email
			sgs.AdministradorDAO.save(sGSAdministrador);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateSistemadeGestãodeSalasData createSistemadeGestãodeSalasData = new CreateSistemadeGestãodeSalasData();
			try {
				createSistemadeGestãodeSalasData.createTestData();
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
