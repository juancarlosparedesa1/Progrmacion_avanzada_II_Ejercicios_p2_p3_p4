package com.example.demo.service;

import com.example.demo.repository.Modelo.Alumno;

public interface IAlumnoService {
	public void ingresar(Alumno alumno);

	public Alumno buscar(Integer id);

	public void acualizar(Alumno alumno);

	public void borrar(Integer id);
}
