package com.rest.transport.dto;

import javax.persistence.Column;

import com.rest.transport.entities.Conductor;
import com.rest.transport.entities.Transporte;

public class ReservarViaje {
	
	@Column(nullable=false)
	private Long idViaje;
	
	@Column(nullable=false)
	private Transporte transporte;
	
	@Column(nullable=true)
	private Conductor conductor;

	public Long getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Long idViaje) {
		this.idViaje = idViaje;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	
	
	
}
