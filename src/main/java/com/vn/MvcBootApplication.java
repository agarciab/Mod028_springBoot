package com.vn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* Anotación principal de Spring Boot, declara la aplicación como Spring Boot 
y auto configura en base a los jars del classpath y propiedades por defecto 
tambien escanea los subpaquetes que estén por dejado de donde se declare esta classe en busca de beans */
@SpringBootApplication 
public class MvcBootApplication {

	/* Spring boot siempre tiene un main porque se ejecuta como aplicación corriente de Java */
	public static void main(String[] args) {
		SpringApplication.run(MvcBootApplication.class, args);
	}

}
