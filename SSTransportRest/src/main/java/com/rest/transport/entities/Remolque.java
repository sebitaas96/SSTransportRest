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
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Transporte remolqueDeTransporte;
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private TipoRemolque remolqueDeTipoRemolque;
	
	public Remolque() {}

	public Remolque(String matricula, boolean estado, Transporte remolqueDeTransporte,
			TipoRemolque remolqueDeTipoRemolque) {
		super();
		this.matricula = matricula;
		this.estado = estado;
		this.remolqueDeTransporte = remolqueDeTransporte;
		this.remolqueDeTransporte.getRemolques().add(this);
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
		this.remolqueDeTransporte.getRemolques().add(this);
	}

	public TipoRemolque getRemolqueDeTipoRemolque() {
		return remolqueDeTipoRemolque;
	}

	public void setRemolqueDeTipoRemolque(TipoRemolque remolqueDeTipoRemolque) {
		this.remolqueDeTipoRemolque = remolqueDeTipoRemolque;
		this.remolqueDeTipoRemolque.getRemolques().add(this);
	}
	
	
	
	
}
