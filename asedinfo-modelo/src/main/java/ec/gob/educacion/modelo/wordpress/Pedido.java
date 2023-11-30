package ec.gob.educacion.modelo.wordpress;
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

/**
 * Persona generated by hbm2java
 */
@Entity
@Table(name = "wp_wc_order_stats")
public class Pedido implements java.io.Serializable {
	private static final long serialVersionUID = -8622196233866959952L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", unique = true, nullable = false, precision = 10, scale = 0)
	private Long orderId;
	
	@Column(name = "parent_id")
	private Long parentId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	@Column(name = "date_created", length = 23)
	private Date dateCreated;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	@Column(name = "date_created_gmt", length = 23)
	private Date dateCreatedGmt;
	
	@Column(name = "num_items_sold")
	private int numItemsSold;
	
	@Column(name = "total_sales")
	private double totalSales;
	
	@Column(name = "shipping_total")
	private double shippingTotal;
	
	@Column(name = "net_total")
	private double netTotal;
	
	@Column(name = "status")
	private String status;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private ClienteWP clienteWP;

	@Transient
	private Long customerId;
	
	public Pedido() {
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateCreatedGmt() {
		return dateCreatedGmt;
	}
	public void setDateCreatedGmt(Date dateCreatedGmt) {
		this.dateCreatedGmt = dateCreatedGmt;
	}
	public int getNumItemsSold() {
		return numItemsSold;
	}
	public void setNumItemsSold(int numItemsSold) {
		this.numItemsSold = numItemsSold;
	}
	public double getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}
	public double getShippingTotal() {
		return shippingTotal;
	}
	public void setShippingTotal(double shippingTotal) {
		this.shippingTotal = shippingTotal;
	}
	public double getNetTotal() {
		return netTotal;
	}
	public void setNetTotal(double netTotal) {
		this.netTotal = netTotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public ClienteWP getClienteWP() {
		return clienteWP;
	}
	public void setClienteWP(ClienteWP clienteWP) {
		this.clienteWP = clienteWP;
	}
}
