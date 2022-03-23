package com.rest.transport.service;

import java.util.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.Localidad;
import com.rest.transport.entities.Provincia;
import com.rest.transport.repository.ProvinciaRepository;

@Service
public class ProvinciaService {

	@Autowired
	ProvinciaRepository provinciaRepository;
	
	public List<Provincia> findAll(){
		return provinciaRepository.findAll();
		
	}
	
	public Collection<Localidad> getLocalidades(Long id) {
		Provincia p = provinciaRepository.getById(id);
		return p.getLocalidades();
}
	
	
}
