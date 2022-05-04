package com.rest.transport.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.Camion;
import com.rest.transport.repository.CamionRepository;

@Service
public class CamionService {

	@Autowired
	CamionRepository camionRepository;
	
	
	public boolean existsByMatricula(String matricula) {
		return camionRepository.existsByMatricula(matricula);
	}
	
	public void save(Camion camion){
		camionRepository.save(camion);
	}
	
	public Collection<Camion>findAll(Long idEmpresa){
		return camionRepository.findByCamionDeTransporteId(idEmpresa);
		
	}
}
