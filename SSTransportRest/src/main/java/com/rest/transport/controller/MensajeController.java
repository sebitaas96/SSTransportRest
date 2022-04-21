package com.rest.transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.Mensaje;
import com.rest.transport.service.EmailService;



@RestController
@RequestMapping("/mensaje")
@CrossOrigin(origins = "http://localhost:4200")
public class MensajeController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/nuevo")
	public void nuevo(@RequestBody Mensaje mensaje , BindingResult bindingResult) {
		System.out.println(mensaje.getDestinatario());
		System.out.println(mensaje.getTexto());
		System.out.println(mensaje.getAsunto());
		emailService.sendSimpleEmail(mensaje.getDestinatario() , mensaje.getTexto() , mensaje.getAsunto());
	}

}
