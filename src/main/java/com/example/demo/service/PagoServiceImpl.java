package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPagoRepository;
import com.example.demo.repository.modelo.Pago;

@Service
public class PagoServiceImpl implements IPagoService {
	@Autowired
	private IPagoRepository pagoRepository;

	@Override
	public void ingresar(Pago pago) {
		// TODO Auto-generated method stub
		this.pagoRepository.insertar(pago);
	}

	@Override
	public Pago buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.pagoRepository.buscar(id);
	}

	@Override
	public void actualizar(Pago pago) {
		// TODO Auto-generated method stub
		this.pagoRepository.actualizar(pago);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.pagoRepository.eliminar(id);
	}

}
