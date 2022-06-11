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
import com.rest.transport.dto.NuevoViaje;
import com.rest.transport.dto.ReservarViaje;
import com.rest.transport.entities.Transporte;
import com.rest.transport.entities.Viaje;
import com.rest.transport.service.ViajeService;

@RestController
@RequestMapping("/viaje")
@CrossOrigin(origins = "http://localhost:4200")
public class ViajeController {

	@Autowired
	ViajeService viajeService;
	
	@PostMapping("/nuevo")
	public ResponseEntity<?>nuevo(@RequestBody NuevoViaje nuevoViaje , BindingResult bindingResult){
		try {
			Viaje viaje = new Viaje(
					nuevoViaje.getDescripcion(),
					nuevoViaje.getPrecio(),
					nuevoViaje.getDistancia(),
					nuevoViaje.getTiempo(),
					nuevoViaje.getfHoraInicio(),
					nuevoViaje.getfHoraFin(),
					nuevoViaje.getRecogidaDeDireccion(),
					nuevoViaje.getEntregaDeDireccion(),
					nuevoViaje.getViajeDeTransporte(),
					nuevoViaje.getViajeDeExpedidor(),
					nuevoViaje.getViajeDePorte(),
					nuevoViaje.getViajeDeConductor(),
					nuevoViaje.getViajeDeTipoCamion(),
					nuevoViaje.getViajeDeTipoRemolque(),
					nuevoViaje.getPago(),
					nuevoViaje.getViajeDeEstado()
					);
			viajeService.save(viaje);
	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity(new Mensaje("Ha ocurrido un error"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Mensaje("Viaje añadido"), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{idEmpresa}/findAll")
	public Collection<Viaje>findAll(@PathVariable("idEmpresa")Long idEmpresa){
		return this.viajeService.findAll(idEmpresa);
	}
	
	@GetMapping("/findAllPanel")
	public Collection<Viaje>findAllPanel(){
		return this.viajeService.findAllPanel();
	}
	
	@GetMapping("/{idExpedidor}/findAllExpedidor")
	public Collection<Viaje>findAllExpedidor(@PathVariable("idExpedidor")Long idExpedidor){
		return this.viajeService.findAllExpedidor(idExpedidor);
	}
	
	
	@GetMapping("/{idViaje}/findViajeId")
	public Optional<Viaje> findByViajeId(@PathVariable("idViaje")Long idViaje) {
		return viajeService.findViajeId(idViaje);
	}
	
	@PutMapping("/reservarViaje")
	public ResponseEntity<?>reservarViaje(@RequestBody ReservarViaje reservarViaje){
		try { 
			viajeService.reservarViaje(reservarViaje);
			return new ResponseEntity(new Mensaje("Viaje Reservado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/cancelarViaje")
	public ResponseEntity<?>cancelarViaje(@RequestBody Long idViaje){
		try { 
			viajeService.cancelarViaje(idViaje);
			return new ResponseEntity(new Mensaje("Viaje Cancelado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
