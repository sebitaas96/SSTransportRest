package com.rest.transport.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class CuentaBancaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombreTitular;
	
	private  String swiftBic;
	
	private  int iban;
	
	@OneToOne(mappedBy ="cuentaBancaria")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "pagoDeCuenta" , cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection <Pago> pagos;
	
	public CuentaBancaria() {
		this.pagos = new ArrayList<Pago>();
	}

	public CuentaBancaria(String nombreTitular, String swiftBic, int iban, Usuario usuario) {
		super();
		this.nombreTitular = nombreTitular;
		this.swiftBic = swiftBic;
		this.iban = iban;
		this.usuario = usuario;
		this.pagos = new ArrayList<Pago>();
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Collection<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(Collection<Pago> pagos) {
		this.pagos = pagos;
	}
	
	
	
	
}
