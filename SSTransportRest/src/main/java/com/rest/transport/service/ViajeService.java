package com.rest.transport.service;

import java.util.Collection;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.dto.ReservarViaje;
import com.rest.transport.entities.Conductor;
import com.rest.transport.entities.Direccion;
import com.rest.transport.entities.Estado;
import com.rest.transport.entities.Transporte;
import com.rest.transport.entities.Viaje;
import com.rest.transport.repository.ConductorRepository;
import com.rest.transport.repository.DireccionRepository;
import com.rest.transport.repository.EstadoRepository;
import com.rest.transport.repository.TransporteRepository;
import com.rest.transport.repository.ViajeRepository;


@Service
public class ViajeService {

	@Autowired
	ViajeRepository viajeRepository;
	
	@Autowired
	DireccionRepository direccionRepository;
	
	@Autowired
	TransporteRepository transporteRepository;
	
	@Autowired
	ConductorRepository conductoRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public void save(Viaje viaje) {
		System.out.println("Guardando viaje");
		Direccion recogida =  new Direccion(
				viaje.getRecogidaDeDireccion().getTipo(),
				viaje.getRecogidaDeDireccion().getNombre(),
				viaje.getRecogidaDeDireccion().getNumero(),
				viaje.getRecogidaDeDireccion().getDireccionDeLocalidad()
				);
		Direccion recogidaS =direccionRepository.saveAndFlush(recogida);
		Direccion entrega =  new Direccion(
				viaje.getEntregaDeDireccion().getTipo(),
				viaje.getEntregaDeDireccion().getNombre(),
				viaje.getEntregaDeDireccion().getNumero(),
				viaje.getEntregaDeDireccion().getDireccionDeLocalidad()
				);
		Direccion entregaS = direccionRepository.saveAndFlush(entrega);
		viaje.setRecogidaDeDireccion(recogidaS);
		viaje.setEntregaDeDireccion(entregaS);
		try {
			viajeRepository.save(viaje);	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public Collection<Viaje>findAll(Long idEmpresa){
		return viajeRepository.findByViajeDePorteId(idEmpresa);
		
	}
	
	
	public Collection<Viaje>findAllPanel(){
		Long estado = (long) 1;
		return viajeRepository.findByViajeDeEstadoId(estado);
		
	}
	
	public Collection<Viaje>findAllExpedidor(Long idExpedidor){
		return viajeRepository.findByViajeDeExpedidorId(idExpedidor);
		
	}
	
	public Optional<Viaje> findViajeId(Long idViaje) {
		return viajeRepository.findById(idViaje);
	}
	
	public void reservarViaje(ReservarViaje reservarViaje) throws Exception {
		Viaje v = viajeRepository.getById(reservarViaje.getIdViaje());
		if(v.getViajeDeEstado().getNombre().equals("Expedido")) {
			Transporte t = transporteRepository.getById(reservarViaje.getTransporte().getId());
			v.setViajeDeTransporte(t);
			if(reservarViaje.getConductor() !=null) {
				Conductor c = conductoRepository.getById(reservarViaje.getConductor().getId());
				v.setViajeDeConductor(c);
			}
			Estado e = estadoRepository.findByNombre("Reservado");
			v.setViajeDeEstado(e);
			viajeRepository.save(v);
		}
		else {
			throw new Exception("El viaje ya no esta disponible");
		}
		
	}
	
	public void caducarEstado(Viaje v) {
		Estado e = new Estado();
		e.setId((long) 4);
		e.setNombre("Caducado");
		v.setViajeDeEstado(e);
		viajeRepository.save(v);
	}
	
	public void cancelarViaje(Long idViaje) {
		Estado e = estadoRepository.findByNombre("Caducado");
		Viaje v = viajeRepository.getById(idViaje);
		v.setViajeDeEstado(e);
		viajeRepository.save(v);
	}
	
}
