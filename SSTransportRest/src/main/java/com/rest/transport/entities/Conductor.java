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
	

	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Transporte conductorDeTransporte;
	
	
	@OneToMany(mappedBy = "viajeDeConductor", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje>viajes;
	
	
	@OneToMany(mappedBy = "camionDeConductor", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Camion>camiones;
	
	
	@OneToMany(mappedBy = "remolqueDeConductor", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Remolque>remolques;
	
	public Conductor() {
		this.viajes = new ArrayList<Viaje>();
		this.camiones = new ArrayList<Camion>();
		this.remolques = new ArrayList<Remolque>();
	}

	
	/*public Conductor(String nombre, String apellido, String documento, String email, String telefono,
			Transporte conductorDeTransporte) {
		super();
		this.apellido = apellido;
		this.conductorDeTransporte = conductorDeTransporte;
		this.conductorDeTransporte.getConductores().add(this);
		this.viajes = new ArrayList<Viaje>();
	}*/

	public Conductor(String nombre,String nombreUsuario,String apellido, String password, String documento, String email, String telefono,boolean activo,
			Transporte conductorDeTransporte,Direccion residenteDeDireccion, Provincia operadorDeProvincia, CuentaBancaria cuentaBancaria) {
		super(nombre, nombreUsuario,password, documento, email, telefono,activo, residenteDeDireccion, operadorDeProvincia, cuentaBancaria);
		this.apellido = apellido;
		this.conductorDeTransporte = conductorDeTransporte;
		this.conductorDeTransporte.getConductores().add(this);
		this.viajes = new ArrayList<Viaje>();
		this.camiones = new ArrayList<Camion>();
		this.remolques = new ArrayList<Remolque>();
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

	


	public Transporte getConductorDeTransporte() {
		return conductorDeTransporte;
	}

	public void setConductorDeTransporte(Transporte conductorDeTransporte) {
		this.conductorDeTransporte = conductorDeTransporte;
		this.conductorDeTransporte.getConductores().add(this);
	}


	
	//
	
	public void removeViaje(Viaje v) {
		this.viajes.remove(v);
		v.setViajeDeConductor(null);
	}
	
	
	
	
	
	
	
}
