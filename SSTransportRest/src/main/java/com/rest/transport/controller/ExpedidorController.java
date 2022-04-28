package com.rest.transport.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.dto.CambiarEstado;
import com.rest.transport.dto.Mensaje;
import com.rest.transport.entities.Expedidor;
import com.rest.transport.service.ExpedidorService;

@RestController
@RequestMapping("/expedidor")
@CrossOrigin(origins = "http://localhost:4200")
public class ExpedidorController {

	@Autowired
	ExpedidorService expedidorService;
	
	@GetMapping("/{nombreUsuario}/ExpedidorNombre")
	public Expedidor findByNombreExpedidor(@PathVariable("nombreUsuario") String nombreUsuario){
		return  expedidorService.findByNombreConductor(nombreUsuario); 
	}
	
	@GetMapping("/{idPorte}/findAll")
	public Collection<Expedidor> findByIdUsuario(@PathVariable("idPorte") Long idPorte){
		return  expedidorService.findAll(idPorte);
	}
	
	@PutMapping("/updateExpedidor")
	public ResponseEntity<?>updateExpedidor(@RequestBody Expedidor expedidor){
		try { 
			expedidorService.updateExpedidor(expedidor);
			return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	
	 @DeleteMapping("/{idExpedidor}/deleteExpedidor")
	public ResponseEntity<?>delete(@PathVariable("idExpedidor") Long idExpedidor){
		try { 
			expedidorService.deleteExpedidor(idExpedidor);
			return new ResponseEntity(new Mensaje("Expedidor eliminado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	 
		@PutMapping("/cambiarEstado")
		public ResponseEntity<?>cambiarEstadoExpedidor(@RequestBody CambiarEstado cambiarEstado){
			try { 
				expedidorService.CambiarEstado(cambiarEstado);
				return new ResponseEntity(new Mensaje("Expedidor activado"), HttpStatus.CREATED);
			}
			catch(Exception e){
				return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
			}
		}
	
	
}
