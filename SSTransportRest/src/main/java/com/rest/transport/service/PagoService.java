package com.rest.transport.service;

import java.util.Collection;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.dto.PagosEstado;
import com.rest.transport.entities.EstadoPago;
import com.rest.transport.entities.Pago;
import com.rest.transport.entities.Viaje;
import com.rest.transport.repository.EstadoPagoRepository;
import com.rest.transport.repository.PagoRepository;
import com.rest.transport.repository.ViajeRepository;

@Service
public class PagoService {

	@Autowired
	PagoRepository pagoRepository;
	
	@Autowired
	ViajeRepository viajeRepository;
	
	@Autowired
	EstadoPagoRepository estadoPagoRepository;
	
	public void nuevoPago(Long idViaje) {
		Viaje v = viajeRepository.getById(idViaje);		
		EstadoPago e = estadoPagoRepository.findByNombre("Pendiente");
		Pago p = new Pago();
		p.setfFactura(v.getfHoraFin());
		p.setImporte(v.getPrecio());
		p.setPagoDeTransporte(v.getViajeDeTransporte());
		p.setPagoDePorte(v.getViajeDePorte());
		p.setPagoDeEstadoPago(e);
		p.setViaje(v);
		Pago p2 = pagoRepository.save(p);
		v.setPago(p2);
		viajeRepository.save(v);
	}
	
	public void realizarPago(Long pagoId) {
		EstadoPago e = estadoPagoRepository.findByNombre("Pagado");
		Pago p = pagoRepository.getById(pagoId);
		p.setfPago(new Date());
		p.setPagoDeEstadoPago(e);
		pagoRepository.save(p);
	}
	
	
	public void rechazarPago(Long pagoId) {
		EstadoPago e = estadoPagoRepository.findByNombre("Rechazado");
		Pago p = pagoRepository.getById(pagoId);
		p.setPagoDeEstadoPago(e);
		pagoRepository.save(p);
	}
	
	public void disputarPago(Long pagoId) {
		EstadoPago e = estadoPagoRepository.findByNombre("Disputando");
		Pago p = pagoRepository.getById(pagoId);
		p.setPagoDeEstadoPago(e);
		pagoRepository.save(p);
	}
	
	public Collection<Pago>findAllPorte(Long idPorte){
		return pagoRepository.findByPagoDePorteId(idPorte);
		
	}
	
	public Collection<Pago>findAllTransporte(Long idTransporte){
		return pagoRepository.findByPagoDeTransporteId(idTransporte);
		
	}
	
	public Optional<Pago> findPago(Long idPago){
		return pagoRepository.findById(idPago);
		
	}
	
	public Collection<Pago>findAllFiltrado(PagosEstado pagosEstado){
		EstadoPago e = estadoPagoRepository.findByNombre(pagosEstado.getEstadoPago());
		return pagoRepository.findByPagoDeEstadoPagoId(e.getId());
	}
	
}
