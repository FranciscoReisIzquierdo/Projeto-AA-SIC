package SGS;

public abstract class Evento {
	private long _horaInicio;
	private long _horaFim;
	private String _nome;
	private String _codigo;
	public Sala _sala;
	public Sala _unnamed_Sala_;

	public void setHoraInicio(long aHoraInicio) {
		this._horaInicio = aHoraInicio;
	}

	public long getHoraInicio() {
		return this._horaInicio;
	}

	public void setHoraFim(long aHoraFim) {
		this._horaFim = aHoraFim;
	}

	public long getHoraFim() {
		return this._horaFim;
	}

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public String getNome() {
		return this._nome;
	}

	public void setCodigo(String aCodigo) {
		this._codigo = aCodigo;
	}

	public String getCodigo() {
		return this._codigo;
	}
}