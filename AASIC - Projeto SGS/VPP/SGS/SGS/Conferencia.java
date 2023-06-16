package SGS;

import java.util.HashSet;
import SGS.Utilizador;

public class Conferencia extends Evento {
	private boolean _livre;
	private String _descrição;
	private String _orador;
	private String _tema;
	public HashSet<Utilizador> _inscritos = new HashSet<Utilizador>();

	public void setLivre(boolean aLivre) {
		this._livre = aLivre;
	}

	public boolean isLivre() {
		return this._livre;
	}

	public void setDescrição(String aDescrição) {
		this._descrição = aDescrição;
	}

	public String getDescrição() {
		return this._descrição;
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