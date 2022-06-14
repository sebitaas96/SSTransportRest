package com.rest.transport.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Viaje;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {
	Collection<Viaje>findByViajeDePorteId(Long idEmpresa);
	Collection<Viaje>findByViajeDeEstadoId(Long idEstado);
	Collection<Viaje>findByViajeDeExpedidorId(Long idExpedidor);
	Collection<Viaje>findByViajeDeTransporteId(Long idEmpresa);
	Collection<Viaje>findByViajeDeConductorId(Long idConductor);
	Optional<Viaje> findByPagoId(Long idPago);
}
