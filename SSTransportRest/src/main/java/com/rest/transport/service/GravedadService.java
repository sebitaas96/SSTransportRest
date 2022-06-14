package com.rest.transport.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.Gravedad;
import com.rest.transport.repository.GravedadRepository;

@Service
public class GravedadService {
	
	@Autowired
	GravedadRepository gravedadRepository;
	
	public void save(Gravedad gravedad) {
		this.gravedadRepository.saveAndFlush(gravedad);
	}
	
	public Collection<Gravedad> findAll(){
		return this.gravedadRepository.findAll();
	}
	
}
