package SGS;

import java.util.HashSet;
import SGS.Aula;
import SGS.Disciplina;

public class Docente extends Utilizador {
	private String _departamento;
	public HashSet<Aula> _unnamed_Aula_ = new HashSet<Aula>();
	public HashSet<Disciplina> _unnamed_Disciplina_ = new HashSet<Disciplina>();

	public void setDepartamento(String aDepartamento) {
		this._departamento = aDepartamento;
	}

	public String getDepartamento() {
		return this._departamento;
	}
}