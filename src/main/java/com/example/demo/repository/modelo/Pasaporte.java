package com.example.demo.repository.modelo;

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
@Table(name = "pasaporte")
public class Pasaporte {
	@Id
	// Secuencias
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pasap")
	@SequenceGenerator(name = "seq_pasap", sequenceName = "seq_pasap", allocationSize = 1)
	@Column(name = "pasap_id")
	private Integer id;

	@Column(name = "pasap_numero")
	private String numero;

	@Column(name = "pasap_pais")
	private String pais;

	// secundaria
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pasap_persona_id")
	private Persona persona;

//SET AND GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
