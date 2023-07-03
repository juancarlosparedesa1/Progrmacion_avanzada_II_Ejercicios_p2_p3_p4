package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.DetalleFactura;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DetalleFacturaReposittoryImpl implements IDetalleFacturaRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalleFactura);
	}

	@Override
	public DetalleFactura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(DetalleFactura.class, id);
	}

	@Override
	public void actualizar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(detalleFactura);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		DetalleFactura detfact = this.buscar(id);
		this.entityManager.remove(detfact);

	}

}
