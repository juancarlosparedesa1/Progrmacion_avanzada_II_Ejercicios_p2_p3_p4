package com.example.demo.repository;

import com.example.demo.repository.modelo.DetalleFactura;

public interface IDetalleFacturaRepository {
	public void insertar(DetalleFactura detalleFactura);

	public DetalleFactura buscar(Integer id);

	public void actualizar(DetalleFactura detalleFactura);

	public void eliminar(Integer id);
}
