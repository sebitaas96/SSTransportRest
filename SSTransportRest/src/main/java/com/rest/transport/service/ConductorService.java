package com.rest.transport.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.Conductor;
import com.rest.transport.repository.ConductorRepository;

@Service
public class ConductorService {
	@Autowired
	ConductorRepository conductorRepository;
	
	public Collection<Conductor>findAll(Long idTransporte){
		return this.conductorRepository.findByConductorDeTransporteId(idTransporte);
	}
}
