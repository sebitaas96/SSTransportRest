package com.rest.transport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.Pais;
import com.rest.transport.repository.PaisRepository;

@Service
public class PaisService {
	
	@Autowired
	PaisRepository paisRepository;
	
	public List<Pais> findAll(){
		return paisRepository.findAll();
	}

}
