package com.rest.transport.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Conductor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	@Column(unique = true)
	private String documento;
	
	@Column(unique = true)
	private String email;
	
	private String telefono;
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Transporte conductorDeTransporte;
	
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Rol conductorDeRol;
	
	@OneToMany(mappedBy = "viajeDeConductor", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje>viajes;
	
	public Conductor() {
		this.viajes = new ArrayList<Viaje>();
	}

	public Conductor(String nombre, String apellido, String documento, String email, String telefono,
			Transporte conductorDeTransporte, Rol conductorDeRol) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.email = email;
		this.telefono = telefono;
		this.conductorDeTransporte = conductorDeTransporte;
		this.conductorDeTransporte.getConductores().add(this);
		this.conductorDeRol = conductorDeRol;
		this.conductorDeRol.getConductores().add(this);
		this.viajes = new ArrayList<Viaje>();
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public Transporte getConductorDeTransporte() {
		return conductorDeTransporte;
	}

	public void setConductorDeTransporte(Transporte conductorDeTransporte) {
		this.conductorDeTransporte = conductorDeTransporte;
		this.conductorDeTransporte.getConductores().add(this);
	}

	public Rol getConductorDeRol() {
		return conductorDeRol;
	}

	public void setConductorDeRol(Rol conductorDeRol) {
		this.conductorDeRol = conductorDeRol;
		this.conductorDeRol.getConductores().add(this);
	}

	public Collection<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Collection<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	
	
	
	
	
	
	
	
}
