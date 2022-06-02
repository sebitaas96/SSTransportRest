package com.rest.transport.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Viaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descripcion;
	
	private float precio;
	
	private int distancia;
	
	private int tiempo;
	
	private Date fHoraInicio;
	
	private Date fHoraFin;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Direccion recogidaDeDireccion;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Direccion entregaDeDireccion;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne(optional=true)
	private Transporte viajeDeTransporte;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Porte viajeDePorte;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne(optional=true)
	private Expedidor viajeDeExpedidor;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne(optional=true)
	private Conductor viajeDeConductor;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private TipoCamion viajeDeTipoCamion;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne(optional=true)
	private TipoRemolque viajeDeTipoRemolque;
	
	@OneToOne(optional=true)
	@JsonManagedReference
	private Pago pago;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Estado viajeDeEstado;
	
	public Viaje() {}

	public Viaje(String descripcion , float precio, int distancia, int tiempo, Date fHoraInicio, Date fHoraFin, Direccion recogidaDeDireccion,
			Direccion entregaDeDireccion, Transporte viajeDeTransporte, Expedidor viajeDeExpedidor,Porte viajeDePorte , Conductor viajeDeConductor,
			TipoCamion viajeDeTipoCamion, TipoRemolque viajeDeTipoRemolque, Pago pago, Estado viajeDeEstado) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
		this.distancia = distancia;
		this.tiempo = tiempo;
		this.fHoraInicio = fHoraInicio;
		this.fHoraFin = fHoraFin;
		this.recogidaDeDireccion = recogidaDeDireccion;
		this.recogidaDeDireccion.getRecogidas().add(this);
		this.entregaDeDireccion = entregaDeDireccion;
		this.entregaDeDireccion.getEntregas().add(this);
		this.viajeDeTransporte = viajeDeTransporte;
		this.viajeDeExpedidor = viajeDeExpedidor;
		this.viajeDePorte = viajeDePorte;
		this.viajeDeConductor = viajeDeConductor;
		this.viajeDeTipoCamion = viajeDeTipoCamion;
		this.viajeDeTipoCamion.getViajes().add(this);
		this.viajeDeTipoRemolque = viajeDeTipoRemolque;
		this.viajeDeTipoRemolque.getViajes().add(this);
		this.pago = pago;
		this.viajeDeEstado = viajeDeEstado;
		this.viajeDeEstado.getViajes().add(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public Date getfHoraInicio() {
		return fHoraInicio;
	}

	public void setfHoraInicio(Date fHoraInicio) {
		this.fHoraInicio = fHoraInicio;
	}

	public Date getfHoraFin() {
		return fHoraFin;
	}

	public void setfHoraFin(Date fHoraFin) {
		this.fHoraFin = fHoraFin;
	}

	public Direccion getRecogidaDeDireccion() {
		return recogidaDeDireccion;
	}

	public void setRecogidaDeDireccion(Direccion recogidaDeDireccion) {
		this.recogidaDeDireccion = recogidaDeDireccion;
		this.recogidaDeDireccion.getRecogidas().add(this);
	}

	public Direccion getEntregaDeDireccion() {
		return entregaDeDireccion;
	}

	public void setEntregaDeDireccion(Direccion entregaDeDireccion) {
		this.entregaDeDireccion = entregaDeDireccion;
		this.entregaDeDireccion.getEntregas().add(this);
	}

	
	/*public Transporte getViajeDeTransporte() {
		return viajeDeTransporte;
	}

	public void setViajeDeTransporte(Transporte viajeDeTransporte) {
		this.viajeDeTransporte = viajeDeTransporte;
		this.viajeDeTransporte.getViajes().add(this);
	}*/
	
	

	/*public Expedidor getViajeDeExpedidor() {
		return viajeDeExpedidor;
	}

	public void setViajeDeExpedidor(Expedidor viajeDeExpedidor) {
		this.viajeDeExpedidor = viajeDeExpedidor;
		this.viajeDeExpedidor.getViajes().add(this);
	}*/

/*	public Conductor getViajeDeConductor() {
		return viajeDeConductor;
	}

	public void setViajeDeConductor(Conductor viajeDeConductor) {
		this.viajeDeConductor = viajeDeConductor;
		this.viajeDeConductor.getViajes().add(this);
	}*/


	public Porte getViajeDePorte() {
		return viajeDePorte;
	}

	public void setViajeDePorte(Porte viajeDePorte) {
		this.viajeDePorte = viajeDePorte;
	}

	public TipoCamion getViajeDeTipoCamion() {
		return viajeDeTipoCamion;
	}

	public void setViajeDeTipoCamion(TipoCamion viajeDeTipoCamion) {
		this.viajeDeTipoCamion = viajeDeTipoCamion;
		this.viajeDeTipoCamion.getViajes().add(this);
	}
	
/*	public TipoRemolque getViajeDeTipoRemolque() {
		return viajeDeTipoRemolque;
	}

	public void setViajeDeTipoRemolque(TipoRemolque viajeDeTipoRemolque) {
		this.viajeDeTipoRemolque = viajeDeTipoRemolque;
		this.viajeDeTipoRemolque.getViajes().add(this);
	}*/
	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Estado getViajeDeEstado() {
		return viajeDeEstado;
	}

	public void setViajeDeEstado(Estado viajeDeEstado) {
		this.viajeDeEstado = viajeDeEstado;
		this.viajeDeEstado.getViajes().add(this);
	}
	
	
	
	
	
	
	
	
}
