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
		// 1.Insertar Ciudadano y empleado
		System.out.println("ingresando datos.....");
//		this.empleadoService.agregar(empleado1);
		System.out.println("datos ingresados correctamente!!");
//		this.ciudadanoService.agregar(ciudadano1);
		// 2.buscamos un ciudadano y un empleado
		System.out.println("buscando datos....");
		// this.ciudadanoService.Buscar(3);// se busca por pk
		System.out.println("datos encontrados exitosamente!!");
		// imprimimos el ciudadano y el empleado(se modifico el toString)
//		System.out.println(ciudadano1);
//		System.out.println(empleado1);
		// 3.Actualizamos un empleado y un ciudadano
		System.out.println("Actualizando datos....");
//		Ciudadano a = this.ciudadanoService.Buscar(1);
//		a.setNombre("Andres");
//		Empleado b = this.empleadoService.buscar(1);
//		b.setCargo("Analista");
//		this.empleadoService.buscar(1);
//		this.ciudadanoService.actualizar(a);
//		this.empleadoService.actualizar(b);
		System.out.println("Datos actualizados correctamente!!");
		// 4.Eliminar ciudadano y empleado
		System.out.println("Eliminando datos...");
		this.ciudadanoService.borrar(1);// se elimina por pk
//		this.empleadoService.borrar(2);
		System.out.println("Datos eliminados correctamente!!");

	}

}
