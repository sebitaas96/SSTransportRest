package com.rest.transport.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.TipoRemolque;
import com.rest.transport.service.TipoRemolqueService;

@RestController
@RequestMapping("/tipoRemolque")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoRemolqueController {

	@Autowired
	TipoRemolqueService tipoRemolqueService;
	
	@GetMapping("/findAll")
	public Collection<TipoRemolque>findAll(){
		return tipoRemolqueService.findAll();
	}
	
}
