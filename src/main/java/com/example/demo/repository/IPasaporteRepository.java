package com.example.demo.repository;

import com.example.demo.repository.modelo.Pasaporte;

public interface IPasaporteRepository {
	public void insertar(Pasaporte pasaporte);

	public Pasaporte Seleccionar(Integer id);

	public void actualizar(Pasaporte pasaporte);

	public void eliminar(Integer id);
}
