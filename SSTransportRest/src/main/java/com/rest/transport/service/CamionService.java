package com.rest.transport.service;

import java.util.Collection;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.dto.CambiarEstado;
import com.rest.transport.dto.asignacionEquipo;
import com.rest.transport.entities.Camion;
import com.rest.transport.repository.CamionRepository;

@Service
public class CamionService {

	@Autowired
	CamionRepository camionRepository;
	
	
	public boolean existsByMatricula(String matricula) {
		return camionRepository.existsByMatricula(matricula);
	}
	
	public void save(Camion camion){
		camionRepository.save(camion);
	}
	
	public Collection<Camion>findAll(Long idEmpresa){
		return camionRepository.findByCamionDeTransporteId(idEmpresa);
		
	}
	
	public Collection<Camion>findAllConductor(Long idConductor){
		return camionRepository.findByCamionDeConductorId(idConductor);
		
	}
	
    public void CambiarEstado(CambiarEstado cambiarEstado) {
    	Camion c = camionRepository.getById(cambiarEstado.getId());
    	c.setEstado(cambiarEstado.isEstado());
    	camionRepository.save(c);
    }
    
    public void cambiarConductor(asignacionEquipo asignacion) {
    	Camion c = camionRepository.getById(asignacion.getIdEquipo());
    	c.setCamionDeConductor(asignacion.getConductor());
    	camionRepository.save(c);
    }
    
    public void deleteCamion(Long idCamion) {
    	camionRepository.deleteById(idCamion);
    }
}
