package co.com.sured.videotienda.dao;

import org.springframework.data.repository.CrudRepository;

import co.com.sured.videotienda.model.Cliente;

public interface ICliente extends CrudRepository<Cliente, Long>{

}
