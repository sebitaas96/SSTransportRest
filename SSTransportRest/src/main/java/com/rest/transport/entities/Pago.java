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
	
	private Date fFactura;
	
	@Column(nullable = true)
	private Date fPago;
	
	private float importe;
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Transporte pagoDeTransporte;
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Porte pagoDePorte;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private EstadoPago pagoDeEstadoPago;
	
	@OneToOne(mappedBy="pago")
	@JsonBackReference
	private Viaje viaje;
	
	
	
	public Pago() {}

	public Pago( Date fFactura, Date fPago,  float importe, Transporte pagoDeTransporte,
			Porte pagoDePorte,
			EstadoPago pagoDeEstadoPago, Viaje viaje) {
		super();
		this.fFactura = fFactura;
		this.fPago = fPago;
		this.importe = importe;
		this.pagoDeTransporte = pagoDeTransporte;
		this.pagoDeTransporte.getPagos().add(this);
		this.pagoDePorte = pagoDePorte;
		this.pagoDePorte.getPagos().add(this);
		this.pagoDeEstadoPago = pagoDeEstadoPago;
		this.pagoDeEstadoPago.getPagos().add(this);
		this.viaje = viaje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	

	public Porte getPagoDePorte() {
		return pagoDePorte;
	}

	public void setPagoDePorte(Porte pagoDePorte) {
		this.pagoDePorte = pagoDePorte;
		this.pagoDePorte.getPagos().add(this);
	}

	public EstadoPago getPagoDeEstadoPago() {
		return pagoDeEstadoPago;
	}

	public void setPagoDeEstadoPago(EstadoPago pagoDeEstadoPago) {
		this.pagoDeEstadoPago = pagoDeEstadoPago;
		this.pagoDeEstadoPago.getPagos().add(this);
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}
	
	
	
	
	
}
