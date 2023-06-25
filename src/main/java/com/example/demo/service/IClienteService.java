package com.example.demo.service;

import com.example.demo.repository.modelo.Cliente;

public interface IClienteService {

	public void ingresar(Cliente cliente);

	public Cliente buscar(Integer id);

	public void actualizar(Cliente cliente);

	public void borrar(Integer id);
}
