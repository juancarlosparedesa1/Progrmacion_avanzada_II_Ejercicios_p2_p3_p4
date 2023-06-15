package com.example.demo.service;

import com.example.demo.repository.modelo.Ciudadano;

public interface ICiudadanoService {
	public void agregar(Ciudadano ciudadano);

	public Ciudadano Buscar(Integer id);

	public void actualizar(Ciudadano ciudadano);

	public void borrar(Integer id);

}
