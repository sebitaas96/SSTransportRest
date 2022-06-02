package com.rest.transport.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.Estado;
import com.rest.transport.service.EstadoService;

@RestController
@RequestMapping("/estado")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoController {

	@Autowired
	EstadoService estadoService;
	
	@GetMapping("/findAll")
	public Collection<Estado> tiposEstados(){
		return estadoService.findAll() ;
	}
	
}
