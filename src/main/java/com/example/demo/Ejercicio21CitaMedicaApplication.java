package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;
import com.example.demo.service.IDoctorService;
import com.example.demo.service.IGestorCitaMedica;
import com.example.demo.service.IPacienteService;

@SpringBootApplication
public class Ejercicio21CitaMedicaApplication implements CommandLineRunner {

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private IGestorCitaMedica gestorCitaMedica;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio21CitaMedicaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		1.Ingreso de 2 doctores

		Doctor doctor1 = new Doctor();
		doctor1.setCedula("1726890000");
		doctor1.setFechaNacimiento(LocalDateTime.of(1999, 05, 05, 11, 11));
		doctor1.setNombre("Juan Carlos");
		doctor1.setNumeroConsultorio("0001");
		doctor1.setSalario(new BigDecimal(1000));
		doctor1.setTitulo("Medico General");

		Doctor doctor2 = new Doctor();
		doctor2.setCedula("1726897200");
		doctor2.setFechaNacimiento(LocalDateTime.of(2000, 06, 06, 23, 11));
		doctor2.setNombre("Jose David");
		doctor2.setNumeroConsultorio("0002");
		doctor2.setSalario(new BigDecimal(1000));
		doctor2.setTitulo("Medico General");

//		2.Ingreso de 2 pacientes

		Paciente paciente1 = new Paciente();
		paciente1.setApellido("Angulo");
		paciente1.setCedula("1722000000");
		paciente1.setCodigoIess("1000");
		paciente1.setEstatura(1.77f);
		paciente1.setFechaNacimiento(LocalDateTime.of(2005, 07, 05, 10, 10));
		paciente1.setGenero("M");
		paciente1.setNombre("Luis");
		paciente1.setPeso(60f);

		Paciente paciente2 = new Paciente();
		paciente2.setApellido("Benitez");
		paciente2.setCedula("0400725000");
		paciente2.setCodigoIess("1001");
		paciente2.setEstatura(1.65f);
		paciente2.setFechaNacimiento(LocalDateTime.of(1963, 05, 01, 05, 12));
		paciente2.setGenero("M");
		paciente2.setNombre("Luis");
		paciente2.setPeso(60f);

		this.doctorService.ingresar(doctor1);
		this.doctorService.ingresar(doctor2);

		this.pacienteService.ingresar(paciente1);
		this.pacienteService.ingresar(paciente2);

//		3.agendamiento de cita medica
		this.gestorCitaMedica.agendarCita("00001", LocalDateTime.of(2023, 7, 10, 10, 00), new BigDecimal(20),
				"villa Flora", doctor1.getCedula(), paciente1.getCedula());

		this.gestorCitaMedica.agendarCita("00002", LocalDateTime.of(2023, 8, 11, 10, 00), new BigDecimal(10),
				"Centro historico", doctor1.getCedula(), paciente1.getCedula());

		this.gestorCitaMedica.agendarCita("00003", LocalDateTime.of(2020, 9, 12, 10, 00), new BigDecimal(20),
				"Quito Norte", doctor2.getCedula(), paciente2.getCedula());
//		4.actualizacion citaMedica

		this.gestorCitaMedica.actualizarCitaMedica("00001", "Constusion", "Paracetamol 1000 mg",
				LocalDateTime.of(2023, 8, 15, 11, 00));

//		5.reporte citas medicas
		this.gestorCitaMedica.reporte(LocalDateTime.of(2022, 1, 1, 1, 0, 0), new BigDecimal(15));
	}

}
