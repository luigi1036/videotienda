package co.com.sured.videotienda.services;

import java.util.List;

import co.com.sured.videotienda.model.Cliente;

public interface IClienteServices {
	
	public List<Cliente> findAll();
	
	public Cliente guardar(Cliente cliente);
	
	public Cliente actualizar(Cliente ciente, Long id) throws Exception;
	
	public Cliente findById(Long id);
	

}
