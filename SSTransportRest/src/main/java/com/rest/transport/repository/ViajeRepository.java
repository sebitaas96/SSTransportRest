package com.rest.transport.repository;

import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Viaje;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {
	Collection<Viaje>findByViajeDePorteId(Long idEmpresa);
	Collection<Viaje>findByViajeDeExpedidorId(Long idExpedidor);
}
