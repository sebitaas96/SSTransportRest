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
public class Camion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String matricula;
	
	private boolean estado;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Usuario camionDeUsuario;
	
	@OneToMany(mappedBy="viajeDeCamion" , cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje> viajes;
	
	public Camion() {
		this.viajes = new ArrayList<Viaje>();
	}

	public Camion(String matricula, boolean estado, Usuario camionDeUsuario) {
		super();
		this.matricula = matricula;
		this.estado = estado;
		this.camionDeUsuario = camionDeUsuario;
		this.camionDeUsuario.getCamiones().add(this);
		this.viajes = new ArrayList<Viaje>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Usuario getCamionDeUsuario() {
		return camionDeUsuario;
	}

	public void setCamionDeUsuario(Usuario camionDeUsuario) {
		this.camionDeUsuario = camionDeUsuario;
		this.camionDeUsuario.getCamiones().add(this);
	}

	public Collection<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Collection<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	
	
	
	
}
