package com.rest.transport.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	public Remolque() {}

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
	
	
	
	
	
}
