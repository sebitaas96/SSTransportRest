package com.rest.transport.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest.transport.security.entities.Usuario;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Porte extends Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "expedidorDePorte", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Expedidor>expedidores;

	@OneToMany(mappedBy = "viajeDePorte", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje> viajes;
	
	@OneToMany(mappedBy = "invitacionDePorte", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Email> invitaciones;
	
	@OneToMany(mappedBy = "pagoDePorte", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Pago> pagos;
	
	
	public Porte() {
		this.expedidores = new ArrayList<Expedidor>();
		this.invitaciones = new ArrayList<Email>();
		this.viajes = new ArrayList<Viaje>();
		this.pagos = new ArrayList<Pago>();
	}

	public Porte(String nombre, String nombreUsuario, String password, String documento, String email, String telefono,
			boolean activo,
			Direccion residenteDeDireccion, Provincia operadorDeProvincia, CuentaBancaria cuentaBancaria) {
		super(nombre, nombreUsuario, password, documento, email, telefono,activo, residenteDeDireccion, operadorDeProvincia,
				cuentaBancaria);
		
		this.expedidores = new ArrayList<Expedidor>();
		this.invitaciones = new ArrayList<Email>();
		this.viajes = new ArrayList<Viaje>();
		this.pagos = new ArrayList<Pago>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Expedidor> getExpedidores() {
		return expedidores;
	}

	public void setExpedidores(Collection<Expedidor> expedidores) {
		this.expedidores = expedidores;
	}
	
	public Collection<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Collection<Viaje> viajes) {
		this.viajes = viajes;
	}

	public Collection<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(Collection<Pago> pagos) {
		this.pagos = pagos;
	}
	
	

	/*public Collection<Email> getInvitaciones() {
		return invitaciones;
	}

	public void setInvitaciones(Collection<Email> invitaciones) {
		this.invitaciones = invitaciones;
	}*/
	
	
	

}
