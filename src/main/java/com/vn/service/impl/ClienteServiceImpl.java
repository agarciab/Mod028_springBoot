package com.vn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.entity.Cliente;
import com.vn.exception.ResourceNotFoundException;
import com.vn.repository.ClienteRepository;
import com.vn.service.ClienteService;

@Service // Anotaremos las implemenmtaciones con @Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired // Inyectamos el repositorio
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public void saveCliente(Cliente elCliente) {
		clienteRepository.save(elCliente);
	}

	@Override
	public Cliente getCliente(int id) throws ResourceNotFoundException {
		return clienteRepository.findById(id).orElseThrow(ResourceNotFoundException::new); // Sintaxis disponible desde Java8 (lambdas)
	}

	@Override
	public void deleteCliente(int id) {
		clienteRepository.deleteById(id);
	}

}
