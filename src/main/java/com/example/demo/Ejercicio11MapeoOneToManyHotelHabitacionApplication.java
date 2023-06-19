package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.hotel.repository.modelo.Habitacion;
import com.example.demo.hotel.repository.modelo.Hotel;
import com.example.demo.hotel.service.IHabitacionService;
import com.example.demo.hotel.service.IHotelService;

@SpringBootApplication
public class Ejercicio11MapeoOneToManyHotelHabitacionApplication implements CommandLineRunner {

	@Autowired
	private IHabitacionService habitacionService;
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio11MapeoOneToManyHotelHabitacionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// 1.insertamos 2 hoteles y 3 habitaciones

//		Creamos los hoteles
		Hotel hotel1 = new Hotel();
		hotel1.setDireccion("direccion1");
		hotel1.setNombre("hotel ABC");

		Hotel hotel2 = new Hotel();
		hotel2.setDireccion("direccion2");
		hotel2.setNombre("hotel XYZ");

//		Creamos las habitaciones

//		Creo una lista de habitaciones para irlas añadiendo
		List<Habitacion> listaHabitaciones1 = new ArrayList<>();
		List<Habitacion> listaHabitaciones2 = new ArrayList<>();

		Habitacion habitacion1 = new Habitacion();
		habitacion1.setNumero("0001");
		habitacion1.setValor(new BigDecimal(100));
		habitacion1.setHotel(hotel1);
		listaHabitaciones1.add(habitacion1);

		Habitacion habitacion2 = new Habitacion();
		habitacion2.setNumero("0002");
		habitacion2.setHotel(hotel2);
		habitacion2.setValor(new BigDecimal(200));
		listaHabitaciones2.add(habitacion2);

		Habitacion habitacion3 = new Habitacion();
		habitacion3.setNumero("0003");
		habitacion3.setHotel(hotel1);
		habitacion3.setValor(new BigDecimal(300));
		listaHabitaciones1.add(habitacion3);

		hotel1.setHabitaciones(listaHabitaciones1);
		hotel2.setHabitaciones(listaHabitaciones2);

//		Ingresamos los hoteles a la bd
//		Guardar hotel y habitacion
		this.hotelService.ingresar(hotel1);
		this.hotelService.ingresar(hotel2);

	}

}
