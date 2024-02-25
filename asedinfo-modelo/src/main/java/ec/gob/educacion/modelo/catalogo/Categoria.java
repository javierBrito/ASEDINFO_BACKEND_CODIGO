package ec.gob.educacion.modelo.catalogo;
// default package

// Generated Oct 29, 2013 4:10:51 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * wp_categoria generated by hbm2java
 */
@Entity
@Table(name = "wp_categoria")
public class Categoria implements java.io.Serializable {
	private static final long serialVersionUID = -8622196233866959952L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo", unique = true, nullable = false, precision = 10, scale = 0)
	private Long codigo;

	@Column(name = "denominacion")
	private String denominacion;

	@Column(name = "estado", nullable = false, length = 1)
	private String estado;
	
	@Column(name = "edad_minima")
	private Float edadMinima;
	
	@Column(name = "edad_maxima")
	private Float edadMaxima;
	
	@Column(name = "num_jueces")
	private int numJueces;

	public Categoria() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Float getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(Float edadMinima) {
		this.edadMinima = edadMinima;
	}

	public Float getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(Float edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	public int getNumJueces() {
		return numJueces;
	}

	public void setNumJueces(int numJueces) {
		this.numJueces = numJueces;
	}
}
