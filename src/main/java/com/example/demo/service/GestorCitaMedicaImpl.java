package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;

@Service
public class GestorCitaMedicaImpl implements IGestorCitaMedica {

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private ICitaMedicaService citaMedicaService;

	@Override
	public void agendarCita(String numeroTurno, LocalDateTime fechaCita, BigDecimal costoCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub

		// buscamos el doctor y el paciente por cedula
		Paciente pacientebd = this.pacienteService.buscarPorCedulaPaciente(cedulaPaciente);
		Doctor doctorbd = this.doctorService.buscarPorCedulaDoctor(cedulaDoctor);

		CitaMedica citaMedica = new CitaMedica();
		citaMedica.setCostoCita(new BigDecimal(20));
		citaMedica.setDiagnostico("fractura");
		citaMedica.setFechaCita(fechaCita);
		citaMedica.setFechaControl(LocalDateTime.of(2023, 8, 01, 2, 30));
		citaMedica.setLugarCita(lugarCita);
		citaMedica.setNumeroTurno(numeroTurno);
		citaMedica.setReceta("Paracetamol 600mg");
		citaMedica.setDoctor(doctorbd);
		citaMedica.setPaciente(pacientebd);

		this.citaMedicaService.ingresar(citaMedica);

	}

	@Override
	public void actualizarCitaMedica(String numero, String diagnostico, String receta, LocalDateTime fechaControl) {
		// TODO Auto-generated method stub
		CitaMedica citabd = this.citaMedicaService.buscarPorNumero(numero);

		citabd.setDiagnostico(diagnostico);
		this.citaMedicaService.actualizar(citabd);

		citabd.setReceta(receta);
		this.citaMedicaService.actualizar(citabd);

		citabd.setFechaControl(fechaControl);
		this.citaMedicaService.actualizar(citabd);
	}

	@Override
	public void reporte(LocalDateTime fechaCita, BigDecimal costoCita) {
		// TODO Auto-generated method stub
		List<CitaMedica> citaMedicabd = this.citaMedicaService.reporte(fechaCita, costoCita);

		for (CitaMedica citaMedicaList : citaMedicabd) {
			System.out.println("***************Reporte************");
			System.out.println("Numero: " + citaMedicaList.getNumeroTurno());
			System.out.println("Fecha cita: " + citaMedicaList.getFechaCita());
			System.out.println("Costo cita: " + citaMedicaList.getCostoCita());
			System.out.println("Fecha Control:" + citaMedicaList.getFechaControl());
		}
	}

}
