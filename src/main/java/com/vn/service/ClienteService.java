package com.vn.service;

import java.util.List;

import com.vn.entity.Cliente;
import com.vn.exception.ResourceNotFoundException;

/* Usaremos siempre interficies para los Service, 
 * facilitando a Spring el mecanismo de inyección en tiempo de ejecución y el ciclo de vida de los beans */
public interface ClienteService {

	public List<Cliente> getClientes();
	
	public void saveCliente(Cliente elCliente);
	
	public Cliente getCliente(int id) throws ResourceNotFoundException;
	
	public void deleteCliente(int idId);
}

