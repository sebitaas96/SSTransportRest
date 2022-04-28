package com.rest.transport.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private TipoCamion camionDeTipoCamion;
	
	public Camion() {
		
	}
	
	public Camion(String matricula, boolean estado, Transporte camionDeTransporte,
			TipoCamion camionDeTipoCamion) {
		super();
		this.matricula = matricula;
		this.estado = estado;
		this.camionDeTransporte = camionDeTransporte;
		this.camionDeTransporte.getCamiones().add(this);
		this.camionDeTipoCamion = camionDeTipoCamion;
		this.camionDeTipoCamion.getCamiones().add(this);
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

	public TipoCamion getCamionDeTipoCamion() {
		return camionDeTipoCamion;
	}

	public void setCamionDeTipoCamion(TipoCamion camionDeTipoCamion) {
		this.camionDeTipoCamion = camionDeTipoCamion;
		this.camionDeTipoCamion.getCamiones().add(this);
	}

	
	
	
	
	
}
