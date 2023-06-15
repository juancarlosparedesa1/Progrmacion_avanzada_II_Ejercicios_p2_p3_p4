package com.example.demo.service;

import com.example.demo.repository.modelo.Persona;

public interface IPersonaService {
	public void guarda(Persona persona);

	public Persona seleccionar(Integer id);

	public void actualizar(Persona persona);

	public void borrar(Integer id);

}
