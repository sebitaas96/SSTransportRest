package com.rest.transport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.Direccion;
import com.rest.transport.repository.DireccionRepository;


@Service
public class DireccionService {

	@Autowired
	DireccionRepository direccionRepository;
	
	public List<Direccion> findAll(){
		return direccionRepository.findAll();
	}
	
	
}
