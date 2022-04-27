package com.rest.transport.repository;

import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Conductor;


@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long> {
	Collection<Conductor>findByConductorDeTransporteId(Long idTransporte);
	Conductor findByNombreUsuario(String nombreUsuario);
}
