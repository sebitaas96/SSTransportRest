package com.rest.transport.dto;

import java.util.Date;

import javax.persistence.Column;

public class UpdateFecha {
	@Column(nullable=false)
	private Long idViaje;
	
	@Column(nullable=false)
	private Date fecha;

	public Long getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Long idViaje) {
		this.idViaje = idViaje;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
