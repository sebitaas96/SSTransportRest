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
import com.rest.transport.security.entities.Usuario;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Conductor extends Usuario{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String apellido;
	
	private boolean estado;

	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Transporte conductorDeTransporte;
	
	
	@OneToMany(mappedBy = "viajeDeConductor", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje>viajes;
	
	public Conductor() {
		
	}

	
	/*public Conductor(String nombre, String apellido, String documento, String email, String telefono,
			Transporte conductorDeTransporte) {
		super();
		this.apellido = apellido;
		this.conductorDeTransporte = conductorDeTransporte;
		this.conductorDeTransporte.getConductores().add(this);
		this.viajes = new ArrayList<Viaje>();
	}*/

	public Conductor(String nombre,String nombreUsuario,String apellido, String password, String documento, String email, String telefono,boolean estado,
			Transporte conductorDeTransporte,Direccion residenteDeDireccion, Provincia operadorDeProvincia, CuentaBancaria cuentaBancaria) {
		super(nombre, nombreUsuario,password, documento, email, telefono, residenteDeDireccion, operadorDeProvincia, cuentaBancaria);
		this.apellido = apellido;
		this.estado = estado;
		this.conductorDeTransporte = conductorDeTransporte;
		this.conductorDeTransporte.getConductores().add(this);
		this.viajes = new ArrayList<Viaje>();
		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	

	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public Transporte getConductorDeTransporte() {
		return conductorDeTransporte;
	}

	public void setConductorDeTransporte(Transporte conductorDeTransporte) {
		this.conductorDeTransporte = conductorDeTransporte;
		this.conductorDeTransporte.getConductores().add(this);
	}


	public Collection<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Collection<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	
	
	
	
	
	
	
	
}
