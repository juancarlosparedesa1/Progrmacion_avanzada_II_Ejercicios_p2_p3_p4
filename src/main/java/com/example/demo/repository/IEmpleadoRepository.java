package com.example.demo.repository;

import com.example.demo.repository.modelo.Empleado;

public interface IEmpleadoRepository {

	public void insertar(Empleado empleado);

	public Empleado Buscar(Integer id);

	public void actualizar(Empleado empleado);

	public void eliminar(Integer id);
}
