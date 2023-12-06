package ec.gob.educacion.modelo.competencia;
// default package

// Generated Oct 29, 2013 4:10:51 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import ec.gob.educacion.modelo.catalogo.Instancia;
import ec.gob.educacion.modelo.catalogo.Persona;
import ec.gob.educacion.modelo.catalogo.Subcategoria;

/**
 * Participante generated by hbm2java
 */
@Entity
@Table(name = "wp_participante")
public class Participante implements java.io.Serializable {
	private static final long serialVersionUID = -8622196233866959952L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo", unique = true, nullable = false, precision = 10, scale = 0)
	private Long codigo;
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	@Column(name = "date_last_active", length = 23)
	private Date dateLastActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	@Column(name = "date_registered", length = 23)
	private Date dateRegistered;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cod_persona", nullable = false)
	private Persona persona;

	@Transient
	private Long codPersona;
	@Transient
	private String nombrePersona;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cod_subcategoria", nullable = false)
	private Subcategoria subcategoria;
	
	@Transient
	private Long codSubcategoria;
	@Transient
	private String desSubcategoria;
	@Transient
	private Long codCategoria;
	@Transient
	private String desCategoria;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cod_instancia", nullable = false)
	private Instancia instancia;
	
	@Transient
	private Long codInstancia;
	@Transient
	private String desInstancia;
	
	public Participante() {
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateLastActive() {
		return dateLastActive;
	}

	public void setDateLastActive(Date dateLastActive) {
		this.dateLastActive = dateLastActive;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodPersona() {
		if (this.persona != null) {
			codPersona = this.persona.getCodigo();
		}
		return codPersona;
	}

	public void setCodPersona(Long codPersona) {
		this.codPersona = codPersona;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getNombrePersona() {
		if (this.persona != null) {
			nombrePersona = this.persona.getNombres() + " " + this.persona.getApellidos();
		}
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public Long getCodSubcategoria() {
		if (this.subcategoria != null) {
			codSubcategoria = this.subcategoria.getCodigo();
		}
		return codSubcategoria;
	}

	public void setCodSubcategoria(Long codSubcategoria) {
		this.codSubcategoria = codSubcategoria;
	}

	public String getDesSubcategoria() {
		if (this.subcategoria != null) {
			desSubcategoria = this.subcategoria.getDenominacion();
		}
		return desSubcategoria;
	}

	public void setDesSubcategoria(String desSubcategoria) {
		this.desSubcategoria = desSubcategoria;
	}

	public Long getCodCategoria() {
		if (this.subcategoria != null) {
			codCategoria = this.subcategoria.getCategoria().getCodigo();
		}
		return codCategoria;
	}

	public void setCodCategoria(Long codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getDesCategoria() {
		if (this.subcategoria != null) {
			desCategoria = this.subcategoria.getCategoria().getDenominacion();
		}
		return desCategoria;
	}

	public void setDesCategoria(String desCategoria) {
		this.desCategoria = desCategoria;
	}

	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}
	

	public Instancia getInstancia() {
		return instancia;
	}

	public void setInstancia(Instancia instancia) {
		this.instancia = instancia;
	}

	public Long getCodInstancia() {
		if (this.instancia != null) {
			codInstancia = this.instancia.getCodigo();
		}
		return codInstancia;
	}

	public void setCodInstancia(Long codInstancia) {
		this.codInstancia = codInstancia;
	}

	public String getDesInstancia() {
		if (this.instancia != null) {
			desInstancia = this.instancia.getDenominacion();
		}
		return desInstancia;
	}

	public void setDesInstancia(String desInstancia) {
		this.desInstancia = desInstancia;
	}

}
