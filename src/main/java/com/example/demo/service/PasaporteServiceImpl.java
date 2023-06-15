package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPasaporteRepository;
import com.example.demo.repository.modelo.Pasaporte;

@Service
public class PasaporteServiceImpl implements IPasaporteService {

	@Autowired
	private IPasaporteRepository pasaporteRepository;

	@Override
	public void agregar(Pasaporte pasaporte) {
		// TODO Auto-generated method stub
		this.pasaporteRepository.insertar(pasaporte);
	}

	@Override
	public Pasaporte seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.pasaporteRepository.Seleccionar(id);
	}

	@Override
	public void actualizar(Pasaporte pasaporte) {
		// TODO Auto-generated method stub
		this.pasaporteRepository.actualizar(pasaporte);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.pasaporteRepository.eliminar(id);
	}

}
