package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CitaMedica;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);
	}

	@Override
	public CitaMedica buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		CitaMedica cime = this.buscar(id);
		this.entityManager.remove(cime);
	}

	@Override
	public CitaMedica buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createQuery("SELECT cm FROM CitaMedica cm WHERE cm.numeroTurno=:datoNumeroTurno");
		myQuery.setParameter("datoNumeroTurno", numero);
		return (CitaMedica) myQuery.getSingleResult();
	}

	@Override
	public List<CitaMedica> reporte(LocalDateTime fechaCita, BigDecimal costoCita) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery(
				"SELECT cm FROM CitaMedica cm WHERE cm.fechaCita>:datoFechaCita AND cm.costoCita>:datoCostoCita");
		myQuery.setParameter("datoFechaCita", fechaCita);
		myQuery.setParameter("datoCostoCita", costoCita);
		return myQuery.getResultList();
	}

}
