package com.rest.transport.dto;

import com.rest.transport.entities.CuentaBancaria;

public class addCuenta {

	private CuentaBancaria cuentaBancaria;
	private Long idUsuario;
	
	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	@Override
	public String toString() {
		return "addCuenta [cuentaBancaria=" + cuentaBancaria + ", idUsuario=" + idUsuario + "]";
	}
	
	
	
}
