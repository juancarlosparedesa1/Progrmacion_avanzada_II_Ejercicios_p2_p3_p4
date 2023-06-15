package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.modelo.Empleado;
import com.example.demo.service.ICiudadanoService;
import com.example.demo.service.IEmpleadoService;

@SpringBootApplication
public class Ejercicio9MapeoOneToOneCiudadanoEmpleadoApplication implements CommandLineRunner {

	@Autowired
	private IEmpleadoService empleadoService;

	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio9MapeoOneToOneCiudadanoEmpleadoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// 1.Creamos y guardamos un empleado y un ciudadano
		// Creamos
		Empleado empleado1 = new Empleado();
		empleado1.setCargo("profesor");
		empleado1.setSueldo(new BigDecimal(1000));

		Ciudadano ciudadano1 = new Ciudadano();
		ciudadano1.setApellido("Paredes");
		ciudadano1.setCedula("1726890000");
		ciudadano1.setNombre("Juan Carlos");
		empleado1.setCiudadano(ciudadano1);
		ciudadano1.setEmpleado(empleado1);
		// si utilizo el cascade puedo agregar cualquiera
		// de las 2 entidades y se habra guardado las 2
		// Guardamos
		this.empleadoService.agregar(empleado1);
//		this.ciudadanoService.agregar(ciudadano1);
		// 2.buscamos un ciudadano y un empleado
		this.ciudadanoService.Buscar(3);// se busca por pk
		// imprimimos el ciudadano y el empleado(se modifico el toString)
		System.out.println(ciudadano1);
		System.out.println(empleado1);
		// 3.Actualizamos un empleado y un ciudadano
		empleado1.setCargo("Estudiante");
		ciudadano1.setNombre("Jean Carl");
		this.empleadoService.actualizar(empleado1);
		// 4.Eliminar ciudadano
		this.empleadoService.borrar(5);// se elimina por pk

	}

}
