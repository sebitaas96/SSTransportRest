package com.rest.transport.repository;

import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Expedidor;

@Repository
public interface ExpedidorRepository extends JpaRepository<Expedidor,Long> {

	Collection<Expedidor>findByExpedidorDePorteId(Long idPorte);
	Expedidor findByNombreUsuario(String nombreUsuario);
}
