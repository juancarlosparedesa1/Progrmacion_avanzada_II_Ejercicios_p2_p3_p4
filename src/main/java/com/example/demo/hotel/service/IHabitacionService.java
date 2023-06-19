package com.example.demo.hotel.service;

import com.example.demo.hotel.repository.modelo.Habitacion;

public interface IHabitacionService {
	public void ingresar(Habitacion habitacion);

	public Habitacion buscar(Integer id);

	public void actualizar(Habitacion habitacion);

	public void borrar(Integer id);
}
