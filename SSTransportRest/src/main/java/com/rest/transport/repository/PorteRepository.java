package com.rest.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Porte;

@Repository
public interface PorteRepository extends JpaRepository<Porte, Long> {
	Porte findByNombreUsuario(String nombreUsuario);

}
