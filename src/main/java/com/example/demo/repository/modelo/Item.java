package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
@NamedNativeQuery(name = "Item.buscarItemCodigoBarrasNative", query = "SELECT * FROM Item WHERE item_cod_barras=:datoCodigoBarras", resultClass = Item.class)
public class Item {

	@Id
	// Secuencias
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item")
	@SequenceGenerator(name = "seq_item", sequenceName = "seq_item", allocationSize = 1)
	@Column(name = "itm_id")
	private Integer id;

	@Column(name = "item_cod_barras")
	private String codigoBarras;

	@Column(name = "item_nombre")
	private String nombre;

	@Column(name = "item_tipo")
	private String tipo;

	@Column(name = "item_strock")
	private Integer stock;

	@Column(name = "item_precio")
	private BigDecimal precio;

	// relaciones
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	private List<DetalleFactura> detallesFactura;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getDetallesFactura() {
		return detallesFactura;
	}

	public void setDetallesFactura(List<DetalleFactura> detallesFactura) {
		this.detallesFactura = detallesFactura;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", stock=" + stock + ", precio=" + precio + ", detallesFactura=" + detallesFactura + "]";
	}
}
