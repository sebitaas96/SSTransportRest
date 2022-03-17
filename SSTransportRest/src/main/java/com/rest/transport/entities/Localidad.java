package com.rest.transport.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Localidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private int cp;
	
	@ManyToOne
	private Provincia localidadDeProvincia;
	
	@OneToMany(mappedBy = "direccionDeLocalidad", cascade = CascadeType.ALL)
	private Collection<Direccion> direcciones;

	public Localidad() {
		this.direcciones = new ArrayList<Direccion>();
	}

	public Localidad(String nombre, int cp, Provincia localidadDeProvincia) {
		super();
		this.nombre = nombre;
		this.cp = cp;
		this.localidadDeProvincia = localidadDeProvincia;
		this.localidadDeProvincia.getLocalidades().add(this);
		this.direcciones = new ArrayList<Direccion>();
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

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public Provincia getLocalidadDeProvincia() {
		return localidadDeProvincia;
	}

	public void setLocalidadDeProvincia(Provincia localidadDeProvincia) {
		this.localidadDeProvincia = localidadDeProvincia;
	}

	public Collection<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Collection<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	

}
