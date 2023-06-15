package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Pasaporte;
import com.example.demo.repository.modelo.Persona;
import com.example.demo.service.IPasaporteService;
import com.example.demo.service.IPersonaService;

@SpringBootApplication
public class Ejercicio10MapeoOneToOnePersonaPasaporteApplication implements CommandLineRunner {

	@Autowired
	private IPersonaService personaService;
	@Autowired
	private IPasaporteService pasaporteService;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio10MapeoOneToOnePersonaPasaporteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// 1.Creamos una persona y un pasaporte
		// persona
		Persona persona1 = new Persona();
		persona1.setCedula("1726890000");
		persona1.setEdad("20");
		persona1.setNombre("Juan Carlos");

		// pasaporte
		Pasaporte pasaporte1 = new Pasaporte();
		pasaporte1.setNumero("00001");
		pasaporte1.setPais("Estados unidos");
		// seteamos las entidades
		pasaporte1.setPersona(persona1);
		persona1.setPasaporte(pasaporte1);

		// inserteamos en la base la persona y el pasaporte
		this.personaService.guarda(persona1);

		// 2.Seleccionamos buscamos una persona y un pasaporte
		this.pasaporteService.seleccionar(1);
		this.personaService.seleccionar(1);

		// 3.actualizamos una persona y un pasaporte
		persona1.setEdad("25");
		this.personaService.actualizar(persona1);
		pasaporte1.setPais("Ecuador");
		this.pasaporteService.actualizar(pasaporte1);

		// 4.eliminamos una persona y un pasaporte
		this.personaService.borrar(2);
		//this.pasaporteService.borrar(1);

	}

}
