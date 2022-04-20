package com.rest.transport.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{nombreUsuario}/Empresa")
	public String findByNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario){
		Transporte transporte = transporteService.findByNombreUsuario(nombreUsuario); 
		return transporte.getNombre();
	}
	
}
