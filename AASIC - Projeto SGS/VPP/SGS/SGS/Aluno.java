package SGS;

import java.util.HashSet;
import SGS.Aula;
import SGS.Disciplina;

public class Aluno extends Utilizador {
	private int _ano;
	public HashSet<Aula> _unnamed_Aula_ = new HashSet<Aula>();
	public Curso _curso;
	public HashSet<Aula> _unnamed_Aula_2 = new HashSet<Aula>();
	public HashSet<Disciplina> _disciplinas = new HashSet<Disciplina>();
	public HashSet<Disciplina> _unnamed_Disciplina_ = new HashSet<Disciplina>();

	public void setAno(int aAno) {
		this._ano = aAno;
	}

	public int getAno() {
		return this._ano;
	}
}