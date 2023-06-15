package com.example.demo.service;

import com.example.demo.repository.modelo.Pasaporte;

public interface IPasaporteService {
	public void agregar(Pasaporte pasaporte);

	public Pasaporte seleccionar(Integer id);

	public void actualizar(Pasaporte pasaporte);

	public void borrar(Integer id);
}
