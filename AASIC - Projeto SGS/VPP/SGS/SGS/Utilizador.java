package SGS;

import java.util.HashSet;
import SGS.Conferencia;

public class Utilizador {
	private String _nome;
	private int _idade;
	private String _numero;
	private String _email;
	private String _senha;
	private char _genero;
	public HashSet<Conferencia> _unnamed_Conferencia_ = new HashSet<Conferencia>();

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public String getNome() {
		return this._nome;
	}

	public void setIdade(int aIdade) {
		this._idade = aIdade;
	}

	public int getIdade() {
		return this._idade;
	}

	public void setNumero(String aNumero) {
		this._numero = aNumero;
	}

	public String getNumero() {
		return this._numero;
	}

	public void setEmail(String aEmail) {
		this._email = aEmail;
	}

	public String getEmail() {
		return this._email;
	}

	public void setSenha(String aSenha) {
		this._senha = aSenha;
	}

	public String getSenha() {
		return this._senha;
	}

	public void setGenero(char aGenero) {
		this._genero = aGenero;
	}

	public char getGenero() {
		return this._genero;
	}
}