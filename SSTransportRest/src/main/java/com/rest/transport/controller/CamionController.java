package com.rest.transport.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.dto.CambiarEstado;
import com.rest.transport.dto.Mensaje;
import com.rest.transport.dto.asignacionEquipo;
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
	
	@GetMapping("/{idConductor}/findAllConductor")
	public Collection<Camion>findAllConductor(@PathVariable("idConductor") Long idConductor){
		return this.camionService.findAllConductor(idConductor);
	}
	
	@PutMapping("/cambiarEstado")
	public ResponseEntity<?>cambiarEstadoCamion(@RequestBody CambiarEstado cambiarEstado){
		try { 
			camionService.CambiarEstado(cambiarEstado);
			return new ResponseEntity(new Mensaje("Estado cambiado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/cambiarConductor")
	public ResponseEntity<?>cambiarConductorCamion(@RequestBody asignacionEquipo asignacion){
		try { 
			camionService.cambiarConductor(asignacion);
			return new ResponseEntity(new Mensaje("Conductor asignado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	 @DeleteMapping("/{idCamion}/deleteCamion")
	public ResponseEntity<?>delete(@PathVariable("idCamion") Long idCamion){
		try { 
			camionService.deleteCamion(idCamion);
			return new ResponseEntity(new Mensaje("Camion eliminado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	
}
