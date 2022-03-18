package com.rest.transport.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nombre;
	
	@OneToMany(mappedBy = "rolDeUsuario" , cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Usuario> usuarios;
	
	
	@OneToMany(mappedBy = "viajeDeRol" , cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje> viajes;
	
	@OneToMany(mappedBy = "pagoDeRol" , cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Pago> pagos;
	
	public Rol() {
		this.usuarios = new ArrayList<Usuario>();
		this.viajes = new ArrayList<Viaje>();
		this.pagos = new ArrayList<Pago>();
	}

	public Rol(String nombre) {
		super();
		this.nombre = nombre;
		this.usuarios = new ArrayList<Usuario>();
		this.viajes = new ArrayList<Viaje>();
		this.pagos = new ArrayList<Pago>();
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

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Collection<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Collection<Viaje> viajes) {
		this.viajes = viajes;
	}

	public Collection<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(Collection<Pago> pagos) {
		this.pagos = pagos;
	}
	
	
	
	
	
	
}
