package com.rest.transport.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.Pais;
import com.rest.transport.repository.PaisRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;

	
	@GetMapping("/paises")
    public List<Pais> getPaises() {
        return (List<Pais>) paisRepository.findAll();
    }
	
	@PostMapping("/paises")
    void addPais(@RequestBody Pais pais) {
        paisRepository.save(pais);
    }
}
