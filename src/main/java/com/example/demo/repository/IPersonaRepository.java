package com.example.demo.repository;

import com.example.demo.repository.modelo.Persona;

public interface IPersonaRepository {
	public void insertar(Persona persona);

	public Persona Seleccionar(Integer id);

	public void actualizar(Persona persona);

	public void eliminar(Integer id);

}
