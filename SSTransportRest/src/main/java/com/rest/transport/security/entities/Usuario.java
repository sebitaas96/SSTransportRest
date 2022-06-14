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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import org.springframework.data.repository.query.parser.Part.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.rest.transport.entities.Conductor;
import com.rest.transport.entities.CuentaBancaria;
import com.rest.transport.entities.Direccion;
import com.rest.transport.entities.Expedidor;
import com.rest.transport.entities.Notificacion;
import com.rest.transport.entities.Porte;
import com.rest.transport.entities.Provincia;
import com.rest.transport.entities.Transporte;
import com.rest.transport.entities.Viaje;

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
	
	@Column(nullable=false)
	private boolean activo;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne(optional=true)
	private Direccion residenteDeDireccion;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne(optional=true)
	private Provincia operadorDeProvincia;
	
	@ManyToMany(fetch = FetchType.EAGER , mappedBy="usuarios")
	@JsonIgnore
	private Collection<Rol>roles;

	
	@OneToOne(optional=true)
	@JsonManagedReference
	private CuentaBancaria cuentaBancaria;
	
	@OneToMany(mappedBy = "notificacionDeUsuario", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Notificacion>notificaciones;
	
	

	
	public Usuario() {
		this.roles = new ArrayList<Rol>();
		this.notificaciones = new ArrayList<Notificacion>();
	}

	public Usuario(String nombre, String nombreUsuario,String password , String documento, String email, String telefono,boolean activo, Direccion residenteDeDireccion,
			Provincia operadorDeProvincia,CuentaBancaria cuentaBancaria) {
		super();
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.documento = documento;
		this.email = email;
		this.telefono = telefono;
		this.activo = activo;
		this.residenteDeDireccion = residenteDeDireccion;
		this.operadorDeProvincia = operadorDeProvincia;
		this.cuentaBancaria = cuentaBancaria;
		this.roles = new ArrayList<Rol>();
		this.notificaciones = new ArrayList<Notificacion>();
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
	
	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
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
	
	public Collection<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(Collection<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}
	
	
	
	////===================



	public void addRoles(Rol rol) {
		this.roles.add(rol);
		rol.getUsuarios().add(this);
	}
	
	public void removeRoles(Rol rol) {
		this.roles.remove(rol);
		rol.getUsuarios().remove(this);
	}
	

	
	
	
	
	
	
}
