package com.rest.transport.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.transport.dto.CambiarEstado;
import com.rest.transport.entities.Expedidor;
import com.rest.transport.entities.Direccion;

import com.rest.transport.repository.DireccionRepository;
import com.rest.transport.repository.ExpedidorRepository;
import com.rest.transport.security.entities.Rol;

@Service
public class ExpedidorService {
	
	@Autowired
	ExpedidorRepository expedidorRepository;
	
	@Autowired
	DireccionRepository direccionRepository;
	
	public Collection<Expedidor>findAll(Long idPorte){
		return this.expedidorRepository.findByExpedidorDePorteId(idPorte);
	}
	
    public void deleteExpedidor(Long idExpedidor) {
    	Expedidor e = expedidorRepository.getById(idExpedidor);
    	Collection<Rol> roles = e.getRoles();
    	
    	if(roles !=null) {
    		for(Rol rol : roles) {
    			e.removeRoles(rol);
    		}
    		expedidorRepository.save(e);
    	}
    	expedidorRepository.deleteById(idExpedidor);
    }
    
    public void CambiarEstado(CambiarEstado cambiarEstado) {
    	Expedidor e = expedidorRepository.getById(cambiarEstado.getId());
    	e.setEstado(cambiarEstado.isEstado());
    	expedidorRepository.save(e);
    }
    
	public Expedidor findByNombreConductor(String nombreUsuario) {
		return expedidorRepository.findByNombreUsuario(nombreUsuario);
	}
	
	
	public void updateExpedidor(Expedidor expedidor) {
		Expedidor e = expedidorRepository.getById(expedidor.getId());
		if(e.getResidenteDeDireccion() == null) {
			Direccion d = expedidor.getResidenteDeDireccion();
			Direccion nueva = direccionRepository.saveAndFlush(d);
			e.setResidenteDeDireccion(nueva);
		}
		else if(!e.getResidenteDeDireccion()
			.getDireccionDeLocalidad()
			.getLocalidadDeProvincia().getProvinciaDePais().getNombre().equals(
					expedidor.getResidenteDeDireccion().getDireccionDeLocalidad().getLocalidadDeProvincia().getProvinciaDePais().getNombre())
			||!e.getResidenteDeDireccion().getDireccionDeLocalidad().getLocalidadDeProvincia().getNombre().equals(expedidor.getResidenteDeDireccion().getDireccionDeLocalidad().getLocalidadDeProvincia().getNombre())
			||!e.getResidenteDeDireccion().getDireccionDeLocalidad().getNombre().equals(expedidor.getResidenteDeDireccion().getDireccionDeLocalidad().getNombre())
			||!e.getResidenteDeDireccion().getTipo().equals(expedidor.getResidenteDeDireccion().getTipo())
			||!e.getResidenteDeDireccion().getNombre().equals(expedidor.getResidenteDeDireccion().getNombre())
			||!(e.getResidenteDeDireccion().getNumero() == expedidor.getResidenteDeDireccion().getNumero())
			){
			System.out.println("he entrado aqui 2");
			Direccion d = direccionRepository.getById(expedidor.getResidenteDeDireccion().getId());
			d.setDireccionDeLocalidad(expedidor.getResidenteDeDireccion().getDireccionDeLocalidad());
			d.setNumero(expedidor.getResidenteDeDireccion().getNumero());
			d.setNombre(expedidor.getResidenteDeDireccion().getNombre());
			d.setTipo(expedidor.getResidenteDeDireccion().getTipo());
			direccionRepository.saveAndFlush(d);
			}
		e.setNombre(expedidor.getNombre());
		e.setApellido(expedidor.getApellido());
		e.setDocumento(expedidor.getDocumento());
		e.setTelefono(expedidor.getTelefono());
		expedidorRepository.saveAndFlush(e);
	}

}
