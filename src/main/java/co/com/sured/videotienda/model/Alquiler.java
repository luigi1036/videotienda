package co.com.sured.videotienda.model;

import java.util.Date;

public class Alquiler {
	
	private Long id;
	private Long idJuego;
	private String cedula;
	private Date fechaAlquiler;
	private Date fechaVencimiento;
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
		return "Alquiler [id=" + id + ", idJuego=" + idJuego + ", cedula=" + cedula + ", fechaAlquiler=" + fechaAlquiler
				+ ", fechaVencimiento=" + fechaVencimiento + ", fechaEntregado=" + fechaEntregado + ", estado=" + estado
				+ "]";
	}
	
	

}
