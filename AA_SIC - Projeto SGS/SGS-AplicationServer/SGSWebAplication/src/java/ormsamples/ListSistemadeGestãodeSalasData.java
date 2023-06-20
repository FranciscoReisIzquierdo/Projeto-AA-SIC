/**
 * Licensee: Francisco Izquierdo(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListSistemadeGestãodeSalasData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Sala...");
		sgs.Sala[] sGSSalas = sgs.SalaDAO.listSalaByQuery(null, null);
		int length = Math.min(sGSSalas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sGSSalas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Aula...");
		sgs.Aula[] sGSAulas = sgs.AulaDAO.listAulaByQuery(null, null);
		length = Math.min(sGSAulas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sGSAulas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Conferencia...");
		sgs.Conferencia[] sGSConferencias = sgs.ConferenciaDAO.listConferenciaByQuery(null, null);
		length = Math.min(sGSConferencias.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sGSConferencias[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Utilizador...");
		sgs.Utilizador[] sGSUtilizadors = sgs.UtilizadorDAO.listUtilizadorByQuery(null, null);
		length = Math.min(sGSUtilizadors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sGSUtilizadors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Aluno...");
		sgs.Aluno[] sGSAlunos = sgs.AlunoDAO.listAlunoByQuery(null, null);
		length = Math.min(sGSAlunos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sGSAlunos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Docente...");
		sgs.Docente[] sGSDocentes = sgs.DocenteDAO.listDocenteByQuery(null, null);
		length = Math.min(sGSDocentes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sGSDocentes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Disciplina...");
		sgs.Disciplina[] sGSDisciplinas = sgs.DisciplinaDAO.listDisciplinaByQuery(null, null);
		length = Math.min(sGSDisciplinas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sGSDisciplinas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Curso...");
		sgs.Curso[] sGSCursos = sgs.CursoDAO.listCursoByQuery(null, null);
		length = Math.min(sGSCursos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sGSCursos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Administrador...");
		sgs.Administrador[] sGSAdministradors = sgs.AdministradorDAO.listAdministradorByQuery(null, null);
		length = Math.min(sGSAdministradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sGSAdministradors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Sala by Criteria...");
		sgs.SalaCriteria sGSSalaCriteria = new sgs.SalaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sGSSalaCriteria.Codigo.eq();
		sGSSalaCriteria.setMaxResults(ROW_COUNT);
		sgs.Sala[] sGSSalas = sGSSalaCriteria.listSala();
		int length =sGSSalas== null ? 0 : Math.min(sGSSalas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sGSSalas[i]);
		}
		System.out.println(length + " Sala record(s) retrieved."); 
		
		System.out.println("Listing Aula by Criteria...");
		sgs.AulaCriteria sGSAulaCriteria = new sgs.AulaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sGSAulaCriteria.Codigo.eq();
		sGSAulaCriteria.setMaxResults(ROW_COUNT);
		sgs.Aula[] sGSAulas = sGSAulaCriteria.listAula();
		length =sGSAulas== null ? 0 : Math.min(sGSAulas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sGSAulas[i]);
		}
		System.out.println(length + " Aula record(s) retrieved."); 
		
		System.out.println("Listing Conferencia by Criteria...");
		sgs.ConferenciaCriteria sGSConferenciaCriteria = new sgs.ConferenciaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sGSConferenciaCriteria.Codigo.eq();
		sGSConferenciaCriteria.setMaxResults(ROW_COUNT);
		sgs.Conferencia[] sGSConferencias = sGSConferenciaCriteria.listConferencia();
		length =sGSConferencias== null ? 0 : Math.min(sGSConferencias.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sGSConferencias[i]);
		}
		System.out.println(length + " Conferencia record(s) retrieved."); 
		
		System.out.println("Listing Utilizador by Criteria...");
		sgs.UtilizadorCriteria sGSUtilizadorCriteria = new sgs.UtilizadorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sGSUtilizadorCriteria.Email.eq();
		sGSUtilizadorCriteria.setMaxResults(ROW_COUNT);
		sgs.Utilizador[] sGSUtilizadors = sGSUtilizadorCriteria.listUtilizador();
		length =sGSUtilizadors== null ? 0 : Math.min(sGSUtilizadors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sGSUtilizadors[i]);
		}
		System.out.println(length + " Utilizador record(s) retrieved."); 
		
		System.out.println("Listing Aluno by Criteria...");
		sgs.AlunoCriteria sGSAlunoCriteria = new sgs.AlunoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sGSAlunoCriteria.Email.eq();
		sGSAlunoCriteria.setMaxResults(ROW_COUNT);
		sgs.Aluno[] sGSAlunos = sGSAlunoCriteria.listAluno();
		length =sGSAlunos== null ? 0 : Math.min(sGSAlunos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sGSAlunos[i]);
		}
		System.out.println(length + " Aluno record(s) retrieved."); 
		
		System.out.println("Listing Docente by Criteria...");
		sgs.DocenteCriteria sGSDocenteCriteria = new sgs.DocenteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sGSDocenteCriteria.Email.eq();
		sGSDocenteCriteria.setMaxResults(ROW_COUNT);
		sgs.Docente[] sGSDocentes = sGSDocenteCriteria.listDocente();
		length =sGSDocentes== null ? 0 : Math.min(sGSDocentes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sGSDocentes[i]);
		}
		System.out.println(length + " Docente record(s) retrieved."); 
		
		System.out.println("Listing Disciplina by Criteria...");
		sgs.DisciplinaCriteria sGSDisciplinaCriteria = new sgs.DisciplinaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sGSDisciplinaCriteria.Codigo.eq();
		sGSDisciplinaCriteria.setMaxResults(ROW_COUNT);
		sgs.Disciplina[] sGSDisciplinas = sGSDisciplinaCriteria.listDisciplina();
		length =sGSDisciplinas== null ? 0 : Math.min(sGSDisciplinas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sGSDisciplinas[i]);
		}
		System.out.println(length + " Disciplina record(s) retrieved."); 
		
		System.out.println("Listing Curso by Criteria...");
		sgs.CursoCriteria sGSCursoCriteria = new sgs.CursoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sGSCursoCriteria.Codigo.eq();
		sGSCursoCriteria.setMaxResults(ROW_COUNT);
		sgs.Curso[] sGSCursos = sGSCursoCriteria.listCurso();
		length =sGSCursos== null ? 0 : Math.min(sGSCursos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sGSCursos[i]);
		}
		System.out.println(length + " Curso record(s) retrieved."); 
		
		System.out.println("Listing Administrador by Criteria...");
		sgs.AdministradorCriteria sGSAdministradorCriteria = new sgs.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sGSAdministradorCriteria.Email.eq();
		sGSAdministradorCriteria.setMaxResults(ROW_COUNT);
		sgs.Administrador[] sGSAdministradors = sGSAdministradorCriteria.listAdministrador();
		length =sGSAdministradors== null ? 0 : Math.min(sGSAdministradors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sGSAdministradors[i]);
		}
		System.out.println(length + " Administrador record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListSistemadeGestãodeSalasData listSistemadeGestãodeSalasData = new ListSistemadeGestãodeSalasData();
			try {
				listSistemadeGestãodeSalasData.listTestData();
				//listSistemadeGestãodeSalasData.listByCriteria();
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
