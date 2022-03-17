package com.rest.transport.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.Provincia;
import com.rest.transport.repository.ProvinciaRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinciaController {
	
	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	@GetMapping("/provincias")
    public List<Provincia> getProvincias() {
        return (List<Provincia>) provinciaRepository.findAll();
    }
	
	@PostMapping("/provincias")
    void addProvincia(@RequestBody Provincia provincia) {
		provinciaRepository.save(provincia);
    }

}
