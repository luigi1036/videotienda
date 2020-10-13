package co.com.sured.videotienda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sured.videotienda.model.VideoJuego;
import co.com.sured.videotienda.services.IVideoJuegoServices;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/videojuego")
public class VideoJuegoController {
	
	@Autowired
	IVideoJuegoServices videoJuegoServices;
	
	/*Consulta todos los video juego disponibles
	 * Entrada:
	 * 
	 * Salida:Lista de los videos juegos disponibles*/
	@GetMapping("/listarvideosjuegos")
	public List<VideoJuego> index() {
		return videoJuegoServices.findAll();
	}
	
	/*Registra en la base de datos un video Juego nuevo 
	 * Entrada: nombre obligatorio: String(45), director:String(45), protagonista obligatorio: String(45)
	 * productora:String(45), año de lanzamineto: integer, tecnologia obligatorio: string(45), precio de alquiler:double
	 * precio de venta:double, estado:integer, stock:integer
	 * 
	 *   salida: retorna el video juego creado*/
	@PostMapping("/crearVideojuego")
	public ResponseEntity<?> guardar(@RequestBody VideoJuego videojuego) {
		VideoJuego videojuegonuevo=null;
		Map<String, Object> response = new HashMap<>();
		try {
			videojuegonuevo = videoJuegoServices.guardar(videojuego);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al Insertar el Video Juego");
			response.put("error", e.getMessage() + ":" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "El Video Juego se creo con exito");
		response.put("videoJuego", videojuegonuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	/*Busca un video juego por su id
	 * Entrada: id obligatorio:integer
	 * Salida: retorna el video juego consultado*/
	@GetMapping("/videoJuego/{id}")
	public ResponseEntity<?> buscarById(@PathVariable Long id) {
		VideoJuego videojuego=null;
		Map<String, Object> response = new HashMap<>();
		try {
			videojuego = videoJuegoServices.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al consultar el video Juego");
			response.put("error", e.getMessage() + ":" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(videojuego==null) {
			response.put("mensaje", "El Video Juego con el id + " + id.toString() + "No existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity<VideoJuego>(videojuego, HttpStatus.OK);
	
	}
	
	/*Actualiza un video juego consultado por su id
	 * Entrada: id obligatorio:integer
	 * Salida: retorna el video juego actualizado*/
	@PutMapping("/videoJuegoUpdate/{id}")
	public ResponseEntity<?> actualizar(@RequestBody VideoJuego videojuego, @PathVariable Long id) throws Exception {
		
		VideoJuego videojuegoactual =  videoJuegoServices.findById(id);
		VideoJuego videojuegoActualizado = null;
		Map<String, Object> response = new HashMap<>();
		
		if(videojuegoactual==null) {
			response.put("mensaje", "El Video JUego con el id:" + id.toString() + ", No existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			
			videojuegoactual.setNombre(videojuego.getNombre());
			videojuegoactual.setDirector(videojuego.getDirector());
			videojuegoactual.setProtagonista(videojuego.getProtagonista());
			videojuegoactual.setProductora(videojuego.getProductora());
			videojuegoactual.setAno(videojuego.getAno());
			videojuegoactual.setTecnologia(videojuego.getTecnologia());
			videojuegoactual.setPrecioAlquiler(videojuego.getPrecioAlquiler());
			videojuegoactual.setPrecioVenta(videojuego.getPrecioVenta());
			videojuegoactual.setEstado(videojuego.getEstado());
			videojuegoactual.setStock(videojuego.getStock());
			
			videojuegoActualizado = videoJuegoServices.guardar(videojuegoactual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al Actualizar el Video Juego");
			response.put("error", e.getMessage() + ":" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "El cliente se Actualizo con exito");
		response.put("cliente", videojuegoActualizado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	


}
