package co.com.sured.videotienda.services;

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

}
