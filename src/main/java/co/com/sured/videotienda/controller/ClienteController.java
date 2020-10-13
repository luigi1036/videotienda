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

import co.com.sured.videotienda.model.Cliente;
import co.com.sured.videotienda.services.IClienteServices;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	
	@Autowired
	IClienteServices clienteServices;
	
	/*Obtiene todos los clientes registrados en la base de datos*/
	@GetMapping("/listarClientes")
	public List<Cliente> listar() {
		return clienteServices.findAll();
	}
	
	/*Registra el la base de datos un cliente nuevo 
	 * Entrada: cedula obligatorio: String(15), tipo documento:intiger, primer nombre obligatorio: String(45)
	 * segundo nombre:String(45), primer apellido obligatorio: string(45), segundo apellido:String(45), telefono: String(15)
	 * email: string(45), fecha nacimiento: date, estado:integer.
	 * Salida: Retorna el cliente que se ingreso en la base de datos*/
	@PostMapping("/crearCliente")
	public ResponseEntity<?> guardar(@RequestBody Cliente cliente) {
		Cliente clientenuevo =null;
		Map<String, Object> response = new HashMap<>();
		try {
		 clientenuevo = clienteServices.guardar(cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al Insertar el cliente");
			response.put("error", e.getMessage() + ":" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "El cliente se creo con exito");
		response.put("cliente", clientenuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	/*Busca un cliente por su id
	 * Entrada: id obligatorio: integer
	 * Salida: retorna el cliente consultado*/
	@GetMapping("/cliente/{id}")
	public ResponseEntity<?> buscarById(@PathVariable Long id) {
		Cliente cliente = null;
		Map<String, Object> response = new HashMap<>();
		try {
		 cliente = clienteServices.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al consultar el cliente");
			response.put("error", e.getMessage() + ":" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if(cliente==null) {
			response.put("mensaje", "El cliente con el id + " + id.toString() + "No existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	/*Actualiza un cliente consultado por su id
	 * Entrada id obligatorio: integer
	 * Salida retorna el cliente actualizado*/
	@PutMapping("/clienteUpdate/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Cliente cliente, @PathVariable Long id) throws Exception {
			Cliente clienteactual = clienteServices.findById(id);
			Cliente clienteactualizado =null;
			Map<String, Object> response = new HashMap<>();
		
			if(clienteactual==null) {
				response.put("mensaje", "El cliente con el id:" + id.toString() + ", No existe");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

			}
			try {
				clienteactual.setCedula(cliente.getCedula());
				clienteactual.setTipoDocumento(cliente.getTipoDocumento());
				clienteactual.setPrimerNombre(cliente.getPrimerNombre());
				clienteactual.setSegundoNombre(cliente.getSegundoNombre());
				clienteactual.setPrimerApellido(cliente.getPrimerApellido());
				clienteactual.setSegundoApellido(cliente.getSegundoApellido());
				clienteactual.setTelefono(cliente.getTelefono());
				clienteactual.setEmail(cliente.getEmail());
				clienteactual.setFechaNacimiento(cliente.getFechaNacimiento());
				clienteactual.setEstado(cliente.getEstado());
				
				clienteactualizado = clienteServices.guardar(clienteactual);
				
			} catch (DataAccessException e) {
				response.put("mensaje", "Error al Actualizar el cliente");
				response.put("error", e.getMessage() + ":" + e.getMostSpecificCause().getMessage());
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			response.put("mensaje", "El cliente se Actualizo con exito");
			response.put("cliente", clienteactualizado);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);	
			
		
	}
	
	
	

}
