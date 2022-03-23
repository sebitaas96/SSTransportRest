package com.rest.transport.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.Localidad;
import com.rest.transport.service.LocalidadService;


@RestController
@RequestMapping("/localidad")
@CrossOrigin(origins = "http://localhost:4200")
public class LocalidadController {
	
	@Autowired
	private LocalidadService localidadService;
	
	@GetMapping
    public List<Localidad> r() {
        return (List<Localidad>) localidadService.findAll();
    }
	

}
