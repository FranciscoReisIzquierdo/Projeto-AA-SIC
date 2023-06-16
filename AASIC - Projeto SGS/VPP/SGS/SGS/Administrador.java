package SGS;

public class Administrador {
	private String _nome;
	private String _senha;
	private String _email;

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public String getNome() {
		return this._nome;
	}

	public void setSenha(String aSenha) {
		this._senha = aSenha;
	}

	public String getSenha() {
		return this._senha;
	}

	public void setEmail(String aEmail) {
		this._email = aEmail;
	}

	public String getEmail() {
		return this._email;
	}
}