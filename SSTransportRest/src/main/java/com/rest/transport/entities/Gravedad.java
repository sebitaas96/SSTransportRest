package com.rest.transport.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Gravedad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nombre;
	
	@OneToMany(mappedBy="notificacionDeGravedad", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Notificacion> notificaciones;
	
	
	public Gravedad() {
		this.notificaciones = new ArrayList<Notificacion>();
	}
	
	public Gravedad(String nombre) {
		this.nombre = nombre;
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

	public Collection<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(Collection<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}
	
	
	
}
