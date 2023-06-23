package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.IAlumnoService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.IMatriculaService;

@SpringBootApplication
public class Ejercicio17MapeoManyToManyConOneToManyManyToOneAlumnoMateriaMatriculaApplication
		implements CommandLineRunner {

	@Autowired
	private IMatriculaService matriculaService;
	@Autowired
	private IAlumnoService alumnoService;
	@Autowired
	private IMateriaService materiaService;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio17MapeoManyToManyConOneToManyManyToOneAlumnoMateriaMatriculaApplication.class,
				args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		1.inserta alumno materia matricula

//		creo una lista de matriculas
//		List<Matricula> listaMatriculas = new ArrayList<>();

//		creo un alumno
		Alumno alumno1 = new Alumno();
		alumno1.setNombre("Juan Carlos Paredes");
//		alumno1.setMatriculas(listaMatriculas);

//		creo una materia
		Materia materia1 = new Materia();
		materia1.setCreditos("10");
		materia1.setNombre("Programacion Avanzada II");
//		materia1.setMatriculas(listaMatriculas);

//		creo una matricula (matriculo al alumno)
		Matricula matricula1 = new Matricula();
		matricula1.setFecha(LocalDateTime.now());
		matricula1.setNumero("0001");
		matricula1.setMateria(materia1);
		matricula1.setAlumno(alumno1);
//		listaMatriculas.add(matricula1);

//		this.matriculaService.agregar(matricula1);
//		2.buscar materia y alumno
		this.alumnoService.buscar(1);
		this.materiaService.buscar(1);

//		3.actualizar alumno y materia
		Alumno alum = this.alumnoService.buscar(1);
		alum.setNombre("jean Carl");
		this.alumnoService.actualizar(alum);

		Materia mat = this.materiaService.buscar(1);
		mat.setNombre("Analisis III");
		this.materiaService.actualizar(mat);

//		4.eliminar alumno y materia
//		para esto debo eliminar matricula
//		si elimino la matricula se borran el alumno y la materia?
//		SI, PARA ELIMINAR ALUMNO O MATERIA TENGO QUE ELIMINAR MATRICULA
//		YA QUE SI INTENTO ELIMINAR UN ALUMNO  O UNA MATERIA ME DARA EL 
//		ERROR DE QUE ESE ALUMNO O ESA MATERIA ESTA REFERENCIADA EN LA
//		TALBLA MATRICULA
		this.matriculaService.borrar(1);

	}

}
