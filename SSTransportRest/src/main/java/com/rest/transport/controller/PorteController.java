package com.rest.transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.dto.Mensaje;
import com.rest.transport.entities.Porte;
import com.rest.transport.entities.Transporte;
import com.rest.transport.service.PorteService;

@RestController
@RequestMapping("/porte")
@CrossOrigin(origins = "http://localhost:4200")
public class PorteController {
	
	@Autowired
	PorteService porteService;

	
	@GetMapping("/{nombreUsuario}/Empresa")
	public Porte findByNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario){
		return  porteService.findByNombreUsuario(nombreUsuario); 
	}
	
	@PutMapping("/updatePorte")
	public ResponseEntity<?>updatePorte(@RequestBody Porte porte){
		try { 
			porteService.updatePorte(porte);
			return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	
}
