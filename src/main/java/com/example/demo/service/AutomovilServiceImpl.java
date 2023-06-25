package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IAutomovilRepository;
import com.example.demo.repository.modelo.Automovil;

@Service
public class AutomovilServiceImpl implements IAutomovilService {

	@Autowired
	private IAutomovilRepository automovilRepository;

	@Override
	public void ingresar(Automovil automovil) {
		// TODO Auto-generated method stub
		this.automovilRepository.insertar(automovil);
	}

	@Override
	public Automovil buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.automovilRepository.buscar(id);
	}

	@Override
	public void actualizar(Automovil automovil) {
		// TODO Auto-generated method stub
		this.automovilRepository.actualizar(automovil);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.automovilRepository.eliminar(id);
	}

}
