package com.example.demo.service;

import com.example.demo.repository.Modelo.Materia;

public interface IMateriaService {
	public void ingresar(Materia materia);

	public Materia buscar(Integer id);

	public void acualizar(Materia materia);

	public void borrar(Integer id);
}
