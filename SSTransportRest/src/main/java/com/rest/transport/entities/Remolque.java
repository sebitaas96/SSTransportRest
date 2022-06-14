package com.rest.transport.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Remolque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String matricula;
	
	private boolean estado;
	
	@ManyToOne(optional=true)
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Transporte remolqueDeTransporte;
	
	@ManyToOne(optional=true)
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Conductor remolqueDeConductor;
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private TipoRemolque remolqueDeTipoRemolque;
	
	@OneToMany(mappedBy = "viajeDeRemolque", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje>viajes;
	
	public Remolque() {
		this.viajes = new ArrayList<Viaje>();
	}

	public Remolque(String matricula, boolean estado, Transporte remolqueDeTransporte,
			Conductor remolqueDeConductor,
			TipoRemolque remolqueDeTipoRemolque) {
		super();
		this.matricula = matricula;
		this.estado = estado;
		this.remolqueDeTransporte = remolqueDeTransporte;
		this.remolqueDeConductor = remolqueDeConductor;
		this.remolqueDeTipoRemolque = remolqueDeTipoRemolque;
		this.remolqueDeTipoRemolque.getRemolques().add(this);
		this.viajes = new ArrayList<Viaje>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Transporte getRemolqueDeTransporte() {
		return remolqueDeTransporte;
	}

	public void setRemolqueDeTransporte(Transporte remolqueDeTransporte) {
		this.remolqueDeTransporte = remolqueDeTransporte;
	}


	public Conductor getRemolqueDeConductor() {
		return remolqueDeConductor;
	}

	public void setRemolqueDeConductor(Conductor remolqueDeConductor) {
		this.remolqueDeConductor = remolqueDeConductor;
	}

	public TipoRemolque getRemolqueDeTipoRemolque() {
		return remolqueDeTipoRemolque;
	}

	public void setRemolqueDeTipoRemolque(TipoRemolque remolqueDeTipoRemolque) {
		this.remolqueDeTipoRemolque = remolqueDeTipoRemolque;
		this.remolqueDeTipoRemolque.getRemolques().add(this);
	}


	
	public void removeViaje(Viaje v) {
		this.viajes.remove(v);
		v.setViajeDeRemolque(null);
	}
	
	
	
	
}
