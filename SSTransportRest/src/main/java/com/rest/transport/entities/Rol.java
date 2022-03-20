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
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String nombre;
	
	@OneToMany(mappedBy = "transporteDeRol", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Transporte> transportes;
	
	@OneToMany(mappedBy = "conductorDeRol", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Conductor>conductores;
	
	public Rol() {
		this.transportes = new ArrayList<Transporte>();
		this.conductores = new ArrayList<Conductor>();
	}

	public Rol(String nombre) {
		super();
		this.nombre = nombre;
		this.transportes = new ArrayList<Transporte>();
		this.conductores = new ArrayList<Conductor>();
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

	public Collection<Transporte> getTransportes() {
		return transportes;
	}

	public void setTransportes(Collection<Transporte> transportes) {
		this.transportes = transportes;
	}

	public Collection<Conductor> getConductores() {
		return conductores;
	}

	public void setConductores(Collection<Conductor> conductores) {
		this.conductores = conductores;
	}
	
	
	
	
	
}
