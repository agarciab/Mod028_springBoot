package com.vn.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.dto.Coche;

@Controller
@RequestMapping("/prueba")
public class PruebaController {

	@GetMapping("/hola")
	//@RequestMapping(path = "/hola", method = RequestMethod.GET)
	public String diHola() {
		return "hola";  //WEB-INF/views/hola.jsp
	}
	
	@GetMapping("/lista")
	public String lista(Model modelo) {
		Coche c1 = new Coche("BMW", "M2", 400);		
		Coche c2 = new Coche("Citroen", "C3", 75);		
		Coche c3 = new Coche("Seat", "Leon", 90);		
		Coche c4 = new Coche("Nissan", "Micra", 65);	
		
		modelo.addAttribute("coches", Arrays.asList(c1, c2, c3, c4));
		
		return "lista";
	}
}
