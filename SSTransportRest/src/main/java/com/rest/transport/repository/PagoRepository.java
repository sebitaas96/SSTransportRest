package com.rest.transport.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.transport.entities.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {
	Collection<Pago>findByPagoDePorteId(Long idPorte);
	Collection<Pago>findByPagoDeTransporteId(Long idTransporte);
	Collection<Pago>findByPagoDeEstadoPagoId(Long idPagoEstado);
}
