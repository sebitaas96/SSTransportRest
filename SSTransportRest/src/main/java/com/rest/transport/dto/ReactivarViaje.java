package com.rest.transport.dto;

import java.util.Date;

import javax.persistence.Column;


public class ReactivarViaje {
	
	@Column(nullable=false)
	private Long idViaje;
	
	@Column(nullable=false)
	private Date fInicio;
	
	@Column(nullable=false)
	private Date fFin;

	
	
	
	public Long getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Long idViaje) {
		this.idViaje = idViaje;
	}

	public Date getfInicio() {
		return fInicio;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public Date getfFin() {
		return fFin;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}
	
	
	
}
