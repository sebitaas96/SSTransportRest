package com.rest.transport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.Localidad;
import com.rest.transport.repository.LocalidadRepository;


@Service
public class LocalidadService {

	@Autowired
	LocalidadRepository localidadRepository;
	
	public List<Localidad> findAll(){
		return localidadRepository.findAll();
		
	}
	
}
