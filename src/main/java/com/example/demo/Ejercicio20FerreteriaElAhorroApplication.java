package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Item;
import com.example.demo.service.IFacturaService;
import com.example.demo.service.IItemnService;

@SpringBootApplication
public class Ejercicio20FerreteriaElAhorroApplication implements CommandLineRunner {

	@Autowired
	private IItemnService itemnService;

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio20FerreteriaElAhorroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		1.insertar Items
		Item item1 = new Item();
		item1.setCodigoBarras("001");
		item1.setNombre("Coca cola");
		item1.setPrecio(new BigDecimal(100));
		item1.setStock(200);
		item1.setTipo("bebidas");
//		this.itemnService.agregar(item1);
//		this.itemnService.agregar(item1);
//		this.itemnService.agregar(item1);
//		2.Realizar Venta
		List<Item> listaProductos = new ArrayList<>();
		listaProductos.add(item1);

		this.facturaService.realizarVenta(listaProductos, "1726890000", "00001");
//
	}

}
