package SGS;

import java.util.HashSet;
import SGS.Disciplina;
import SGS.Aluno;

public class Curso {
	private String _nome;
	private int _duracao;
	private String _descricao;
	private String _codigo;
	public HashSet<Disciplina> _unnamed_Disciplina_ = new HashSet<Disciplina>();
	public HashSet<Aluno> _unnamed_Aluno_ = new HashSet<Aluno>();

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public String getNome() {
		return this._nome;
	}

	public void setDuracao(int aDuracao) {
		this._duracao = aDuracao;
	}

	public int getDuracao() {
		return this._duracao;
	}

	public void setDescricao(String aDescricao) {
		this._descricao = aDescricao;
	}

	public String getDescricao() {
		return this._descricao;
	}

	public void setCodigo(String aCodigo) {
		this._codigo = aCodigo;
	}

	public String getCodigo() {
		return this._codigo;
	}
}