package co.com.sured.videotienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sured.videotienda.dao.IPrestamo;
import co.com.sured.videotienda.model.Prestamo;

@Service
public class PrestamoServiceImp implements IPrestamoService{
	
	
	@Autowired
	IPrestamo  Iprestamo;

	@Override
	public Prestamo crear(Prestamo prestamo) {
		return Iprestamo.save(prestamo);
	}

	@Override
	public List<Prestamo> findAll() {
		
		return (List<Prestamo>) Iprestamo.findAll();
	}

	@Override
	public Prestamo actualizar(Prestamo prestamo, Long id) throws Exception {
		
		return Iprestamo.save(prestamo);
	}

	@Override
	public Prestamo findById(Long id) {
		
		return Iprestamo.findById(id).orElse(null);
	}

}
