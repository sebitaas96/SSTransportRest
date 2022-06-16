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
public class Expedidor extends Usuario {

	
	private String apellido;
	
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Porte expedidorDePorte;
	
	@OneToMany(mappedBy = "viajeDeExpedidor", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje> viajes;

	
	
	
	public Expedidor() {
		this.viajes = new ArrayList<Viaje>();
	}

	public Expedidor(String nombre, String nombreUsuario, String apellido, String password, String documento, String email,
			String telefono, boolean activo , Porte expedidorDePorte, Direccion residenteDeDireccion, Provincia operadorDeProvincia,
			CuentaBancaria cuentaBancaria) {
		super(nombre, nombreUsuario, password, documento, email, telefono,activo, residenteDeDireccion, operadorDeProvincia,
				cuentaBancaria);
		this.apellido = apellido;
		this.expedidorDePorte = expedidorDePorte;
		this.expedidorDePorte.getExpedidores().add(this);
		this.viajes = new ArrayList<Viaje>();
	}


	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Porte getExpedidorDePorte() {
		return expedidorDePorte;
	}

	public void setExpedidorDePorte(Porte expedidorDePorte) {
		this.expedidorDePorte = expedidorDePorte;
		this.expedidorDePorte.getExpedidores().add(this);
	}

	public Collection<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Collection<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	
}
