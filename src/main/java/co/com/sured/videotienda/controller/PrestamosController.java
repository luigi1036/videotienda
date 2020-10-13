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

import co.com.sured.videotienda.model.Prestamo;
import co.com.sured.videotienda.services.IPrestamoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/prestamo")
public class PrestamosController {
	
	
	@Autowired
	IPrestamoService prestamoService;
	
	/*Lista todos los prestamos relaizados hasta el momento*/
	@GetMapping("/listarPrestamo")
	public List<Prestamo> listar() {
		return prestamoService.findAll();
	}
	
	/*Registra en la base de datos un prestamo nuevo 
	 * Entrada: id_juego obligatorio:integer, cedula_cliente obligatorio:String(15), fecha_prestamo obligatorio:date,
	 * fecha_vencimiento obligatorio:date, fecha_entrega_date, estado:integer
	 * Salida: retorna el prestamo nuevo que se registro en la base de datos*/
	@PostMapping("/crearPrestamo")
	public ResponseEntity<?> guardar(@RequestBody Prestamo prestamo) {
		Prestamo prestamonuevo=null;
		Map<String, Object> response = new HashMap<>();
		try {
			prestamonuevo = prestamoService.crear(prestamo);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al Crear el Prestamo");
			response.put("error", e.getMessage() + ":" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "El Prestamo se creo con exito");
		response.put("cliente", prestamonuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	/*Busca un prestamo por su id
	 * Entrada: id obligatorio: integer
	 * Salida: retorna el Prestamo consultado*/
	@GetMapping("/prestamo/{id}")
	public ResponseEntity<?> buscarById(@PathVariable Long id) {
		Prestamo prestamo=null;
		Map<String, Object> response = new HashMap<>();
		try {
			prestamo = prestamoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al consultar el Prestamo");
			response.put("error", e.getMessage() + ":" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if(prestamo==null) {
			response.put("mensaje", "El Prestamo con el id + " + id.toString() + "No existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Prestamo>(prestamo, HttpStatus.OK);
	}
	
	/*Actualiza un Prestamo consultado por su id
	 * Entrada id obligatorio: integer
	 * Salida retorna el Prestamo actualizado*/
	@PutMapping("/prestamoUpdate/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Prestamo prestamo, @PathVariable Long id) throws Exception {
		Prestamo prestamoactual = prestamoService.findById(id);
		Prestamo prestamoactualizado = null;
		Map<String, Object> response = new HashMap<>();
		if(prestamoactual==null) {
			response.put("mensaje", "El Prestamo con el id:" + id.toString() + ", No existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			
			prestamoactual.setIdJuego(prestamo.getIdJuego());
			prestamoactual.setcedulaCliente(prestamo.getcedulaCliente());
			prestamoactual.setFechaAlquiler(prestamo.getFechaAlquiler());
			prestamoactual.setFechaVencimiento(prestamo.getFechaVencimiento());
			prestamoactual.setFechaEntrega(prestamo.getFechaEntrega());
			prestamoactual.setEstado(prestamo.getEstado());
			
			prestamoactualizado = prestamoService.crear(prestamo);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al Actualizar el Prestamo");
			response.put("error", e.getMessage() + ":" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "El cliente se Actualizo con exito");
		response.put("cliente", prestamoactualizado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	

}
