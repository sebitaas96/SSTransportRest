package com.rest.transport.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.TipoCamion;
import com.rest.transport.service.TipoCamionService;

@RestController
@RequestMapping("/tipoCamion")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoCamionController {
	
	@Autowired
	TipoCamionService tipoCamionService;
	
	@GetMapping("/findAll")
	public Collection<TipoCamion> tiposCamion(){
		return tipoCamionService.findAll() ;
	}
}
