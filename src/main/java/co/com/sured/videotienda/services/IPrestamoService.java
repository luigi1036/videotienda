package co.com.sured.videotienda.services;

import java.util.List;

import co.com.sured.videotienda.model.Prestamo;

public interface IPrestamoService {
	
	
	public Prestamo crear(Prestamo prestamo);
	
	public List<Prestamo> findAll();
	
	public Prestamo actualizar(Prestamo prestamo, Long id) throws Exception;
	
	public Prestamo findById(Long id);

}
