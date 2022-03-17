package com.rest.transport.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.Localidad;
import com.rest.transport.repository.LocalidadRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LocalidadController {
	
	@Autowired
	private LocalidadRepository localidadRepository;
	
	@GetMapping("/localidades")
    public List<Localidad> getLocalidades() {
        return (List<Localidad>) localidadRepository.findAll();
    }
	
	@PostMapping("/localidades")
    void addLocalidad(@RequestBody Localidad localidad) {
		localidadRepository.save(localidad);
    }

}
