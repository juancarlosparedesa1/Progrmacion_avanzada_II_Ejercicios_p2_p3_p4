package com.example.demo.service;

import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.modelo.Empleado;

public interface IEmpleadoService {
	public void agregar(Empleado empleado);

	public Empleado buscar(Integer id);

	public void actualizar(Empleado empleado);

	public void borrar(Integer id);
}
