package com.rest.transport.entities;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rest.transport.security.entities.Usuario;

@Entity
public class CuentaBancaria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombreTitular;
	
	private String swiftBic;
	
	@Column(unique = true)
	private String iban;
	
	@OneToOne(mappedBy="cuentaBancaria" , optional=true)
	@JsonBackReference
	private Usuario usuario;
	
	public CuentaBancaria() {
		
	}

	public CuentaBancaria(String nombreTitular, String swiftBic, String iban, Usuario usuario) {
		super();
		this.nombreTitular = nombreTitular;
		this.swiftBic = swiftBic;
		this.iban = iban;
		this.usuario = usuario;
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

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
