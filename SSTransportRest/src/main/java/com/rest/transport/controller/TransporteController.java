package com.rest.transport.controller;



import java.util.Optional;

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
	public Transporte findByNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario){
		return  transporteService.findByNombreUsuario(nombreUsuario); 
	}
	
	@GetMapping("/{idUsuario}/EmpresaId")
	public Optional<Transporte> findByIdUsuario(@PathVariable("idUsuario") Long idUsuario){
		return  transporteService.findByIdUsuario(idUsuario); 
	}
	
}
