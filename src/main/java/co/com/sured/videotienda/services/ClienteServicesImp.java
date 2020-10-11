package co.com.sured.videotienda.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sured.videotienda.dao.ICliente;
import co.com.sured.videotienda.model.Cliente;


@Service
public class ClienteServicesImp implements IClienteServices{
	
	
	@Autowired
	ICliente icliente; 
	
	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) icliente.findAll();
	}

	@Override
	@Transactional
	public Cliente guardar(Cliente cliente) {
		
		return icliente.save(cliente);
	}

	@Override
	public Cliente actualizar(Cliente cliente, Long id) throws Exception {
		
		Cliente clienteactual = icliente.findById(id).orElse(null);
		
		try {
			if(clienteactual!=null) {
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
			}
		} catch (Exception e) {
			throw new Exception("Error al actualizar el cliente");
		}
		
		
		
		
		return icliente.save(clienteactual);
	}
	

	@Override
	public Cliente findById(Long id) {
		
		return icliente.findById(id).orElse(null);
	}

}
