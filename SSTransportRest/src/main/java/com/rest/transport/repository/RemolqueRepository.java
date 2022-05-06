package com.rest.transport.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Remolque;

@Repository
public interface RemolqueRepository extends JpaRepository<Remolque, Long>{
	
	boolean existsByMatricula(String matricula);
	Collection<Remolque>findByRemolqueDeTransporteId(Long idEmpresa);
	Collection<Remolque>findByRemolqueDeConductorId(Long idConductor);
}
