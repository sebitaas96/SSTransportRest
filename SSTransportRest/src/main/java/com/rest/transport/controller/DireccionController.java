package com.rest.transport.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.Direccion;
import com.rest.transport.service.DireccionService;


@RestController
@RequestMapping("/direccion")
@CrossOrigin(origins = "http://localhost:4200")
public class DireccionController {
	
	@Autowired
	private DireccionService direccionService;
	
	@GetMapping
    public List<Direccion> r() {
        return direccionService.findAll();
    }
	
	@PostMapping
    public Direccion c(@RequestBody Direccion direccion) {
		Direccion d = null;
		try {
			direccionService.save(direccion);
		}
		catch(Exception e){
			
		}
		return d;
		
    }

}
