package com.rest.transport.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.dto.AsignarCamion;
import com.rest.transport.dto.AsignarConductor;
import com.rest.transport.dto.AsignarRemolque;
import com.rest.transport.dto.Mensaje;
import com.rest.transport.dto.NuevoViaje;
import com.rest.transport.dto.ReactivarViaje;
import com.rest.transport.dto.ReservarViaje;
import com.rest.transport.dto.UpdateFecha;
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
					nuevoViaje.getViajeDeCamion(),
					nuevoViaje.getViajeDeRemolque(),
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
	
	@GetMapping("/{idEmpresa}/findAllTransporte")
	public Collection<Viaje>findAllTranspore(@PathVariable("idEmpresa")Long idEmpresa){
		return this.viajeService.findAllTransporte(idEmpresa);
	}
	
	
	@GetMapping("/findAllPanel")
	public Collection<Viaje>findAllPanel(){
		return this.viajeService.findAllPanel();
	}
	
	@GetMapping("/{idExpedidor}/findAllExpedidor")
	public Collection<Viaje>findAllExpedidor(@PathVariable("idExpedidor")Long idExpedidor){
		return this.viajeService.findAllExpedidor(idExpedidor);
	}
	
	@GetMapping("/{idConductor}/findAllConductor")
	public Collection<Viaje>findAllConductor(@PathVariable("idConductor")Long idConductor){
		return this.viajeService.findAllConductor(idConductor);
	}
	
	
	@GetMapping("/{idViaje}/findViajeId")
	public Optional<Viaje> findByViajeId(@PathVariable("idViaje")Long idViaje) {
		return viajeService.findViajeId(idViaje);
	}
	
	@GetMapping("/{idPago}/findViajeIdPago")
	public Optional<Viaje> findViajeIdPago(@PathVariable("idPago")Long idPago) {
		return viajeService.findViajeIdPago(idPago);
	}
	
	@PutMapping("/reservarViaje")
	public ResponseEntity<?>reservarViaje(@RequestBody ReservarViaje reservarViaje){
		try { 
			viajeService.reservarViaje(reservarViaje);
			return new ResponseEntity(new Mensaje("Viaje Reservado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.BAD_REQUEST);
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
	
	@PutMapping("/iniciarViaje")
	public ResponseEntity<?>iniciarViaje(@RequestBody Long idViaje){
		try { 
			viajeService.iniciarViaje(idViaje);
			return new ResponseEntity(new Mensaje("Viaje Iniciado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/finalizarViaje")
	public ResponseEntity<?>finalizarViaje(@RequestBody Long idViaje){
		try { 
			viajeService.finalizarViaje(idViaje);
			return new ResponseEntity(new Mensaje("Viaje finalizado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/reactivarViaje")
	public ResponseEntity<?>reactivarViaje(@RequestBody ReactivarViaje reactivarViaje){
		try { 
			viajeService.reactivarViaje(reactivarViaje);
			return new ResponseEntity(new Mensaje("Viaje Reactivado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping("/asignarConductor")
	public ResponseEntity<?>asignarConductor(@RequestBody AsignarConductor asignarConductor){
			try { 
			viajeService.asignarConductor(asignarConductor);
			return new ResponseEntity(new Mensaje("Conductor Asignado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateConductor")
	public ResponseEntity<?>updateConductor(@RequestBody Long idViaje){
		try { 
			viajeService.updateConductor(idViaje);
			return new ResponseEntity(new Mensaje("Conductor Eliminado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping("/asignarCamion")
	public ResponseEntity<?>asignarCamion(@RequestBody AsignarCamion asignarCamion){
			try { 
			viajeService.asignarCamion(asignarCamion);
			return new ResponseEntity(new Mensaje("Camion Asignado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/asignarRemolque")
	public ResponseEntity<?>asignarRemolque(@RequestBody AsignarRemolque asignarRemolque){
			try { 
			viajeService.asignarRemolque(asignarRemolque);
			return new ResponseEntity(new Mensaje("Remolque Asignado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateFechaInicio")
	public ResponseEntity<?>updateFechaInicio(@RequestBody UpdateFecha updateFecha){
			try { 
			viajeService.updateFechaInicio(updateFecha);
			return new ResponseEntity(new Mensaje("Fecha Asignada"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateFechaFin")
	public ResponseEntity<?>updateFechaFin(@RequestBody UpdateFecha updateFecha){
			try { 
			viajeService.updateFechaFin(updateFecha);
			return new ResponseEntity(new Mensaje("Fecha Asignada"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
	
	 @DeleteMapping("/{idViaje}/deleteViaje")
	public ResponseEntity<?>delete(@PathVariable("idViaje") Long idViaje){
		try { 
			viajeService.deleteViaje(idViaje);
			return new ResponseEntity(new Mensaje("Viaje eliminado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	 

	
	
	
}
