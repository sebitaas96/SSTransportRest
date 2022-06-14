package com.rest.transport.dto;

import javax.persistence.Column;

import com.rest.transport.entities.Conductor;

public class AsignarConductor {
	
	@Column(nullable=false)
	private Long idViaje;
	
	@Column(nullable=false)
	private Conductor conductor;

	public Long getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Long idViaje) {
		this.idViaje = idViaje;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	
	
}
