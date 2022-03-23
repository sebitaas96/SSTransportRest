package com.rest.transport.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public abstract class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique= true)
	private String nombre;
	
	@Column(unique= true)
	private String documento;
	
	@Column(unique= true)
	private String email;
	
	private String telefono;
	

	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Direccion residenteDeDireccion;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Provincia operadorDeProvincia;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Rol empresaDeRol;
	
	@OneToOne
	private CuentaBancaria cuentaBancaria;
	

	
	public Empresa() {
		
	}

	public Empresa(String nombre, String documento, String email, String telefono, Direccion residenteDeDireccion,
			Provincia operadorDeProvincia,Rol empresaDeRol,CuentaBancaria cuentaBancaria) {
		super();
		this.nombre = nombre;
		this.documento = documento;
		this.email = email;
		this.telefono = telefono;
		this.residenteDeDireccion = residenteDeDireccion;
		this.residenteDeDireccion.getResidentes().add(this);
		this.operadorDeProvincia = operadorDeProvincia;
		this.operadorDeProvincia.getOperadores().add(this);
		this.empresaDeRol = empresaDeRol;
		this.empresaDeRol.getEmpresas().add(this);
		this.cuentaBancaria = cuentaBancaria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Direccion getResidenteDeDireccion() {
		return residenteDeDireccion;
	}

	public void setResidenteDeDireccion(Direccion residenteDeDireccion) {
		this.residenteDeDireccion = residenteDeDireccion;
		this.residenteDeDireccion.getResidentes().add(this);
	}

	public Provincia getOperadorDeProvincia() {
		return operadorDeProvincia;
	}

	public void setOperadorDeProvincia(Provincia operadorDeProvincia) {
		this.operadorDeProvincia = operadorDeProvincia;
		this.operadorDeProvincia.getOperadores().add(this);
	}

	
	public Rol getEmpresaDeRol() {
		return empresaDeRol;
	}

	public void setEmpresaDeRol(Rol empresaDeRol) {
		this.empresaDeRol = empresaDeRol;
		this.empresaDeRol.getEmpresas().add(this);
	}

	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	
	
	
	
	
	
	
}
