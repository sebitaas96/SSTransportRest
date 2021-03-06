package com.rest.transport.controller;

import java.util.Collection;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.entities.Localidad;
import com.rest.transport.entities.Provincia;
import com.rest.transport.service.ProvinciaService;


@RestController
@RequestMapping("/provincia")
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinciaController {
	
	@Autowired
	private ProvinciaService provinciaService;
	
	@GetMapping
    public List<Provincia> r() {
        return provinciaService.findAll();
    }
	
	@GetMapping("/{id}/localidades")
	  public Collection<Localidad> getLocalidades(@PathVariable("id") Long id){
	    return provinciaService.getLocalidades(id);
	  }
	
	
}
