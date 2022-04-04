package com.rest.transport.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.rest.transport.security.entities.Usuario;

@Entity
public class CuentaBancaria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombreTitular;
	
	private String swiftBic;
	
	private int iban;
	
	@OneToOne(mappedBy="cuentaBancaria")
	private Usuario empresa;
	
	public CuentaBancaria() {
		
	}

	public CuentaBancaria(String nombreTitular, String swiftBic, int iban, Usuario empresa) {
		super();
		this.nombreTitular = nombreTitular;
		this.swiftBic = swiftBic;
		this.iban = iban;
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getSwiftBic() {
		return swiftBic;
	}

	public void setSwiftBic(String swiftBic) {
		this.swiftBic = swiftBic;
	}

	public int getIban() {
		return iban;
	}

	public void setIban(int iban) {
		this.iban = iban;
	}

	public Usuario getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Usuario empresa) {
		this.empresa = empresa;
	}
	
	
	
	
}
