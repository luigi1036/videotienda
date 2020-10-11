package co.com.sured.videotienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sured.videotienda.model.Prestamo;
import co.com.sured.videotienda.model.VideoJuego;
import co.com.sured.videotienda.services.IPrestamoService;

@RestController
@RequestMapping("/prestamo")
public class PrestamosController {
	
	
	@Autowired
	IPrestamoService prestamoService;
	
	
	@PostMapping("/crearPrestamo")
	public Prestamo guardar(@RequestBody Prestamo prestamo) {
		return prestamoService.crear(prestamo);
		
	}
	

}
