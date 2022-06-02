package com.rest.transport.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.Estado;
import com.rest.transport.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	EstadoRepository estadoRepository;
	
	
	public void save(Estado estado) {
		estadoRepository.save(estado);
	}
	
	public Collection<Estado> findAll(){
		return estadoRepository.findAll();
	}
}
