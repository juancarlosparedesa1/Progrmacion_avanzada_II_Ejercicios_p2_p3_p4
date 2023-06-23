package com.example.demo.service;

import com.example.demo.repository.modelo.Alumno;

public interface IAlumnoService {
	public void agregar(Alumno alumno);

	public Alumno buscar(Integer id);

	public void actualizar(Alumno alumno);

	public void borrar(Integer id);
}
