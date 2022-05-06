package com.rest.transport.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.dto.Mensaje;
import com.rest.transport.entities.CuentaBancaria;
import com.rest.transport.service.CuentaBancariaService;

@RestController
@RequestMapping("/cuentaBancaria")
@CrossOrigin(origins = "http://localhost:4200")
public class CuentaBancariaController {

	@Autowired
	CuentaBancariaService cuentaBancariaService;
	
	@GetMapping("/{idCuenta}/findCuenta")
	  public Optional<CuentaBancaria> getCuenta(@PathVariable("idCuenta")Long idCuenta){
	    return cuentaBancariaService.findById(idCuenta);
	  }
	
	@GetMapping("/{iban}/findCuentaIban")
	  public Optional<CuentaBancaria> getCuentaIban(@PathVariable("iban")String iban){
	    return cuentaBancariaService.findByIban(iban);
	  }
	
	@PostMapping("/createCuenta")
	public  ResponseEntity<?> createCuenta(@RequestBody CuentaBancaria cuentaBancaria){
		if(cuentaBancariaService.existsByIban(cuentaBancaria.getIban())) {
			return new ResponseEntity(new Mensaje("El numero de iban ya esta asociado"), HttpStatus.BAD_REQUEST);
		}
		try {
			cuentaBancariaService.createCuenta(cuentaBancaria);
			return new ResponseEntity(new Mensaje("Cuenta bancaria añadida"), HttpStatus.CREATED);
		}	
		catch(Exception e) {
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}

	}
	
	@PutMapping("/updateCuenta")
	public ResponseEntity<?>updateCuenta(@RequestBody CuentaBancaria cuentaBancaria){
		try { 
			cuentaBancariaService.updateCuenta(cuentaBancaria);
			return new ResponseEntity(new Mensaje("Cuenta bancaria actualizada"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
