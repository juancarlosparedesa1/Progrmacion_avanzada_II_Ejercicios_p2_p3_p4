package com.example.demo.service;

import com.example.demo.repository.modelo.Automovil;

public interface IAutomovilService {
	public void ingresar(Automovil automovil);

	public Automovil buscar(Integer id);

	public void actualizar(Automovil automovil);

	public void borrar(Integer id);
}
