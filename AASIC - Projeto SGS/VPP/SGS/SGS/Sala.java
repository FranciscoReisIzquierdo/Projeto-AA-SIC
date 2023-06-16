package SGS;

import java.util.HashSet;
import SGS.Evento;

public class Sala {
	private int _capacidade;
	private String _codigo;
	private String _localizacao;
	private int _lotacao = 0;
	private SGS _contém;
	public HashSet<Evento> _unnamed_Evento_ = new HashSet<Evento>();
	public HashSet<Evento> _eventos = new HashSet<Evento>();

	public void setCapacidade(int aCapacidade) {
		this._capacidade = aCapacidade;
	}

	public int getCapacidade() {
		return this._capacidade;
	}

	public void setCodigo(String aCodigo) {
		this._codigo = aCodigo;
	}

	public String getCodigo() {
		return this._codigo;
	}

	public void setLocalizacao(String aLocalizacao) {
		this._localizacao = aLocalizacao;
	}

	public String getLocalizacao() {
		return this._localizacao;
	}

	public void setLotacao(int aLotacao) {
		this._lotacao = aLotacao;
	}

	public int getLotacao() {
		return this._lotacao;
	}
}