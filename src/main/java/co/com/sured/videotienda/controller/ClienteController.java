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
import co.com.sured.videotienda.services.IClienteServices;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	
	@Autowired
	IClienteServices clienteServices;
	
	@GetMapping("/listarClientes")
	public List<Cliente> listar() {
		return clienteServices.findAll();
	}
	
	@PostMapping("/crearCliente")
	public Cliente guardar(@RequestBody Cliente cliente) {
		System.out.println("hola");
		return clienteServices.guardar(cliente);
		
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente buscarById(@PathVariable Long id) {
		return clienteServices.findById(id);
	}
	
	@PutMapping("/clienteUpdate/{id}")
	public Cliente actualizar(@RequestBody Cliente cliente, @PathVariable Long id) throws Exception {
		return clienteServices.actualizar(cliente, id);
	}

}
