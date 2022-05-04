package com.rest.transport.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.dto.Mensaje;
import com.rest.transport.entities.Camion;
import com.rest.transport.service.CamionService;

@RestController
@RequestMapping("/camion")
@CrossOrigin(origins = "http://localhost:4200")
public class CamionController {
	
	@Autowired
	CamionService camionService;

	@PostMapping("/nuevo")
	public ResponseEntity<?>nuevo(@RequestBody Camion camion, BindingResult bindingResult) {
		if(camionService.existsByMatricula(camion.getMatricula())) {
			return new ResponseEntity(new Mensaje("Ya hay una camion con esta matricula registrado"), HttpStatus.BAD_REQUEST);
		}
		
		try {
			camionService.save(camion);
		}
		catch(Exception e) {
			return new ResponseEntity(new Mensaje("Ha ocurrido un error"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Mensaje("Camion añadido"), HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/{idEmpresa}/findAll")
	public Collection<Camion>findAll(@PathVariable("idEmpresa") Long idEmpresa){
		return this.camionService.findAll(idEmpresa);
	}
	
}
