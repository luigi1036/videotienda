package co.com.sured.videotienda.model;

import java.util.Date;

public class VideoJuego {
	
	private Long id;
	private String nombre;
	private String director;
	private String protagonista;
	private String productor;
	private Date año;
	private String tecnologia;
	private double precioAlquiler;
	private double precioVenta;
	private int estado;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProtagonista() {
		return protagonista;
	}
	public void setProtagonista(String protagonista) {
		this.protagonista = protagonista;
	}
	public String getProductor() {
		return productor;
	}
	public void setProductor(String productor) {
		this.productor = productor;
	}
	public Date getAño() {
		return año;
	}
	public void setAño(Date año) {
		this.año = año;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	public double getPrecioAlquiler() {
		return precioAlquiler;
	}
	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "juego [id=" + id + ", nombre=" + nombre + ", director=" + director + ", protagonista=" + protagonista
				+ ", productor=" + productor + ", año=" + año + ", tecnologia=" + tecnologia + ", precioAlquiler="
				+ precioAlquiler + ", precioVenta=" + precioVenta + ", estado=" + estado + "]";
	}
	
	
	

}
