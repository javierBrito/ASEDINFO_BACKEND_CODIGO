package ec.gob.educacion.modelo.catalogo;
// default package

// Generated Oct 29, 2013 4:10:51 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * wp_sub_categoria generated by hbm2java
 */
@Entity
@Table(name = "wp_sub_categoria")
public class Subcategoria implements java.io.Serializable {
	private static final long serialVersionUID = -8622196233866959952L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo", unique = true, nullable = false, precision = 10, scale = 0)
	private Long codigo;

	@Column(name = "denominacion")
	private String denominacion;

	@Column(name = "estado", nullable = false, length = 1)
	private String estado;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cod_categoria", nullable = false)
	private Categoria categoria;

	@Transient
	private Long codCategoria;
	@Transient
	private String desCategoria;

	public Subcategoria() {
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getCodCategoria() {
		if (this.categoria != null) {
			codCategoria = this.categoria.getCodigo();
		}
		return codCategoria;
	}

	public void setCodCategoria(Long codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getDesCategoria() {
		if (this.categoria != null) {
			desCategoria = this.categoria.getDenominacion();
		}
		return desCategoria;
	}

	public void setDesCategoria(String desCategoria) {
		this.desCategoria = desCategoria;
	}
}
