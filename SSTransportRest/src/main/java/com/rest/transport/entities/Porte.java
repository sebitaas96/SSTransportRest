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
	
	@OneToMany(mappedBy = "invitacionDePorte", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Email> invitaciones;

	
	
	public Porte() {
		this.expedidores = new ArrayList<Expedidor>();
		this.invitaciones = new ArrayList<Email>();
	}

	public Porte(String nombre, String nombreUsuario, String password, String documento, String email, String telefono,
			Direccion residenteDeDireccion, Provincia operadorDeProvincia, CuentaBancaria cuentaBancaria) {
		super(nombre, nombreUsuario, password, documento, email, telefono, residenteDeDireccion, operadorDeProvincia,
				cuentaBancaria);
		
		this.expedidores = new ArrayList<Expedidor>();
		this.invitaciones = new ArrayList<Email>();
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

	/*public Collection<Email> getInvitaciones() {
		return invitaciones;
	}

	public void setInvitaciones(Collection<Email> invitaciones) {
		this.invitaciones = invitaciones;
	}*/
	
	
	

}
