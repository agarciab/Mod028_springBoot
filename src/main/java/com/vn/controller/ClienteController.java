package com.vn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.entity.Cliente;
import com.vn.exception.ResourceNotFoundException;
import com.vn.service.ClienteService;

/* Controlador principal de clientes */
@Controller
@RequestMapping("/cliente") // Responde a peticiones /cliente
public class ClienteController {

	// Configuramos el objeto que usaremos para dejar trazas en el log
	private static final Logger LOG = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired // Indicamos a Spring que debe instanciar e injectar el servicio
	private ClienteService clienteService;

	// Atiende a GET /cliente/list
	@GetMapping("/list")
	public String listClientes(Model model) {
		List <Cliente> lstClientes = clienteService.getClientes();
		model.addAttribute("clientes", lstClientes);
		return "lista-clientes";
	}

	// Atiende a GET /cliente/showForm
	@GetMapping("/showForm")
	public String showFormForAdd(Model model) {
		LOG.debug("handler del formulario del cliente");
		Cliente elCliente = new Cliente();
		model.addAttribute("cliente", elCliente);
		return "cliente-form";
	}

	// Atiende a POST /cliente/saveCliente
	@PostMapping("/saveCliente")
	public String saveCustomer(@ModelAttribute("cliente") Cliente elCliente) {
		clienteService.saveCliente(elCliente);
		return "redirect:/cliente/list";
	}

	// Atiende a GET /cliente/list
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("clienteId") int id, Model model) throws ResourceNotFoundException {
		Cliente elCliente = clienteService.getCliente(id);
		model.addAttribute("cliente", elCliente);
		return "cliente-form";
	}

	// Atiende a GET /cliente/delete
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("clienteId") int id) throws ResourceNotFoundException {
		clienteService.deleteCliente(id);
		return "redirect:/cliente/list";
	}

}
