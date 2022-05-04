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
import com.rest.transport.entities.Remolque;
import com.rest.transport.service.RemolqueService;

@RestController
@RequestMapping("/remolque")
@CrossOrigin(origins = "http://localhost:4200")
public class RemolqueController {

	@Autowired
	RemolqueService remolqueService;
	
	@PostMapping("/nuevo")
	public ResponseEntity<?>nuevo(@RequestBody Remolque remolque, BindingResult bindingResult) {
		if(remolqueService.existsByMatricula(remolque.getMatricula())) {
			return new ResponseEntity(new Mensaje("Ya hay un remolque con esta matricula registrado"), HttpStatus.BAD_REQUEST);
		}
		
		try {
			remolqueService.save(remolque);
		}
		catch(Exception e) {
			return new ResponseEntity(new Mensaje("Ha ocurrido un error"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Mensaje("Remolque añadido"), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{idEmpresa}/findAll")
	public Collection<Remolque>findAll(@PathVariable("idEmpresa") Long idEmpresa){
		return this.remolqueService.findAll(idEmpresa);
	}
	
}
