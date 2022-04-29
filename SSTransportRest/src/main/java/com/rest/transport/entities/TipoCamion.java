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
public class TipoCamion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String nombre;
	
	private boolean enganche;
	
	@OneToMany(mappedBy = "camionDeTipoCamion", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Camion>camiones;
	
	@OneToMany(mappedBy = "viajeDeTipoCamion", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje>viajes;

	public TipoCamion() {
		this.camiones = new ArrayList<Camion>();
		this.viajes = new ArrayList<Viaje>();
	}
	
	public TipoCamion(String nombre , boolean enganche) {
		super();
		this.nombre = nombre;
		this.enganche = enganche;
		this.camiones = new ArrayList<Camion>();
		this.viajes = new ArrayList<Viaje>();
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
	
	

	public boolean isEnganche() {
		return enganche;
	}

	public void setEnganche(boolean enganche) {
		this.enganche = enganche;
	}

	public Collection<Camion> getCamiones() {
		return camiones;
	}

	public void setCamiones(Collection<Camion> camiones) {
		this.camiones = camiones;
	}

	public Collection<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Collection<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	
	
}
