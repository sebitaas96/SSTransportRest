package com.rest.transport.dto;

import java.util.Date;

import javax.persistence.Column;

import com.rest.transport.entities.Notificacion;

public class NuevaNotificacion {
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private Date fecha;
	
	@Column(nullable=false)
	private Long idUsuario;
	
	@Column(nullable=false)
	private Long idGravedad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdGravedad() {
		return idGravedad;
	}

	public void setIdGravedad(Long idGravedad) {
		this.idGravedad = idGravedad;
	}


	
	
	
}
