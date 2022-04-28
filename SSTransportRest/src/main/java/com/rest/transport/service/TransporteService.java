package com.rest.transport.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.Direccion;
import com.rest.transport.entities.Transporte;
import com.rest.transport.repository.DireccionRepository;
import com.rest.transport.repository.TransporteRepository;



@Service
public class TransporteService {
	
	@Autowired
	TransporteRepository transporteRepository;
	@Autowired
	DireccionRepository direccionRepository;
	
	public Transporte findByNombreUsuario(String nombreUsuario) {
		return  transporteRepository.findByNombreUsuario(nombreUsuario);
	}
	
	public Optional<Transporte> findByIdUsuario(Long idUsuario) {
		return transporteRepository.findById(idUsuario);
	}
	
	public void updateTransporte(Transporte transporte) {
		Transporte t = transporteRepository.getById(transporte.getId());
		if(t.getResidenteDeDireccion() == null) {
			Direccion d = transporte.getResidenteDeDireccion();
			Direccion nueva = direccionRepository.saveAndFlush(d);
			t.setResidenteDeDireccion(nueva);
		}
		else if(!t.getResidenteDeDireccion()
			.getDireccionDeLocalidad()
			.getLocalidadDeProvincia().getProvinciaDePais().getNombre().equals(
			transporte.getResidenteDeDireccion().getDireccionDeLocalidad().getLocalidadDeProvincia().getProvinciaDePais().getNombre())
			||!t.getResidenteDeDireccion().getDireccionDeLocalidad().getLocalidadDeProvincia().getNombre().equals(transporte.getResidenteDeDireccion().getDireccionDeLocalidad().getLocalidadDeProvincia().getNombre())
			||!t.getResidenteDeDireccion().getDireccionDeLocalidad().getNombre().equals(transporte.getResidenteDeDireccion().getDireccionDeLocalidad().getNombre())
			||!t.getResidenteDeDireccion().getTipo().equals(transporte.getResidenteDeDireccion().getTipo())
			||!t.getResidenteDeDireccion().getNombre().equals(transporte.getResidenteDeDireccion().getNombre())
			||!(t.getResidenteDeDireccion().getNumero() == transporte.getResidenteDeDireccion().getNumero())
			){
			System.out.println("he entrado aqui 2");
			Direccion d = direccionRepository.getById(transporte.getResidenteDeDireccion().getId());
			d.setDireccionDeLocalidad(transporte.getResidenteDeDireccion().getDireccionDeLocalidad());
			d.setNumero(transporte.getResidenteDeDireccion().getNumero());
			d.setNombre(transporte.getResidenteDeDireccion().getNombre());
			d.setTipo(transporte.getResidenteDeDireccion().getTipo());
			direccionRepository.saveAndFlush(d);
			}
		t.setNombre(transporte.getNombre());
		t.setDocumento(transporte.getDocumento());
		t.setTelefono(transporte.getTelefono());
		transporteRepository.saveAndFlush(t);
	}
	
}
