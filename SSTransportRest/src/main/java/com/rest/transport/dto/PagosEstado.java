package com.rest.transport.dto;

import javax.persistence.Column;

public class PagosEstado {

	@Column(nullable=false)
	private Long idEmpresa;
	
	@Column(nullable=false)
	private String estadoPago;

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(String estadoPago) {
		this.estadoPago = estadoPago;
	}
	
	
}
