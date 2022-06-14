package com.rest.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.EstadoPago;
@Repository
public interface EstadoPagoRepository extends JpaRepository<EstadoPago, Long> {

	EstadoPago findByNombre(String nombre);
	
}
