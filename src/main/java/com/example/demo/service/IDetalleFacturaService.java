package com.example.demo.service;

import com.example.demo.repository.modelo.DetalleFactura;

public interface IDetalleFacturaService {
	public void agregar(DetalleFactura detalleFactura);

	public DetalleFactura buscar(Integer id);

	public void actualizar(DetalleFactura detalleFactura);

	public void eliminar(Integer id);
}
