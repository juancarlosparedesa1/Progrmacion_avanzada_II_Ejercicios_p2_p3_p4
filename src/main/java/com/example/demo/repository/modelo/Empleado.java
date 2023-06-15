package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empl")
	@SequenceGenerator(name = "seq_empl", sequenceName = "seq_empl", allocationSize = 1)
	@Column(name = "empl_id")
	private Integer id;
	@Column(name = "empl_sueldo")
	private BigDecimal sueldo;
	@Column(name = "empl_cargo")
	private String cargo;

	@OneToOne(cascade = CascadeType.ALL)
//	@OneToOne(mappedBy = "ciudadano",cascade = CascadeType.ALL)
	@JoinColumn(name = "empl_ciudadano_id") // nombre del atributo
	private Ciudadano ciudadano;

//SET and Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", sueldo=" + sueldo + ", cargo=" + cargo + ", ciudadano=" + ciudadano + "]";
	}

}
