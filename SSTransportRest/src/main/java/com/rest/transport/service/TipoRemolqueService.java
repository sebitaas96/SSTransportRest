package com.rest.transport.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.TipoRemolque;
import com.rest.transport.repository.TipoRemolqueRepository;

@Service
public class TipoRemolqueService {
	
	@Autowired
	TipoRemolqueRepository tipoRemolqueRepository;
	
	public void save(TipoRemolque tipoRemolque) {
		tipoRemolqueRepository.save(tipoRemolque);
	}
	
	public Collection<TipoRemolque> findAll(){
		return tipoRemolqueRepository.findAll();
	}
}
