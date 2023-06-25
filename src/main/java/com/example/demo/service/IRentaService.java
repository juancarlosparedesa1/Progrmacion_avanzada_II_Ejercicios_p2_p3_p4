package com.example.demo.service;

import com.example.demo.repository.modelo.Renta;

public interface IRentaService {
	public void ingresar(Renta renta);

	public Renta buscar(Integer id);

	public void actualizar(Renta renta);

	public void borrar(Integer id);

//	public void realizar(String placa, String cedula, Integer numeroDias, String numeroTarjeta);
	public void realizar(Integer id_auto, Integer id_cliente, Integer numeroDias, String numeroTarjeta);
}
