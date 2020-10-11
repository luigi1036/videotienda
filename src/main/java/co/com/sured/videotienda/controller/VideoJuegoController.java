package co.com.sured.videotienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sured.videotienda.model.Cliente;
import co.com.sured.videotienda.model.VideoJuego;
import co.com.sured.videotienda.services.IVideoJuegoServices;

@RestController
@RequestMapping("/videojuego")
public class VideoJuegoController {
	
	@Autowired
	IVideoJuegoServices videoJuegoServices;
	
	@GetMapping("/listarvideosjuegos")
	public List<VideoJuego> index() {
		return videoJuegoServices.findAll();
	}
	

	@PostMapping("/crearVideojuego")
	public VideoJuego guardar(@RequestBody VideoJuego videojuego) {
		System.err.println("hola" + videojuego.toString());
		return videoJuegoServices.guardar(videojuego);
		
	}
	
	@GetMapping("/videoJuego/{id}")
	public VideoJuego buscarById(@PathVariable Long id) {
		return videoJuegoServices.findById(id);
	}
	
	@PutMapping("/videoJuegoUpdate/{id}")
	public VideoJuego actualizar(@RequestBody VideoJuego videojuego, @PathVariable Long id) throws Exception {
		return videoJuegoServices.actualizar(videojuego, id);
	}
	

}
