package ec.gob.educacion.modelo.competencia;
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
import com.fasterxml.jackson.annotation.JsonIgnore;
import ec.gob.educacion.modelo.catalogo.ModeloPuntaje;
import ec.gob.educacion.modelo.seguridad.Usuario;

/**
 * wp_integrante generated by hbm2java
 */
@Entity
@Table(name = "wp_usuario_modelo_puntaje")
public class UsuarioModeloPuntaje implements java.io.Serializable {
	private static final long serialVersionUID = -8622196233866959952L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo", unique = true, nullable = false, precision = 10, scale = 0)
	private Long codigo;

	@Column(name = "estado", nullable = false, length = 1)
	private String estado;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cod_modelo_puntaje", nullable = false)
	private ModeloPuntaje modeloPuntaje;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cod_usuario", nullable = false)
	private Usuario usuario;
	
	private transient Long codModeloPuntaje;
	private transient Long codUsuario;

	public UsuarioModeloPuntaje() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ModeloPuntaje getModeloPuntaje() {
		return modeloPuntaje;
	}

	public void setModeloPuntaje(ModeloPuntaje modeloPuntaje) {
		this.modeloPuntaje = modeloPuntaje;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodModeloPuntaje() {
		if (modeloPuntaje != null) {
			codModeloPuntaje = modeloPuntaje.getCodigo();
		}
		return codModeloPuntaje;
	}

	public void setCodModeloPuntaje(Long codModeloPuntaje) {
		this.codModeloPuntaje = codModeloPuntaje;
	}

	public Long getCodUsuario() {
		if (usuario != null) {
			codUsuario = usuario.getCodigo();
		}
		return codUsuario;
	}

	public void setCodUsuario(Long codUsuario) {
		this.codUsuario = codUsuario;
	}
}
