package com.example.demo.service;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaService {

	public void agregar(Matricula matricula);

	public Matricula buscar(Integer id);

	public void actualizar(Matricula matricula);

	public void borrar(Integer id);
}
