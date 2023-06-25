package com.example.demo.repository;

import com.example.demo.repository.modelo.Automovil;

public interface IAutomovilRepository {
	public void insertar(Automovil automovil);

	public Automovil buscar(Integer id);

	public void actualizar(Automovil automovil);

	public void eliminar(Integer id);
}
