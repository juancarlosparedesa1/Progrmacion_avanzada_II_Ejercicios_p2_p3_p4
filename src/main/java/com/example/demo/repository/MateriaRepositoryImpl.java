package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.Modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public Materia buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	public void acualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(materia);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Materia mat = this.buscar(id);
		this.entityManager.remove(mat);
	}
}