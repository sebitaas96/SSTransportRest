package com.rest.transport.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nombre;
	
	@OneToMany(fetch = FetchType.EAGER , mappedBy="viajeDeEstado", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje> viajes;
	
	public Estado() {
		this.viajes = new ArrayList<Viaje>();
	}

	public Estado(String nombre) {
		super();
		this.nombre = nombre;
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

	public Collection<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Collection<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	public void removeViaje(Viaje v) {
		this.viajes.remove(v);
		v.setViajeDeEstado(null);
	}
	
	
	
	
}
