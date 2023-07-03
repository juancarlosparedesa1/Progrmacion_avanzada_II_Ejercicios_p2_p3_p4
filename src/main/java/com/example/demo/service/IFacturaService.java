package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Item;

public interface IFacturaService {
	public void agregar(Factura factura);

	public Factura buscar(Integer id);

	public void actualizar(Factura factura);

	public void eliminar(Integer id);

	public void realizarVenta(List<Item> listaProductos, String cedulaCliente, String numeroVenta);
}
