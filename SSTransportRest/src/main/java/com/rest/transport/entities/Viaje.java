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

@Entity
public class Viaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String vId;
	
	private float precio;
	
	private Date fHoraInicio;
	
	private Date fHoraFin;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Direccion recogidaDeDireccion;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Direccion entregaDeDireccion;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Transporte viajeDeTransporte;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Conductor viajeDeConductor;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Camion viajeDeCamion;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private TipoRemolque viajeDeTipoRemolque;
	
	@OneToOne
	private Pago pago;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Estado viajeDeEstado;
	
	public Viaje() {}

	public Viaje(String vId, float precio, Date fHoraInicio, Date fHoraFin, Direccion recogidaDeDireccion,
			Direccion entregaDeDireccion, Transporte viajeDeTransporte, Conductor viajeDeConductor,
			Camion viajeDeCamion, TipoRemolque viajeDeTipoRemolque, Pago pago, Estado viajeDeEstado) {
		super();
		this.vId = vId;
		this.precio = precio;
		this.fHoraInicio = fHoraInicio;
		this.fHoraFin = fHoraFin;
		this.recogidaDeDireccion = recogidaDeDireccion;
		this.recogidaDeDireccion.getRecogidas().add(this);
		this.entregaDeDireccion = entregaDeDireccion;
		this.entregaDeDireccion.getEntregas().add(this);
		this.viajeDeTransporte = viajeDeTransporte;
		this.viajeDeTransporte.getViajes().add(this);
		this.viajeDeConductor = viajeDeConductor;
		this.viajeDeConductor.getViajes().add(this);
		this.viajeDeCamion = viajeDeCamion;
		this.viajeDeCamion.getViajes().add(this);
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

	public String getvId() {
		return vId;
	}

	public void setvId(String vId) {
		this.vId = vId;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
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

	public Transporte getViajeDeTransporte() {
		return viajeDeTransporte;
	}

	public void setViajeDeTransporte(Transporte viajeDeTransporte) {
		this.viajeDeTransporte = viajeDeTransporte;
		this.viajeDeTransporte.getViajes().add(this);
	}

	public Conductor getViajeDeConductor() {
		return viajeDeConductor;
	}

	public void setViajeDeConductor(Conductor viajeDeConductor) {
		this.viajeDeConductor = viajeDeConductor;
		this.viajeDeConductor.getViajes().add(this);
	}

	public Camion getViajeDeCamion() {
		return viajeDeCamion;
	}

	public void setViajeDeCamion(Camion viajeDeCamion) {
		this.viajeDeCamion = viajeDeCamion;
		this.viajeDeCamion.getViajes().add(this);
	}

	public TipoRemolque getViajeDeTipoRemolque() {
		return viajeDeTipoRemolque;
	}

	public void setViajeDeTipoRemolque(TipoRemolque viajeDeTipoRemolque) {
		this.viajeDeTipoRemolque = viajeDeTipoRemolque;
		this.viajeDeTipoRemolque.getViajes().add(this);
	}

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
