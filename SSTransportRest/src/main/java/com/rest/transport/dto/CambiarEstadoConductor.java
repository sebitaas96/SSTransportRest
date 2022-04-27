package com.rest.transport.dto;

public class CambiarEstadoConductor {
	private boolean estado;
	private Long idConductor;
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Long getIdConductor() {
		return idConductor;
	}
	public void setIdConductor(Long idConductor) {
		this.idConductor = idConductor;
	}
	
	
	

}
