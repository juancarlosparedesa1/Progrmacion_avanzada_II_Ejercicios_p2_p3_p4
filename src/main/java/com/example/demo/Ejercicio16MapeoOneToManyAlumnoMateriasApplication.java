package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.Modelo.Alumno;
import com.example.demo.repository.Modelo.Materia;
import com.example.demo.service.IAlumnoService;
import com.example.demo.service.IMateriaService;

@SpringBootApplication
public class Ejercicio16MapeoOneToManyAlumnoMateriasApplication implements CommandLineRunner {

	@Autowired
	private IAlumnoService alumnoService;
	@Autowired
	private IMateriaService materiaService;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio16MapeoOneToManyAlumnoMateriasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// 1.insertar un alumno y una Materia
		Set<Alumno> ConjuntoAlumnos = new HashSet<>();
		Set<Materia> ConjuntoMaterias = new HashSet<>();

		Alumno alumno1 = new Alumno();
		alumno1.setNombre("Juan Carlos Paredes Angulo");
		ConjuntoAlumnos.add(alumno1);

		Materia materia1 = new Materia();
		materia1.setNombre("Programacion Avanzada I");
		materia1.setCreditos("6");
		materia1.setAlumnos(ConjuntoAlumnos);
		ConjuntoMaterias.add(materia1);

		Materia materia2 = new Materia();
		materia2.setNombre("Programacion Avanzada II");
		materia2.setCreditos("8");
		materia2.setAlumnos(ConjuntoAlumnos);
		ConjuntoMaterias.add(materia2);

		Materia materia3 = new Materia();
		materia3.setNombre("Programacion Avanzada");
		materia3.setCreditos("10");
		materia3.setAlumnos(ConjuntoAlumnos);
		ConjuntoMaterias.add(materia3);

		alumno1.setMaterias(ConjuntoMaterias);

//		this.alumnoService.ingresar(alumno1);

//		2.Buscar alumno y materia Select
		System.out.println("Buscando....");
		this.alumnoService.buscar(1);
		this.materiaService.buscar(4);

////		3.Actualizar Alumno y materia
		Alumno alum = this.alumnoService.buscar(2);
		alum.setNombre("Jean Carl");
		Materia mat = this.materiaService.buscar(5);
		mat.setCreditos("20");
		this.alumnoService.acualizar(alum);
		this.materiaService.acualizar(mat);

//		4.elimnar alumno 
//		Se eliminan todas las materias si elimino el alumno?
//		this.alumnoService.borrar(1);// si, con esta linea si elimino el alumno se eliminan las materias y las
		// matriculas
//		4.1 eliminar materia
		this.materiaService.borrar(4);

	}

}
