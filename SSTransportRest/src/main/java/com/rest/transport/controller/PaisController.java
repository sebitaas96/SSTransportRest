package com.rest.transport.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.Pais;
import com.rest.transport.service.PaisService;


@RestController
@RequestMapping("/pais")
@CrossOrigin(origins = "http://localhost:4200")
public class PaisController {
	
	@Autowired
	private PaisService paisService;

	
	@GetMapping
    public List<Pais> r() {
        return paisService.findAll();
    }
	
}
