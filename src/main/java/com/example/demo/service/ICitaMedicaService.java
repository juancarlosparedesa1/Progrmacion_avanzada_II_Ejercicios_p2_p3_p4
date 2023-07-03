package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.CitaMedica;

public interface ICitaMedicaService {

	public void ingresar(CitaMedica citaMedica);

	public CitaMedica buscar(Integer id);

	public void actualizar(CitaMedica citaMedica);

	public void eliminar(Integer id);

	public CitaMedica buscarPorNumero(String numero);

	public List<CitaMedica> reporte(LocalDateTime fechaCita, BigDecimal costoCita);

}
