package com.rest.transport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.Rol;
import com.rest.transport.repository.RolRepository;

@Service
public class RolService {
	
	@Autowired
	RolRepository rolRepository;
	
	public List<Rol> findAll(){
		return rolRepository.findAll();
	}
	
}
