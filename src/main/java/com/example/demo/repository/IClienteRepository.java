package com.example.demo.repository;

import com.example.demo.repository.modelo.Cliente;

public interface IClienteRepository {

	public void insertar(Cliente cliente);

	public Cliente buscar(Integer id);

	public void actualizar(Cliente cliente);

	public void eliminar(Integer id);
}
