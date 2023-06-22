package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IAlumnoRepository;
import com.example.demo.repository.Modelo.Alumno;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

	@Autowired
	private IAlumnoRepository alumnoRepository;
	@Override
	public void ingresar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.alumnoRepository.insertar(alumno);
	}

	@Override
	public Alumno buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.alumnoRepository.buscar(id);
	}

	@Override
	public void acualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.alumnoRepository.acualizar(alumno);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.alumnoRepository.eliminar(id);
	}

}
