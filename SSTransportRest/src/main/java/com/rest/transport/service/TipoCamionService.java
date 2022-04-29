package com.rest.transport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.TipoCamion;
import com.rest.transport.repository.TipoCamionRepository;

@Service
public class TipoCamionService {

	@Autowired
	TipoCamionRepository tipoCamionRepository;
	
	
	public void save(TipoCamion tipoCamion) {
		tipoCamionRepository.save(tipoCamion);
	}
	
}
