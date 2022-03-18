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
public class TipoRemolque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String tipo;
	
	@OneToMany(mappedBy = "remolqueDeTipoRemolque" , cascade =  CascadeType.ALL)
	@JsonIgnore
	private Collection<Remolque>remolques;
	
	@OneToMany(mappedBy = "viajeDeTipoRemolque" , cascade =  CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje> viajes;
	
	public TipoRemolque() {
		this.remolques = new ArrayList<Remolque>();
		this.viajes = new ArrayList<Viaje>();
	}

	public TipoRemolque(String tipo) {
		super();
		this.tipo = tipo;
		this.remolques = new ArrayList<Remolque>();
		this.viajes = new ArrayList<Viaje>();
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

	public Collection<Remolque> getRemolques() {
		return remolques;
	}

	public void setRemolques(Collection<Remolque> remolques) {
		this.remolques = remolques;
	}

	public Collection<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Collection<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	
	
	

	
	
}
