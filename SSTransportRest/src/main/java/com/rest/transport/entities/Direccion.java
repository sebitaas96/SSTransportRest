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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tipo;
	
	private String nombre;
	
	private int numero;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Localidad direccionDeLocalidad;

	@OneToMany(mappedBy="recogidaDeDireccion" , cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje> recogidas;
	
	@OneToMany(mappedBy="entregaDeDireccion" , cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje> entregas;
	
	@OneToMany(mappedBy="residenteDeDireccion" , cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Empresa> residentes;
	
	public Direccion() {
		this.recogidas = new ArrayList<Viaje>();
		this.entregas = new ArrayList<Viaje>();
		this.residentes = new ArrayList<Empresa>();
	}

	public Direccion(String tipo, String nombre, int numero, Localidad direccionDeLocalidad) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.numero = numero;
		this.direccionDeLocalidad = direccionDeLocalidad;
		this.direccionDeLocalidad.getDirecciones().add(this);
		this.recogidas = new ArrayList<Viaje>();
		this.entregas = new ArrayList<Viaje>();
		this.residentes = new ArrayList<Empresa>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Localidad getDireccionDeLocalidad() {
		return direccionDeLocalidad;
	}

	public void setDireccionDeLocalidad(Localidad direccionDeLocalidad) {
		this.direccionDeLocalidad = direccionDeLocalidad;
		this.direccionDeLocalidad.getDirecciones().add(this);
	}

	public Collection<Viaje> getRecogidas() {
		return recogidas;
	}

	public void setRecogidas(Collection<Viaje> recogidas) {
		this.recogidas = recogidas;
	}

	public Collection<Viaje> getEntregas() {
		return entregas;
	}

	public void setEntregas(Collection<Viaje> entregas) {
		this.entregas = entregas;
	}

	public Collection<Empresa> getResidentes() {
		return residentes;
	}

	public void setResidentes(Collection<Empresa> residentes) {
		this.residentes = residentes;
	}
	
	
	
	

}
