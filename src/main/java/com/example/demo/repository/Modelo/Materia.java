package com.example.demo.repository.Modelo;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_materia")
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	private Integer id;
	private String nombre;
	private String Creditos;

	@ManyToMany
	@JoinTable(name="Matricula",//creamos tabla de rompimiento
	joinColumns =@JoinColumn(name="maal_id_materia"),//creamos la columna donde bajara el pk id de materia como fk
	inverseJoinColumns = @JoinColumn(name = "maal_id_alumno"))//creamos la columna donde bajara el pk id de alumno como fk
	private Set<Alumno> alumnos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCreditos() {
		return Creditos;
	}

	public void setCreditos(String creditos) {
		Creditos = creditos;
	}

	public Set<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
	
	
	
	
	
	
}
