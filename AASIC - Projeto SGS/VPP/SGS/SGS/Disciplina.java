package SGS;

import java.util.HashSet;
import SGS.Aula;
import SGS.Aluno;

public class Disciplina {
	private String _nome;
	private String _descricao;
	private int _cargaHoraria;
	private String _codigo;
	public Curso _curso;
	public HashSet<Aula> _unnamed_Aula_ = new HashSet<Aula>();
	public Docente _docente;
	public HashSet<Aluno> _unnamed_Aluno_ = new HashSet<Aluno>();
	public HashSet<Aluno> _inscritos = new HashSet<Aluno>();

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public String getNome() {
		return this._nome;
	}

	public void setDescricao(String aDescricao) {
		this._descricao = aDescricao;
	}

	public String getDescricao() {
		return this._descricao;
	}

	public void setCargaHoraria(int aCargaHoraria) {
		this._cargaHoraria = aCargaHoraria;
	}

	public int getCargaHoraria() {
		return this._cargaHoraria;
	}

	public void setCodigo(String aCodigo) {
		this._codigo = aCodigo;
	}

	public String getCodigo() {
		return this._codigo;
	}
}