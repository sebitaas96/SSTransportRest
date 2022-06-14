package com.rest.transport.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest.transport.security.entities.Usuario;

@Entity
public class Notificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private Date fecha;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Usuario notificacionDeUsuario;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Gravedad notificacionDeGravedad;
	
	
	public Notificacion() {
		
	}


	public Notificacion(String nombre, Date fecha, Usuario notificacionDeUsuario, Gravedad notificacionDeGravedad) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.notificacionDeUsuario = notificacionDeUsuario;
		this.notificacionDeUsuario.getNotificaciones().add(this);
		this.notificacionDeGravedad = notificacionDeGravedad;
		this.notificacionDeGravedad.getNotificaciones().add(this);
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


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Usuario getNotificacionDeUsuario() {
		return notificacionDeUsuario;
	}


	public void setNotificacionDeUsuario(Usuario notificacionDeUsuario) {
		this.notificacionDeUsuario = notificacionDeUsuario;
		this.notificacionDeUsuario.getNotificaciones().add(this);
	}


	public Gravedad getNotificacionDeGravedad() {
		return notificacionDeGravedad;
	}


	public void setNotificacionDeGravedad(Gravedad notificacionDeGravedad) {
		this.notificacionDeGravedad = notificacionDeGravedad;
		this.notificacionDeGravedad.getNotificaciones().add(this);
	}
	
	
	
	
	
	
}
