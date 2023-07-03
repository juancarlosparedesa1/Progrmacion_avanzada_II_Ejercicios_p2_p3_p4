package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public Paciente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Paciente paci = this.buscar(id);
		this.entityManager.remove(paci);
	}

	@Override
	public Paciente buscarPorCedulaPaciente(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cedula=:datoCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Paciente) myQuery.getSingleResult();
	}

}
