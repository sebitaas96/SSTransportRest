package com.rest.transport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.Transporte;
import com.rest.transport.service.TransporteService;

@RestController
@RequestMapping("/transporte")
@CrossOrigin(origins = "http://localhost:4200")
public class TransporteController {

	
	@Autowired
	TransporteService transporteService;
	
	@GetMapping
	public List<Transporte> r(){
		List<Transporte> personas = transporteService.findAll();
		return personas;
	}
	
	 @PostMapping
	public Transporte c(@RequestBody Transporte transporte) {
		System.out.println("he llegado aqui");
		Transporte t = null;
		try {
			t = transporteService.save(transporte);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return t;
	}
}
