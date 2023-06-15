package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Pasaporte;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PasaporteRepositoryImpl implements IPasaporteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Pasaporte pasaporte) {
		// TODO Auto-generated method stub
		this.entityManager.persist(pasaporte);

	}

	@Override
	public Pasaporte Seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Pasaporte.class, id);
	}

	@Override
	public void actualizar(Pasaporte pasaporte) {
		// TODO Auto-generated method stub
		this.entityManager.merge(pasaporte);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Pasaporte pasap = this.Seleccionar(id);
		this.entityManager.remove(pasap);

	}

}
