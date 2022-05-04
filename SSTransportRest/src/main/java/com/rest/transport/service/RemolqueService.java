package com.rest.transport.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.Remolque;
import com.rest.transport.repository.RemolqueRepository;

@Service
public class RemolqueService {

	@Autowired
	RemolqueRepository remolqueRepository;
	
	
	public boolean existsByMatricula(String matricula) {
		return remolqueRepository.existsByMatricula(matricula);
	}
	
	public void save(Remolque remolque) {
		remolqueRepository.save(remolque);
	}
	
	public Collection<Remolque>findAll(Long idEmpresa){
		return remolqueRepository.findByRemolqueDeTransporteId(idEmpresa);
		
	}
}
