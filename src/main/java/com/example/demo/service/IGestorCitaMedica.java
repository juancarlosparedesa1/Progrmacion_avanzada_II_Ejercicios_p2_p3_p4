package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface IGestorCitaMedica {

	public void agendarCita(String numeroTurno, LocalDateTime fechaCita, BigDecimal costoCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente);

	public void actualizarCitaMedica(String numero, String diagnostico, String receta, LocalDateTime fechaControl);

	public void reporte(LocalDateTime fechaCita, BigDecimal costoCita);
}
