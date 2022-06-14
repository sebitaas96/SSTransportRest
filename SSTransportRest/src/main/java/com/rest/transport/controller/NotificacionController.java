package com.rest.transport.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.dto.Mensaje;
import com.rest.transport.dto.NuevaNotificacion;
import com.rest.transport.entities.Notificacion;
import com.rest.transport.service.NotificacionService;

@RestController
@RequestMapping("/notificacion")
@CrossOrigin(origins = "http://localhost:4200")
public class NotificacionController {
	
	@Autowired
	NotificacionService notificacionService;
	
	@PostMapping("/addNotificacion")
	public ResponseEntity<?>addNotificacion(@RequestBody NuevaNotificacion nuevaNotificacion){
		try {

			notificacionService.save(nuevaNotificacion);
	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity(new Mensaje("Ha ocurrido un error"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Mensaje("Notificacion añadida"), HttpStatus.CREATED);
	}
	
	@GetMapping("/{idUsuario}/findAll")
	public Collection<Notificacion>findAll(@PathVariable("idUsuario")Long idUsuario){
		return this.notificacionService.findAll(idUsuario);
	}
	
	 @DeleteMapping("/{idNotificacion}/deleteNotificacion")
	public ResponseEntity<?>deleteNotificacion(@PathVariable("idNotificacion") Long idNotificacion){
		try { 
			notificacionService.deleteNotificacion(idNotificacion);
			return new ResponseEntity(new Mensaje(" eliminado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}

}
