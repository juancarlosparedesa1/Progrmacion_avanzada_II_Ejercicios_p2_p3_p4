package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IDetalleFacturaRepository;
import com.example.demo.repository.modelo.DetalleFactura;

import jakarta.persistence.EntityManager;

@Service
public class DetalleFacturaServiceImpl implements IDetalleFacturaService {

	@Autowired
	private IDetalleFacturaRepository detalleFacturaRepository;

	@Override
	public void agregar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		this.detalleFacturaRepository.insertar(detalleFactura);
	}

	@Override
	public DetalleFactura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.detalleFacturaRepository.buscar(id);
	}

	@Override
	public void actualizar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		this.detalleFacturaRepository.actualizar(detalleFactura);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.detalleFacturaRepository.eliminar(id);
	}

}
