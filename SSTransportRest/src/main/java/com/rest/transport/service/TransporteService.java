package com.rest.transport.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.Transporte;

import com.rest.transport.repository.TransporteRepository;


@Service
public class TransporteService {
	
	@Autowired
	TransporteRepository transporteRepository;
	
	public Transporte findByNombreUsuario(String nombreUsuario) {
		return  transporteRepository.findByNombreUsuario(nombreUsuario);
	}
	
}
