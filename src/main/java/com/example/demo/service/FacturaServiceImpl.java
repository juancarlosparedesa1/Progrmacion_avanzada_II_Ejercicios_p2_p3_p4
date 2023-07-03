package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IDetalleFacturaRepository;
import com.example.demo.repository.IFacturaRepository;
import com.example.demo.repository.IItemnRepository;
import com.example.demo.repository.modelo.DetalleFactura;
import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Item;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

	@Autowired
	private IItemnRepository itemnRepository;

	@Autowired
	private IDetalleFacturaRepository detalleFacturaRepository;

	@Override
	public void agregar(Factura factura) {
		// TODO Auto-generated method stub

	}

	@Override
	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void realizarVenta(List<Item> listaProductos, String cedulaCliente, String numeroVenta) {
		// TODO Auto-generated method stub

		// Creo una lista de detalles de enta

		List<DetalleFactura> detallesFactura = new ArrayList<>();
		// seteo la factura

		Factura factura = new Factura();
		factura.setCedulaCliente(cedulaCliente);
		factura.setFecha(LocalDateTime.now());
		factura.setNumero(numeroVenta);

		BigDecimal totalFacturaVenta = new BigDecimal(0);

		for (Item item : listaProductos) {
			DetalleFactura detallefactura = new DetalleFactura();
			Item itembd = this.itemnRepository.buscarPorCodigoBarras(item.getCodigoBarras());

			// valido
			if (itembd.getStock() >= item.getStock()) {
				itembd.setStock(itembd.getStock() - item.getStock());
				this.itemnRepository.actualizar(itembd);

				detallefactura.setCantidad(item.getStock());
				detallefactura.setPrecioUnitario(itembd.getPrecio());
				detallefactura.setSubtotal(itembd.getPrecio().multiply(new BigDecimal(item.getStock())));
				factura.setTotalVenta(detallefactura.getSubtotal());
				detallefactura.setItem(itembd);
				detallefactura.setFactura(factura);
				detallesFactura.add(detallefactura);
				factura.setDetallesFactura(detallesFactura);
//				this.detalleFacturaRepository.insertar(detallefactura);
				this.facturaRepository.insertar(factura);

			} else {
				System.out.println("No se puede realizar la venta");
			}

		}

	}

}
