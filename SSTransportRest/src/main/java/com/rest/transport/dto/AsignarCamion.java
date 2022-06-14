package com.rest.transport.dto;

import javax.persistence.Column;

import com.rest.transport.entities.Camion;

public class AsignarCamion {
	@Column(nullable=false)
	private Long idViaje;
	
	@Column(nullable=false)
	private Camion camion;

	public Long getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Long idViaje) {
		this.idViaje = idViaje;
	}

	public Camion getCamion() {
		return camion;
	}

	public void setCamion(Camion camion) {
		this.camion = camion;
	}
	
	
}
