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
import com.rest.transport.entities.Viaje;
import com.rest.transport.service.ViajeService;

@RestController
@RequestMapping("/viaje")
@CrossOrigin(origins = "http://localhost:4200")
public class ViajeController {

	@Autowired
	ViajeService viajeService;
	
	@PostMapping("/nuevo")
	public ResponseEntity<?>nuevo(@RequestBody Viaje viaje , BindingResult bindingResult){
		try {
			viajeService.save(viaje);
		}
		catch(Exception e) {
			return new ResponseEntity(new Mensaje("Ha ocurrido un error"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Mensaje("Viaje añadido"), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{idEmpresa}/findAll")
	public Collection<Viaje>findAll(@PathVariable("idEmpresa")Long idEmpresa){
		return this.viajeService.findAll(idEmpresa);
	}
	
	@GetMapping("/{idExpedidor}/findAllExpedidor")
	public Collection<Viaje>findAllExpedidor(@PathVariable("idExpedidor")Long idExpedidor){
		return this.viajeService.findAllExpedidor(idExpedidor);
	}
	
	
}
