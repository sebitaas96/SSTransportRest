package com.rest.transport.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.rest.transport.entities.Direccion;
import com.rest.transport.entities.Viaje;
import com.rest.transport.repository.DireccionRepository;
import com.rest.transport.repository.ViajeRepository;

@Service
public class ViajeService {

	@Autowired
	ViajeRepository viajeRepository;
	
	@Autowired
	DireccionRepository direccionRepository;
	
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
	
	public Collection<Viaje>findAllExpedidor(Long idExpedidor){
		return viajeRepository.findByViajeDeExpedidorId(idExpedidor);
		
	}
	
}
