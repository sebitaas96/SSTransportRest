package com.rest.transport.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.EstadoPago;
import com.rest.transport.repository.EstadoPagoRepository;

@Service
public class EstadoPagoService {

	@Autowired
	EstadoPagoRepository estadoPagoRepository;
	
	
	public void save(EstadoPago estadoPago) {
		estadoPagoRepository.save(estadoPago);
	}
	
	public Collection<EstadoPago>findAll(){
		return estadoPagoRepository.findAll();
	}
	

}
