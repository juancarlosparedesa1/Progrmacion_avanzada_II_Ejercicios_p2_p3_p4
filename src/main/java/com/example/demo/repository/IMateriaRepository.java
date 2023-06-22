package com.example.demo.repository;

import com.example.demo.repository.Modelo.Materia;

public interface IMateriaRepository {
	public void insertar(Materia materia);
	public Materia  buscar(Integer id);
	public void acualizar(Materia materia);
	public void eliminar(Integer id);
}
