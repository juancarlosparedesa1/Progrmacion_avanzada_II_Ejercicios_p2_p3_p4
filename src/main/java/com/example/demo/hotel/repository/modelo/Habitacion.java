package com.example.demo.hotel.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_habit")
	@SequenceGenerator(name = "seq_habit", sequenceName = "seq_habit", allocationSize = 1)
	private Integer id;
	private String numero;
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "habit_id_hotel")
	private Hotel hotel;

	// get and set

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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
