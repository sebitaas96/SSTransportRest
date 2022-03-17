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
public class Provincia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@ManyToOne
	private Pais provinciaDePais;

	@OneToMany(mappedBy = "localidadDeProvincia", cascade = CascadeType.ALL)
	private Collection<Localidad> localidades;
	
	public Provincia() {
		this.localidades = new ArrayList<Localidad>();
	}

	public Provincia(String nombre,Pais provinciaDePais) {
		this.nombre = nombre;
		this.provinciaDePais = provinciaDePais;
		this.provinciaDePais.getProvincias().add(this);
		this.localidades = new ArrayList<Localidad>();
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

	public Pais getProvinciaDePais() {
		return provinciaDePais;
	}

	public void setProvinciaDePais(Pais provinciaDePais) {
		this.provinciaDePais = provinciaDePais;
	}

	public Collection<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(Collection<Localidad> localidades) {
		this.localidades = localidades;
	}
	
	
	
}
