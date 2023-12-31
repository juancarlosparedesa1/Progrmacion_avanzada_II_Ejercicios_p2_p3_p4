package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.service.ICuentaService;

@SpringBootApplication
public class Ejercicio8CuentaBancariaApplication implements CommandLineRunner {
	@Autowired
	private ICuentaService cuentaService;
	public static void main(String[] args) {
		SpringApplication.run(Ejercicio8CuentaBancariaApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// 1aperturar
			Cuenta cuenta1 = new Cuenta();
			cuenta1.setCedulaPropietario("12423423");
			cuenta1.setFechaApertura(LocalDateTime.now());
			cuenta1.setNumero("0001");
			cuenta1.setSaldo(new BigDecimal(100));
			cuenta1.setTipo("A");
			this.cuentaService.aperturar(cuenta1);

			// 2.Actualizar
			cuenta1.setTipo("C");
			this.cuentaService.actualizar(cuenta1);
			// 3.consultar saldo
			System.out.println("El saldo de la cuenta es:" + cuenta1.getSaldo());
		
	}

}
