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
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Transporte camionDeTransporte;
	
	@OneToMany(mappedBy="viajeDeCamion", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje>viajes;
	
	public Camion() {
		
	}
	
	public Camion(String matricula, boolean estado, Transporte camionDeTransporte) {
		super();
		this.matricula = matricula;
		this.estado = estado;
		this.camionDeTransporte = camionDeTransporte;
		this.camionDeTransporte.getCamiones().add(this);
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
		this.camionDeTransporte.getCamiones().add(this);
	}

	public Collection<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Collection<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	
	
	
}
