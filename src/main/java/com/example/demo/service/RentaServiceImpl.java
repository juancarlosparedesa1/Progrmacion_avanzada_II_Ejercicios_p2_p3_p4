package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IAutomovilRepository;
import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.IPagoRepository;
import com.example.demo.repository.IRentaRepository;
import com.example.demo.repository.modelo.Automovil;
import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Pago;
import com.example.demo.repository.modelo.Renta;

@Service
public class RentaServiceImpl implements IRentaService {

	@Autowired
	private IRentaRepository rentaRepository;
	@Autowired
	private IAutomovilRepository automovilRepository;
	@Autowired
	private IClienteRepository clienteRepository;
	@Autowired
	private IPagoRepository pagoRepository;

	@Override
	public void ingresar(Renta renta) {
		// TODO Auto-generated method stub
		this.rentaRepository.insertar(renta);
	}

	@Override
	public Renta buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.rentaRepository.buscar(id);
	}

	@Override
	public void actualizar(Renta renta) {
		// TODO Auto-generated method stub
		this.rentaRepository.actualizar(renta);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.rentaRepository.buscar(id);
	}

	@Override
	public void realizar(Integer id_auto, Integer id_cliente, Integer numeroDias, String numeroTarjeta) {
		// TODO Auto-generated method stub

		// buscamos automovil y cliente
		Automovil auto = this.automovilRepository.buscar(id_auto);
		Cliente cli = this.clienteRepository.buscar(id_cliente);

		// validamos que exista el automomovil y el el cliente
		if (auto != null && cli != null) {
			// Creamos la renta
			Renta renta = new Renta();
			renta.setValor(new BigDecimal(50));
			renta.setFecha(LocalDateTime.now());
			renta.setNumeroDias(numeroDias);

			// transformo el numero dias a bigdecimal para operar
			BigDecimal numeroDiasBigDecimal = BigDecimal.valueOf(numeroDias);

			// calculo el valor de la renta
			BigDecimal valorRenta = numeroDiasBigDecimal.multiply(renta.getValor());

			// actualizo valor de la renta
			renta.setValor(valorRenta);
			this.rentaRepository.actualizar(renta);
			// Creamos el pago
			Pago pag = new Pago();
			pag.setNumeroTarjeta(numeroTarjeta);
			// calculamos el valor del pago
			BigDecimal valorPago = renta.getValor().add(renta.getValor().multiply(new BigDecimal(0.05)));
			pag.setValor(valorPago);
			pag.setRenta(renta);
			// 
			renta.setAutomovil(auto);
			renta.setCliente(cli);
			renta.setPago(pag);
			this.rentaRepository.insertar(renta);

//			this.pagoRepository.insertar(pag);

		} else {
			System.out.println("cliente o automovil no encontrado");
		}

	}

}
