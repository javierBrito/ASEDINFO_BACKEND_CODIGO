package ec.gob.educacion.modelo.DTO;

public class ResultadoDTO {

	private Long codSubcategoria;
	private Long codInstancia;
	private Long codParticipante;
	private String nombreParticipante;
	private Float puntaje;

	public ResultadoDTO() {
	}

	public ResultadoDTO(Long codSubcategoria, Long codInstancia, Long codParticipante, String nombreParticipante,
			Float puntaje) {
		super();
		this.codSubcategoria = codSubcategoria;
		this.codInstancia = codInstancia;
		this.codParticipante = codParticipante;
		this.nombreParticipante = nombreParticipante;
		this.puntaje = puntaje;
	}

	public Long getCodSubcategoria() {
		return codSubcategoria;
	}

	public void setCodSubcategoria(Long codSubcategoria) {
		this.codSubcategoria = codSubcategoria;
	}

	public Long getCodInstancia() {
		return codInstancia;
	}

	public void setCodInstancia(Long codInstancia) {
		this.codInstancia = codInstancia;
	}

	public Long getCodParticipante() {
		return codParticipante;
	}

	public void setCodParticipante(Long codParticipante) {
		this.codParticipante = codParticipante;
	}

	public String getNombreParticipante() {
		return nombreParticipante;
	}

	public void setNombreParticipante(String nombreParticipante) {
		this.nombreParticipante = nombreParticipante;
	}

	public Float getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Float puntaje) {
		this.puntaje = puntaje;
	}
}
