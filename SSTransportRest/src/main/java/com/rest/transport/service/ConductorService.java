package com.rest.transport.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.transport.dto.CambiarEstado;
import com.rest.transport.entities.Conductor;
import com.rest.transport.entities.Direccion;
import com.rest.transport.repository.ConductorRepository;
import com.rest.transport.repository.DireccionRepository;
import com.rest.transport.security.entities.Rol;

@Service
public class ConductorService {
	@Autowired
	ConductorRepository conductorRepository;
	
	@Autowired
	DireccionRepository direccionRepository;
	
	public Collection<Conductor>findAll(Long idTransporte){
		return this.conductorRepository.findByConductorDeTransporteId(idTransporte);
	}
	
    public void deleteConductor(Long idConductor) {
    	Conductor c = conductorRepository.getById(idConductor);
    	Collection<Rol> roles = c.getRoles();
    	
    	if(roles !=null) {
    		for(Rol rol : roles) {
    			c.removeRoles(rol);
    		}
    		conductorRepository.save(c);
    	}
    	conductorRepository.deleteById(idConductor);
    }
    
    public void CambiarEstado(CambiarEstado cambiarEstado) {
    	Conductor c = conductorRepository.getById(cambiarEstado.getId());
    	c.setActivo(cambiarEstado.isEstado());
    	conductorRepository.save(c);
    }
    
	public Conductor findByNombreConductor(String nombreUsuario) {
		return conductorRepository.findByNombreUsuario(nombreUsuario);
	}
	
	
	public void updateConductor(Conductor conductor) {
		Conductor c = conductorRepository.getById(conductor.getId());
		if(c.getResidenteDeDireccion() == null) {
			Direccion d = conductor.getResidenteDeDireccion();
			Direccion nueva = direccionRepository.saveAndFlush(d);
			c.setResidenteDeDireccion(nueva);
		}
		else if(!c.getResidenteDeDireccion()
			.getDireccionDeLocalidad()
			.getLocalidadDeProvincia().getProvinciaDePais().getNombre().equals(
					conductor.getResidenteDeDireccion().getDireccionDeLocalidad().getLocalidadDeProvincia().getProvinciaDePais().getNombre())
			||!c.getResidenteDeDireccion().getDireccionDeLocalidad().getLocalidadDeProvincia().getNombre().equals(conductor.getResidenteDeDireccion().getDireccionDeLocalidad().getLocalidadDeProvincia().getNombre())
			||!c.getResidenteDeDireccion().getDireccionDeLocalidad().getNombre().equals(conductor.getResidenteDeDireccion().getDireccionDeLocalidad().getNombre())
			||!c.getResidenteDeDireccion().getTipo().equals(conductor.getResidenteDeDireccion().getTipo())
			||!c.getResidenteDeDireccion().getNombre().equals(conductor.getResidenteDeDireccion().getNombre())
			||!(c.getResidenteDeDireccion().getNumero() == conductor.getResidenteDeDireccion().getNumero())
			){
			System.out.println("he entrado aqui 2");
			Direccion d = direccionRepository.getById(conductor.getResidenteDeDireccion().getId());
			d.setDireccionDeLocalidad(conductor.getResidenteDeDireccion().getDireccionDeLocalidad());
			d.setNumero(conductor.getResidenteDeDireccion().getNumero());
			d.setNombre(conductor.getResidenteDeDireccion().getNombre());
			d.setTipo(conductor.getResidenteDeDireccion().getTipo());
			direccionRepository.saveAndFlush(d);
			}
		c.setNombre(conductor.getNombre());
		c.setApellido(conductor.getApellido());
		c.setDocumento(conductor.getDocumento());
		c.setTelefono(conductor.getTelefono());
		conductorRepository.saveAndFlush(c);
	}
}
