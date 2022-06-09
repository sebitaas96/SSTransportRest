package com.rest.transport.dto;

import java.util.Date;

import javax.persistence.Column;

import com.rest.transport.entities.Conductor;
import com.rest.transport.entities.Direccion;
import com.rest.transport.entities.Estado;
import com.rest.transport.entities.Expedidor;
import com.rest.transport.entities.Pago;
import com.rest.transport.entities.Porte;
import com.rest.transport.entities.TipoCamion;
import com.rest.transport.entities.TipoRemolque;
import com.rest.transport.entities.Transporte;

public class NuevoViaje {
	
	@Column(nullable=false)
	private String descripcion;
	
	@Column(nullable=false)
	private float precio;
	
	@Column(nullable=false)
	private int distancia;
	
	@Column(nullable=false)
	private int tiempo;
	
	@Column(nullable=false)
	private Date fHoraInicio;
	
	@Column(nullable=false)
	private Date fHoraFin;
	
	@Column(nullable=false)
	private Direccion recogidaDeDireccion;
	
	@Column(nullable=false)
	private Direccion entregaDeDireccion;
	
	@Column(nullable=true)
	private Transporte viajeDeTransporte;
	
	@Column(nullable=false)
	private Porte viajeDePorte;
	
	@Column(nullable=true)
	private Expedidor viajeDeExpedidor;
	
	@Column(nullable=true)
	private Conductor viajeDeConductor;
	
	@Column(nullable=false)
	private TipoCamion viajeDeTipoCamion;
	
	@Column(nullable=true)
	private TipoRemolque viajeDeTipoRemolque;
	
	@Column(nullable=true)
	private Pago pago;
	
	@Column(nullable=false)
	private Estado viajeDeEstado;

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
	}

	public Direccion getEntregaDeDireccion() {
		return entregaDeDireccion;
	}

	public void setEntregaDeDireccion(Direccion entregaDeDireccion) {
		this.entregaDeDireccion = entregaDeDireccion;
	}

	public Transporte getViajeDeTransporte() {
		return viajeDeTransporte;
	}

	public void setViajeDeTransporte(Transporte viajeDeTransporte) {
		this.viajeDeTransporte = viajeDeTransporte;
	}

	public Porte getViajeDePorte() {
		return viajeDePorte;
	}

	public void setViajeDePorte(Porte viajeDePorte) {
		this.viajeDePorte = viajeDePorte;
	}

	public Expedidor getViajeDeExpedidor() {
		return viajeDeExpedidor;
	}

	public void setViajeDeExpedidor(Expedidor viajeDeExpedidor) {
		this.viajeDeExpedidor = viajeDeExpedidor;
	}

	public Conductor getViajeDeConductor() {
		return viajeDeConductor;
	}

	public void setViajeDeConductor(Conductor viajeDeConductor) {
		this.viajeDeConductor = viajeDeConductor;
	}

	public TipoCamion getViajeDeTipoCamion() {
		return viajeDeTipoCamion;
	}

	public void setViajeDeTipoCamion(TipoCamion viajeDeTipoCamion) {
		this.viajeDeTipoCamion = viajeDeTipoCamion;
	}

	public TipoRemolque getViajeDeTipoRemolque() {
		return viajeDeTipoRemolque;
	}

	public void setViajeDeTipoRemolque(TipoRemolque viajeDeTipoRemolque) {
		this.viajeDeTipoRemolque = viajeDeTipoRemolque;
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
	}
	
	
	
}
