package com.example.demo.service;

import com.example.demo.repository.modelo.Paciente;

public interface IPacienteService {
	public void ingresar(Paciente paciente);

	public Paciente buscar(Integer id);

	public void actualizar(Paciente paciente);

	public void eliminar(Integer id);

	public Paciente buscarPorCedulaPaciente(String cedula);
}
