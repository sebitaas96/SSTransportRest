package com.rest.transport.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Transporte;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Long> {
	Transporte findByNombreUsuario(String nombreUsuario);
}
