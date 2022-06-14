package com.rest.transport.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.Gravedad;
import com.rest.transport.service.GravedadService;

@RestController
@RequestMapping("/gravedad")
@CrossOrigin(origins = "http://localhost:4200")
public class GravedadController {

	@Autowired
	GravedadService gravedadService;
	
	@GetMapping("/findAll")
	public Collection<Gravedad> tiposGravedad(){
		return gravedadService.findAll() ;
	}
	
}
