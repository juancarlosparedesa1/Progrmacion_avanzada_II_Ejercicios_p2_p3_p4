package com.example.demo.repository;

import com.example.demo.repository.Modelo.Alumno;

public interface IAlumnoRepository {

	public void insertar(Alumno alumno);
	public Alumno  buscar(Integer id);
	public void acualizar(Alumno alumno);
	public void eliminar(Integer id);
}
