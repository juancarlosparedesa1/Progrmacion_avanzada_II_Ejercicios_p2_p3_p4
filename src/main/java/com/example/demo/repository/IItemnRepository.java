package com.example.demo.repository;

import com.example.demo.repository.modelo.Item;

public interface IItemnRepository {

	public void insertar(Item item);

	public Item buscar(Integer id);

	public void actualizar(Item item);

	public void eliminar(Integer id);

	public Item buscarPorCodigoBarras(String codigoBarras);
}
