package com.rest.transport.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String pId;
	
	private Date fFactura;
	
	private Date fPago;
	
	private boolean estado;
	
	private float importe;
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Transporte pagoDeTransporte;
	
	@OneToOne(mappedBy="pago")
	@JsonBackReference
	private Viaje viaje;
	
	public Pago() {}

	public Pago(String pId, Date fFactura, Date fPago, boolean estado, float importe, Transporte pagoDeTransporte,
			Viaje viaje) {
		super();
		this.pId = pId;
		this.fFactura = fFactura;
		this.fPago = fPago;
		this.estado = estado;
		this.importe = importe;
		this.pagoDeTransporte = pagoDeTransporte;
		this.pagoDeTransporte.getPagos().add(this);
		this.viaje = viaje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public Date getfFactura() {
		return fFactura;
	}

	public void setfFactura(Date fFactura) {
		this.fFactura = fFactura;
	}

	public Date getfPago() {
		return fPago;
	}

	public void setfPago(Date fPago) {
		this.fPago = fPago;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Transporte getPagoDeTransporte() {
		return pagoDeTransporte;
	}

	public void setPagoDeTransporte(Transporte pagoDeTransporte) {
		this.pagoDeTransporte = pagoDeTransporte;
		this.pagoDeTransporte.getPagos().add(this);
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}
	
	
	
	
	
}
