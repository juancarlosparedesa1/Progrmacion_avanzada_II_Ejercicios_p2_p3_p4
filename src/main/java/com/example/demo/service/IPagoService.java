package com.example.demo.service;

import com.example.demo.repository.modelo.Pago;

public interface IPagoService {

	public void ingresar(Pago pago);

	public Pago buscar(Integer id);

	public void actualizar(Pago pago);

	public void borrar(Integer id);
}
