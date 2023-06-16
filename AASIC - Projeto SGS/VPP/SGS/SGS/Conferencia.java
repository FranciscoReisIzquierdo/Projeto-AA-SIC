package SGS;

import java.util.HashSet;
import SGS.Utilizador;

public class Conferencia extends Evento {
	private boolean _livre;
	private String _descri��o;
	private String _orador;
	private String _tema;
	public HashSet<Utilizador> _inscritos = new HashSet<Utilizador>();

	public void setLivre(boolean aLivre) {
		this._livre = aLivre;
	}

	public boolean isLivre() {
		return this._livre;
	}

	public void setDescri��o(String aDescri��o) {
		this._descri��o = aDescri��o;
	}

	public String getDescri��o() {
		return this._descri��o;
	}

	public void setOrador(String aOrador) {
		this._orador = aOrador;
	}

	public String getOrador() {
		return this._orador;
	}

	public void setTema(String aTema) {
		this._tema = aTema;
	}

	public String getTema() {
		return this._tema;
	}
}