package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.Modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public void ingresar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.insertar(materia);
	}

	@Override
	public Materia buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.materiaRepository.buscar(id);
	}

	@Override
	public void acualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.acualizar(materia);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.materiaRepository.eliminar(id);
	}

}
