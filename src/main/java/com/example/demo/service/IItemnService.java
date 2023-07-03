package com.example.demo.service;

import com.example.demo.repository.modelo.Item;

public interface IItemnService {

	public void agregar(Item item);

	public Item buscar(Integer id);

	public void actualizar(Item item);

	public void eliminar(Integer id);
}
