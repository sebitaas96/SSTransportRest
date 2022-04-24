package com.rest.transport.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.Conductor;
import com.rest.transport.service.ConductorService;

@RestController
@RequestMapping("/conductor")
@CrossOrigin(origins = "http://localhost:4200")
public class ConductorController {

	@Autowired
	ConductorService conductorService;
	
	@GetMapping("/{idTransporte}/findAll")
	public Collection<Conductor> findByIdUsuario(@PathVariable("idTransporte") Long idTransporte){
		return  conductorService.findAll(idTransporte);
	}
	
}
