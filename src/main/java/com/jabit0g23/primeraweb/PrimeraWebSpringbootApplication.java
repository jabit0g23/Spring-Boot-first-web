package com.jabit0g23.primeraweb;

import com.jabit0g23.primeraweb.entities.Persona;
import com.jabit0g23.primeraweb.repository.PersonaRepository;
import com.jabit0g23.primeraweb.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimeraWebSpringbootApplication{

	@Autowired
	private PersonaService personaService;

	public static void main(String[] args){
		SpringApplication.run(PrimeraWebSpringbootApplication.class, args);

		System.out.println("Hello World");
	}

}
