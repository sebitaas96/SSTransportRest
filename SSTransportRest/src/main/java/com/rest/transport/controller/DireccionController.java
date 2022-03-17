package com.rest.transport.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.Direccion;
import com.rest.transport.repository.DireccionRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DireccionController {
	
	@Autowired
	private DireccionRepository direccionRepository;
	
	@GetMapping("/direcciones")
    public List<Direccion> getDirecciones() {
        return (List<Direccion>) direccionRepository.findAll();
    }
	
	@PostMapping("/direcciones")
    void addDireccion(@RequestBody Direccion direccion) {
		direccionRepository.save(direccion);
    }

}
