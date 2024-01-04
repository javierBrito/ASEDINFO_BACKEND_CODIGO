package ec.gob.educacion.modelo.catalogo;

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

import ec.gob.educacion.modelo.venta.Cliente;

/**
 * cat_transaccion generated by hbm2java
 */
@Entity
@Table(name = "cat_transaccion")
public class Transaccion implements java.io.Serializable {
	private static final long serialVersionUID = -8622196233866959952L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo", unique = true, nullable = false, precision = 10, scale = 0)
	private Long codigo;

	@Column(name = "cod_operacion")
	private Long codOperacion;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "clave_cuenta")
	private String claveCuenta;
	
	@Column(name = "precio")
	private float precio;
	
	@Column(name = "monto")
	private Float monto;
	
	@Column(name = "num_producto")
	private int numProducto;
	
	@Column(name = "num_mes")
	private int numMes;
	
	@Column(name = "aplica_iva")
	private int aplica;

	@Column(name = "estado", nullable = false, length = 1)
	private String estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio", length = 23)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date fechaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_fin", length = 23)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date fechaFin;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_cambia", length = 23)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date fechaCambia;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registra", length = 23)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date fechaRegistra;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cod_modulo", nullable = false)
	private Modulo modulo;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cod_cliente", nullable = false)
	private Cliente cliente;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cod_producto", nullable = false)
	private Producto producto;

	@Transient
	private Long codModulo;
	@Transient
	private Long codCliente;
	@Transient
	private String nombreCliente;
	@Transient
	private String celular;
	@Transient
	private Long codProducto;
	@Transient
	private String descripcionProducto;
	@Transient
	private float precioCosto;
	@Transient
	private int numExistenciaActual;
	@Transient
	private float precioMayoreo;

	public Transaccion() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getAplica() {
		return aplica;
	}

	public void setAplica(int aplica) {
		this.aplica = aplica;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRegistra() {
		return fechaRegistra;
	}

	public void setFechaRegistra(Date fechaRegistra) {
		this.fechaRegistra = fechaRegistra;
	}

	public Long getCodCliente() {
		if (cliente != null) {
			codCliente = cliente.getCodigo();
		}
		return codCliente;
	}

	public void setCodCliente(Long codCliente) {
		this.codCliente = codCliente;
	}

	public Long getCodProducto() {
		if (producto != null) {
			codProducto = producto.getCodigo();
		}
		return codProducto;
	}

	public void setCodProducto(Long codProducto) {
		this.codProducto = codProducto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getNumProducto() {
		return numProducto;
	}

	public void setNumProducto(int numProducto) {
		this.numProducto = numProducto;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getNumMes() {
		return numMes;
	}

	public void setNumMes(int numMes) {
		this.numMes = numMes;
	}

	public Long getCodModulo() {
		if (this.modulo != null) {
			codModulo = this.modulo.getCodigo();
		}
		return codModulo;
	}

	public void setCodModulo(Long codModulo) {
		this.codModulo = codModulo;
	}

	public Long getCodOperacion() {
		return codOperacion;
	}

	public void setCodOperacion(Long codOperacion) {
		this.codOperacion = codOperacion;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getNombreCliente() {
		if (cliente != null) {
			nombreCliente = cliente.getPersona().getNombres() + " " + cliente.getPersona().getApellidos(); 
		}
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDescripcionProducto() {
		if (producto != null) {
			descripcionProducto = producto.getDescripcion();
		}
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public String getCelular() {
		if (cliente != null) {
			celular = cliente.getPersona().getCelular(); 
		}
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public float getPrecioCosto() {
		if (producto != null) {
			precioCosto = producto.getPrecioCosto();
		}
		return precioCosto;
	}

	public void setPrecioCosto(float precioCosto) {
		this.precioCosto = precioCosto;
	}

	public int getNumExistenciaActual() {
		if (producto != null) {
			numExistenciaActual = producto.getNumExistenciaActual();
		}
		return numExistenciaActual;
	}

	public void setNumExistenciaActual(int numExistenciaActual) {
		this.numExistenciaActual = numExistenciaActual;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public float getPrecioMayoreo() {
		if (producto != null) {
			precioMayoreo = producto.getPrecioMayoreo();
		}
		return precioMayoreo;
	}

	public void setPrecioMayoreo(float precioMayoreo) {
		this.precioMayoreo = precioMayoreo;
	}

	public String getClaveCuenta() {
		return claveCuenta;
	}

	public void setClaveCuenta(String claveCuenta) {
		this.claveCuenta = claveCuenta;
	}

	public Date getFechaCambia() {
		return fechaCambia;
	}

	public void setFechaCambia(Date fechaCambia) {
		this.fechaCambia = fechaCambia;
	}
}
