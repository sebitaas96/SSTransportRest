package com.rest.transport.controller;

import java.util.Collection;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rest.transport.dto.CambiarEstado;
import com.rest.transport.dto.Mensaje;
import com.rest.transport.entities.Conductor;
import com.rest.transport.service.ConductorService;

@RestController
@RequestMapping("/conductor")
@CrossOrigin(origins = "http://localhost:4200")
public class ConductorController {

	@Autowired
	ConductorService conductorService;
	
	
	
	@GetMapping("/{nombreUsuario}/ConductorNombre")
	public Conductor findByNombreConductor(@PathVariable("nombreUsuario") String nombreUsuario){
		return  conductorService.findByNombreConductor(nombreUsuario); 
	}
	
	@GetMapping("/{idTransporte}/findAll")
	public Collection<Conductor> findByIdUsuario(@PathVariable("idTransporte") Long idTransporte){
		return  conductorService.findAll(idTransporte);
	}
	
	@PutMapping("/updateConductor")
	public ResponseEntity<?>updateTransporte(@RequestBody Conductor conductor){
		try { 
			conductorService.updateConductor(conductor);
			return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	
	 @DeleteMapping("/{idConductor}/deleteConductor")
	public ResponseEntity<?>delete(@PathVariable("idConductor") Long idConductor){
		try { 
			conductorService.deleteConductor(idConductor);
			return new ResponseEntity(new Mensaje("Conductor eliminado"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	 
		@PutMapping("/cambiarEstado")
		public ResponseEntity<?>cambiarEstadoConductor(@RequestBody CambiarEstado cambiarEstado){
			try { 
				conductorService.CambiarEstado(cambiarEstado);
				if(cambiarEstado.isEstado()) {
					return new ResponseEntity(new Mensaje("Conductor activado"), HttpStatus.CREATED);	
				}
				else {
					return new ResponseEntity(new Mensaje("Conductor desactivado"), HttpStatus.CREATED);	
				}
				
			}
			catch(Exception e){
				return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
			}
		}
	
}
