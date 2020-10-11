package co.com.sured.videotienda.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PRESTAMOS")
public class Prestamo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_juego")
	private Long idJuego;
	
	private String cedulaCliente;
	
	@Column(name="fecha_prestamo")
	@Temporal(TemporalType.DATE)
	private Date fechaAlquiler;
	
	@Column(name="fecha_vencimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaVencimiento;
	
	@Column(name="fecha_entregado")
	@Temporal(TemporalType.DATE)
	private Date fechaEntregado;
	
	private int estado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdJuego() {
		return idJuego;
	}
	public void setIdJuego(Long idJuego) {
		this.idJuego = idJuego;
	}
	public String getcedulaCliente() {
		return cedulaCliente;
	}
	public void setcedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}
	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Date getFechaEntregado() {
		return fechaEntregado;
	}
	public void setFechaEntregado(Date fechaEntregado) {
		this.fechaEntregado = fechaEntregado;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "prestamo [id=" + id + ", idJuego=" + idJuego + ", cedulaCliente=" + cedulaCliente + ", fechaAlquiler=" + fechaAlquiler
				+ ", fechaVencimiento=" + fechaVencimiento + ", fechaEntregado=" + fechaEntregado + ", estado=" + estado
				+ "]";
	}
	
	

}
