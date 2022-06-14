package com.rest.transport.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class EstadoPago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nombre;
	
	@OneToMany(mappedBy="pagoDeEstadoPago", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Pago> pagos;
	
	public EstadoPago() {
		this.pagos = new ArrayList<Pago>();
		
	}
	
	
	public EstadoPago(String nombre) {
		this.nombre = nombre;
		this.pagos = new ArrayList<Pago>();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Collection<Pago> getPagos() {
		return pagos;
	}


	public void setPagos(Collection<Pago> pagos) {
		this.pagos = pagos;
	}
	
	
}
