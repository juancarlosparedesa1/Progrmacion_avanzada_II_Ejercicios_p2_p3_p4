package com.example.demo.repository;

import com.example.demo.repository.modelo.Renta;

public interface IRentaRepository {
	public void insertar(Renta renta);

	public Renta buscar(Integer id);

	public void actualizar(Renta renta);

	public void eliminar(Integer id);
}
