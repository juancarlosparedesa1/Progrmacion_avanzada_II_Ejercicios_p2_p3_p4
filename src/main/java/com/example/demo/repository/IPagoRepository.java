package com.example.demo.repository;

import com.example.demo.repository.modelo.Pago;

public interface IPagoRepository {

	public void insertar(Pago pago);

	public Pago buscar(Integer id);

	public void actualizar(Pago pago);

	public void eliminar(Integer id);
}
