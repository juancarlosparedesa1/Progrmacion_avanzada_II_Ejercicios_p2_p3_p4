package com.example.demo.service;

import com.example.demo.repository.modelo.Doctor;

public interface IDoctorService {

	public void ingresar(Doctor doctor);

	public Doctor buscar(Integer id);

	public void actualizar(Doctor doctor);

	public void eliminar(Integer id);

	public Doctor buscarPorCedulaDoctor(String cedula);
}
