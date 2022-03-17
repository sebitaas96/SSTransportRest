package com.rest.transport.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tipo;
	
	private String nombre;
	
	private int numero;
	
	@ManyToOne
	private Localidad direccionDeLocalidad;

	public Direccion() {
		
	}

	public Direccion(String tipo, String nombre, int numero, Localidad direccionDeLocalidad) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.numero = numero;
		this.direccionDeLocalidad = direccionDeLocalidad;
		this.direccionDeLocalidad.getDirecciones().add(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Localidad getDireccionDeLocalidad() {
		return direccionDeLocalidad;
	}

	public void setDireccionDeLocalidad(Localidad direccionDeLocalidad) {
		this.direccionDeLocalidad = direccionDeLocalidad;
	}
	
	
	

}
