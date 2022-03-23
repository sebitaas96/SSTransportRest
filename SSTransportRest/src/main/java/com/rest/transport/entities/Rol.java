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
	
	@OneToMany(mappedBy = "empresaDeRol", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Empresa> empresas;
	
	@OneToMany(mappedBy = "conductorDeRol", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Conductor>conductores;
	
	public Rol() {
		this.empresas = new ArrayList<Empresa>();
		this.conductores = new ArrayList<Conductor>();
	}

	public Rol(String nombre) {
		super();
		this.nombre = nombre;
		this.empresas = new ArrayList<Empresa>();
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

	public Collection<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Collection<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Collection<Conductor> getConductores() {
		return conductores;
	}

	public void setConductores(Collection<Conductor> conductores) {
		this.conductores = conductores;
	}
	
	
	
	
	
}
