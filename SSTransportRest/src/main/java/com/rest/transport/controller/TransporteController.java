package com.rest.transport.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.dto.Mensaje;
import com.rest.transport.entities.Transporte;
import com.rest.transport.security.dto.NuevoUsuario;
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
	
	@PutMapping("/updateTransporte")
	public ResponseEntity<?>updateTransporte(@RequestBody Transporte transporte){
		try { 
			transporteService.updateTransporte(transporte);
			return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	

	
}
