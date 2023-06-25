package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "automovil")
public class Automovil {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_automovil")
	@SequenceGenerator(name = "seq_automovil", sequenceName = "seq_automovil", allocationSize = 1)
	@Column(name = "auto_id")
	private Integer id;
	@Column(name = "auto_placa")
	private String placa;

	// renta
	@OneToMany(mappedBy = "automovil", cascade = CascadeType.ALL)
	private List<Renta> rentas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public List<Renta> getRentas() {
		return rentas;
	}

	public void setRentas(List<Renta> rentas) {
		this.rentas = rentas;
	}

}
