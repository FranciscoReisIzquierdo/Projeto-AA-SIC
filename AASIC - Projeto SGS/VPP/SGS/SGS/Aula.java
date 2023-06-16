package SGS;

import java.util.HashSet;
import SGS.Aluno;

public class Aula extends Evento {
	private String _turno;
	public Disciplina _disciplina;
	public HashSet<Aluno> _presentes = new HashSet<Aluno>();
	public HashSet<Aluno> _inscritos = new HashSet<Aluno>();
	public Docente _docente;

	public void setTurno(String aTurno) {
		this._turno = aTurno;
	}

	public String getTurno() {
		return this._turno;
	}
}