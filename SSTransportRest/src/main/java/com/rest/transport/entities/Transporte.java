package com.rest.transport.entities;

import java.util.ArrayList;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Transporte extends Empresa {
	
	@OneToMany(mappedBy = "conductorDeTransporte", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Conductor> conductores;
	
	@OneToMany(mappedBy = "camionDeTransporte", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Camion> camiones;
	
	@OneToMany(mappedBy = "remolqueDeTransporte", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Remolque> remolques;
	
	@OneToMany(mappedBy = "pagoDeTransporte", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Pago> pagos;
	
	@OneToMany(mappedBy = "viajeDeTransporte", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Viaje> viajes;
	

	
	public Transporte() {
		super();
		this.conductores = new ArrayList<Conductor>();
		this.camiones = new ArrayList<Camion>();
		this.remolques = new ArrayList<Remolque>();
		this.pagos = new ArrayList<Pago>();
		this.viajes = new ArrayList<Viaje>();
	}


	

	public Transporte(String nombre, String documento, String email, String telefono,int tipoEmpresa, Direccion residenteDeDireccion,
			Provincia operadorDeProvincia, Rol empresaDeRol ,CuentaBancaria cuentaBancaria) {
		super(nombre, documento, email, telefono, residenteDeDireccion, operadorDeProvincia, empresaDeRol,cuentaBancaria);
		this.conductores = new ArrayList<Conductor>();
		this.camiones = new ArrayList<Camion>();
		this.remolques = new ArrayList<Remolque>();
		this.pagos = new ArrayList<Pago>();
		this.viajes = new ArrayList<Viaje>();
		
	}




	public Collection<Conductor> getConductores() {
		return conductores;
	}

	public void setConductores(Collection<Conductor> conductores) {
		this.conductores = conductores;
	}

	public Collection<Camion> getCamiones() {
		return camiones;
	}

	public void setCamiones(Collection<Camion> camiones) {
		this.camiones = camiones;
	}

	public Collection<Remolque> getRemolques() {
		return remolques;
	}

	public void setRemolques(Collection<Remolque> remolques) {
		this.remolques = remolques;
	}

	public Collection<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(Collection<Pago> pagos) {
		this.pagos = pagos;
	}

	public Collection<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Collection<Viaje> viajes) {
		this.viajes = viajes;
	}


	
	
	
	

}
