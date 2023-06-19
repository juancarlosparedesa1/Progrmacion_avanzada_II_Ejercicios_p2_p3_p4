package com.example.demo.hotel.service;

import com.example.demo.hotel.repository.modelo.Hotel;

public interface IHotelService {
	public void ingresar(Hotel hotel);

	public Hotel buscar(Integer id);

	public void actualizar(Hotel hotel);

	public void borrar(Integer id);
}
