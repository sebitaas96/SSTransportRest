package com.rest.transport.dto;

import javax.persistence.Column;

import com.rest.transport.entities.Remolque;

public class AsignarRemolque {
	@Column(nullable=false)
	private Long idViaje;
	
	@Column(nullable=false)
	private Remolque remolque;

	public Long getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Long idViaje) {
		this.idViaje = idViaje;
	}

	public Remolque getRemolque() {
		return remolque;
	}

	public void setRemolque(Remolque remolque) {
		this.remolque = remolque;
	}
	
	
	
}
