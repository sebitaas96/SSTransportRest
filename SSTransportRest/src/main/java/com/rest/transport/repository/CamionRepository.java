package com.rest.transport.repository;

import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Camion;

@Repository
public interface CamionRepository  extends JpaRepository<Camion, Long>{
	boolean existsByMatricula(String matricula);
	Collection<Camion>findByCamionDeTransporteId(Long idEmpresa);
	Collection<Camion>findByCamionDeConductorId(Long idConductor);
}
