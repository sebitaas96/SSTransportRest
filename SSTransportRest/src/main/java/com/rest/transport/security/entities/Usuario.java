package com.rest.transport.security.entities;

import java.util.ArrayList;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


import org.springframework.data.repository.query.parser.Part.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest.transport.entities.CuentaBancaria;
import com.rest.transport.entities.Direccion;
import com.rest.transport.entities.Provincia;

@Entity
public abstract class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(nullable=false)
	private String nombre;
	
	@Column(unique = true,nullable=false)
	private String nombreUsuario;
	
	@Column(nullable=false)
	private String password;
	
	@Column(unique= true , nullable=false)
	private String documento;
	
	@Column(unique= true , nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String telefono;
	

	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Direccion residenteDeDireccion;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Provincia operadorDeProvincia;
	
	@Column(nullable=false)
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Collection<Rol>roles;
	
	@OneToOne(optional=true)
	private CuentaBancaria cuentaBancaria;
	

	
	public Usuario() {
		this.roles = new ArrayList<Rol>();
	}

	public Usuario(String nombre, String nombreUsuario,String password , String documento, String email, String telefono, Direccion residenteDeDireccion,
			Provincia operadorDeProvincia,CuentaBancaria cuentaBancaria) {
		super();
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.documento = documento;
		this.email = email;
		this.telefono = telefono;
		this.residenteDeDireccion = residenteDeDireccion;
		this.residenteDeDireccion.getResidentes().add(this);
		this.operadorDeProvincia = operadorDeProvincia;
		this.operadorDeProvincia.getOperadores().add(this);
		this.cuentaBancaria = cuentaBancaria;
		this.roles = new ArrayList<Rol>();
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
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	
	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	
	
	
	
	////===================

	public void addUsuarios(Rol rol) {
		this.roles.add(rol);
		rol.getUsuarios().add(this);
	}

	
	
	
	
	
	
}
