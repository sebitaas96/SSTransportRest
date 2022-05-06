package com.rest.transport.service;

import java.util.Collection;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.dto.CambiarEstado;
import com.rest.transport.dto.asignacionEquipo;
import com.rest.transport.entities.Remolque;
import com.rest.transport.repository.RemolqueRepository;

@Service
public class RemolqueService {

	@Autowired
	RemolqueRepository remolqueRepository;
	
	
	public boolean existsByMatricula(String matricula) {
		return remolqueRepository.existsByMatricula(matricula);
	}
	
	public void save(Remolque remolque) {
		remolqueRepository.save(remolque);
	}
	
	public Collection<Remolque>findAll(Long idEmpresa){
		return remolqueRepository.findByRemolqueDeTransporteId(idEmpresa);
		
	}
	
	public Collection<Remolque>findAllConductor(Long idConductor){
		return remolqueRepository.findByRemolqueDeConductorId(idConductor);
		
	}
	
    public void CambiarEstado(CambiarEstado cambiarEstado) {
    	Remolque r = remolqueRepository.getById(cambiarEstado.getId());
    	r.setEstado(cambiarEstado.isEstado());
    	remolqueRepository.save(r);
    }
    
    public void cambiarConductor(asignacionEquipo asignacion) {
    	Remolque r = remolqueRepository.getById(asignacion.getIdEquipo());
    	r.setRemolqueDeConductor(asignacion.getConductor());
    	remolqueRepository.save(r);
    }
    
    public void deleteRemolque(Long idRemolque) {
    	remolqueRepository.deleteById(idRemolque);
    }
}
