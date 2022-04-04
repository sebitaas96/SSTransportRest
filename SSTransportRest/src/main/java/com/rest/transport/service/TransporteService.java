package com.rest.transport.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.Transporte;
import com.rest.transport.repository.DireccionRepository;
import com.rest.transport.repository.TransporteRepository;


@Service
public class TransporteService {
	
	@Autowired
	TransporteRepository transporteRepository;
	
	@Autowired
	DireccionRepository direccionRepository;
	
	public Transporte save(Transporte transporte) {
		direccionRepository.save(transporte.getResidenteDeDireccion());
		return transporteRepository.save(transporte);
	}
	
	public List<Transporte> findAll() {
		return null;
	}
	
}
