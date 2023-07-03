package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ItemReposittoryImpl implements IItemnRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Item item) {
		// TODO Auto-generated method stub
		this.entityManager.persist(item);
	}

	@Override
	public Item buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Item.class, id);
	}

	@Override
	public void actualizar(Item item) {
		// TODO Auto-generated method stub
		this.entityManager.merge(item);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Item item = this.buscar(id);
		this.entityManager.remove(item);

	}

	// namedNativeQuery
	@Override
	public Item buscarPorCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<Item> myQuery = this.entityManager.createNamedQuery("Item.buscarItemCodigoBarrasNative", Item.class);
		myQuery.setParameter("datoCodigoBarras", codigoBarras);
		try {
			return myQuery.getSingleResult();		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Producto no encontrado, ingresando producto....");
			return null;
		}
		
		
		
	}

}
