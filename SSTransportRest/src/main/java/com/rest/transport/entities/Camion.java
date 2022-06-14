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

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Camion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String matricula;
	
	private boolean estado;
	
	@ManyToOne(optional=true)
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Transporte camionDeTransporte;
	
	@ManyToOne(optional=true)
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Conductor camionDeConductor;
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private TipoCamion camionDeTipoCamion;
	
	@OneToMany(mappedBy = "viajeDeCamion", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje>viajes;
	
	public Camion() {
		this.viajes = new ArrayList<Viaje>();
	}
	
	public Camion(String matricula, boolean estado, Transporte camionDeTransporte, Conductor camionDeConductor,
			TipoCamion camionDeTipoCamion) {
		super();
		this.matricula = matricula;
		this.estado = estado;
		this.camionDeTransporte = camionDeTransporte;
		this.camionDeConductor = camionDeConductor;
		this.camionDeTipoCamion = camionDeTipoCamion;
		this.camionDeTipoCamion.getCamiones().add(this);
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

	public Transporte getCamionDeTransporte() {
		return camionDeTransporte;
	}

	public void setCamionDeTransporte(Transporte camionDeTransporte) {
		this.camionDeTransporte = camionDeTransporte;
	}
	
	

	public Conductor getCamionDeConductor() {
		return camionDeConductor;
	}

	public void setCamionDeConductor(Conductor camionDeConductor) {
		this.camionDeConductor = camionDeConductor;
	}

	public TipoCamion getCamionDeTipoCamion() {
		return camionDeTipoCamion;
	}

	public void setCamionDeTipoCamion(TipoCamion camionDeTipoCamion) {
		this.camionDeTipoCamion = camionDeTipoCamion;
		this.camionDeTipoCamion.getCamiones().add(this);
	}


	public void removeViaje(Viaje v) {
		this.viajes.remove(v);
		v.setViajeDeCamion(null);
	}
	
	

	
	
	
	
	
}
