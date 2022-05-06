package com.rest.transport.dto;

import com.rest.transport.entities.Conductor;

public class asignacionEquipo {
	
	private Conductor conductor;
	private Long idEquipo;
	
	public asignacionEquipo(Conductor conductor, Long idEquipo) {
		super();
		this.conductor = conductor;
		this.idEquipo = idEquipo;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public Long getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}
	
	
	

}
