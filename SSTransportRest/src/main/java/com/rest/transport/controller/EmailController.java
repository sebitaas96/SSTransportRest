package com.rest.transport.controller;


import java.util.Map;

import java.util.Optional;

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

import com.rest.transport.entities.Email;
import com.rest.transport.service.EmailService;
import com.rest.transport.util.DeOfuscarUrl;
import com.rest.transport.dto.Mensaje;



@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "http://localhost:4200")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/nuevo")
	public ResponseEntity<?>nuevo(@RequestBody Email email , BindingResult bindingResult) {
		if(emailService.existsByInvitacionDeTransporteIdAndDestinatario(email.getInvitacionDeTransporte().getId(), email.getDestinatario())) {
			return new ResponseEntity(new Mensaje("Ya has enviado una invitacion a este correo"), HttpStatus.BAD_REQUEST);
		}
		DeOfuscarUrl de = new DeOfuscarUrl(); 
		email.setUrl(de.encodeToBase64(email.getUrl()));
		
		emailService.sendSimpleEmail(email);
		return new ResponseEntity(new Mensaje("Invitacion enviada"), HttpStatus.CREATED);
	}
	
	@GetMapping("/{mensaje}/deofuscar")
	public Optional<Email> deofuscar(@PathVariable("mensaje") String mensaje){
		  DeOfuscarUrl de = new DeOfuscarUrl();
		  Map<String ,String> datos = de.deofuscarUrl(mensaje);
		  System.out.println(datos.get("q"));
		  System.out.println(datos.get("e"));
		  return emailService.findByIdEmpresaEmail(Long.parseLong(datos.get("q")) , datos.get("e")); 
	}

}
