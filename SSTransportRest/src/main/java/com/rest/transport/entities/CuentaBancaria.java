package com.rest.transport.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CuentaBancaria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombreTitular;
	
	private String swiftBic;
	
	private int iban;
	
	@OneToOne(mappedBy="cuentaBancaria")
	private Empresa empresa;
	
	public CuentaBancaria() {
		
	}

	public CuentaBancaria(String nombreTitular, String swiftBic, int iban, Empresa empresa) {
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
	
	
}
