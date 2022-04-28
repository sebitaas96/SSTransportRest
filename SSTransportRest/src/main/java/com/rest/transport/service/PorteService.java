package com.rest.transport.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.rest.transport.entities.Direccion;
import com.rest.transport.entities.Porte;
import com.rest.transport.repository.DireccionRepository;
import com.rest.transport.repository.PorteRepository;

@Service
public class PorteService {

	@Autowired
	PorteRepository porteRepository;
	
	@Autowired
	DireccionRepository direccionRepository;
	public Porte findByNombreUsuario(String nombreUsuario) {
		return porteRepository.findByNombreUsuario(nombreUsuario);
	}
	
	
	public void updatePorte(Porte porte) {
		Porte p = porteRepository.getById(porte.getId());
		if(p.getResidenteDeDireccion() == null) {
			Direccion d = porte.getResidenteDeDireccion();
			Direccion nueva = direccionRepository.saveAndFlush(d);
			p.setResidenteDeDireccion(nueva);
		}
		else if(!p.getResidenteDeDireccion()
			.getDireccionDeLocalidad()
			.getLocalidadDeProvincia().getProvinciaDePais().getNombre().equals(
			porte.getResidenteDeDireccion().getDireccionDeLocalidad().getLocalidadDeProvincia().getProvinciaDePais().getNombre())
			||!p.getResidenteDeDireccion().getDireccionDeLocalidad().getLocalidadDeProvincia().getNombre().equals(porte.getResidenteDeDireccion().getDireccionDeLocalidad().getLocalidadDeProvincia().getNombre())
			||!p.getResidenteDeDireccion().getDireccionDeLocalidad().getNombre().equals(porte.getResidenteDeDireccion().getDireccionDeLocalidad().getNombre())
			||!p.getResidenteDeDireccion().getTipo().equals(porte.getResidenteDeDireccion().getTipo())
			||!p.getResidenteDeDireccion().getNombre().equals(porte.getResidenteDeDireccion().getNombre())
			||!(p.getResidenteDeDireccion().getNumero() == porte.getResidenteDeDireccion().getNumero())
			){
			System.out.println("he entrado aqui 2");
			Direccion d = direccionRepository.getById(porte.getResidenteDeDireccion().getId());
			d.setDireccionDeLocalidad(porte.getResidenteDeDireccion().getDireccionDeLocalidad());
			d.setNumero(porte.getResidenteDeDireccion().getNumero());
			d.setNombre(porte.getResidenteDeDireccion().getNombre());
			d.setTipo(porte.getResidenteDeDireccion().getTipo());
			direccionRepository.saveAndFlush(d);
			}
		p.setNombre(porte.getNombre());
		p.setDocumento(porte.getDocumento());
		p.setTelefono(porte.getTelefono());
		porteRepository.saveAndFlush(p);
	}
	
}
