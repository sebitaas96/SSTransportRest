package com.rest.transport.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.dto.Mensaje;
import com.rest.transport.dto.PagosEstado;
import com.rest.transport.entities.EstadoPago;
import com.rest.transport.entities.Pago;
import com.rest.transport.service.PagoService;

@RestController
@RequestMapping("/pago")
@CrossOrigin(origins = "http://localhost:4200")
public class PagoController {
	
	@Autowired
	PagoService pagoService;
	
	
	@PostMapping("/nuevoPago")
	public ResponseEntity<?>nuevoPago(@RequestBody Long idViaje){
		try {
			this.pagoService.nuevoPago(idViaje);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity(new Mensaje("Ha ocurrido un error"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Mensaje("Pago generado"), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/realizarPago")
	public ResponseEntity<?>RealizarPago(@RequestBody Long idPago){
		try {
			this.pagoService.realizarPago(idPago);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity(new Mensaje("Ha ocurrido un error"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Mensaje("Pago realizado"), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/rechazarPago")
	public ResponseEntity<?>rechazarPago(@RequestBody Long idPago){
		try {
			this.pagoService.rechazarPago(idPago);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity(new Mensaje("Ha ocurrido un error"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Mensaje("Pago rechazado"), HttpStatus.CREATED);
	}
	
	@PutMapping("/disputarPago")
	public ResponseEntity<?>disputarPago(@RequestBody Long idPago){
		try {
			this.pagoService.disputarPago(idPago);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity(new Mensaje("Ha ocurrido un error"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Mensaje("Pago disputado"), HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/{idPorte}/findAllPorte")
	public Collection<Pago>findAllPorte(@PathVariable("idPorte")Long idPorte){
		return this.pagoService.findAllPorte(idPorte);
	}
	
	@GetMapping("/{idTransporte}/findAllTransporte")
	public Collection<Pago>findAllTransporte(@PathVariable("idTransporte")Long idTransporte){
		return this.pagoService.findAllTransporte(idTransporte);
	}
	
	@GetMapping("/{idPago}/findPago")
	public Optional<Pago> findPago(@PathVariable("idPago")Long idPago){
		return this.pagoService.findPago(idPago);
	}
	
	@PostMapping("/findAllFiltrado")
	public Collection<Pago>findAllFiltrado(@RequestBody PagosEstado pagosEstado){
		return this.pagoService.findAllFiltrado(pagosEstado);
	}
	
	
}
