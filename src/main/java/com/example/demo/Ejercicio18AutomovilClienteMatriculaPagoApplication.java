package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Automovil;
import com.example.demo.repository.modelo.Cliente;
import com.example.demo.service.IAutomovilService;
import com.example.demo.service.IClienteService;
import com.example.demo.service.IRentaService;

@SpringBootApplication
public class Ejercicio18AutomovilClienteMatriculaPagoApplication implements CommandLineRunner {

	@Autowired
	private IAutomovilService automovilService;
	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IRentaService rentaService;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio18AutomovilClienteMatriculaPagoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		1.Insertar automovil y cliente

		Automovil automovil1 = new Automovil();
		automovil1.setPlaca("abc-123");
		this.automovilService.ingresar(automovil1);

		Cliente cliente1 = new Cliente();
		cliente1.setCedula("1726890000");
		cliente1.setNombre("Juan Carlos");
		this.clienteService.ingresar(cliente1);

//		2.realizar una renta
		this.rentaService.realizar(automovil1.getId(), cliente1.getId(), 10, "0001");

	}

}
