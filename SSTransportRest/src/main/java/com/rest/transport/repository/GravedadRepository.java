package com.rest.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Gravedad;

@Repository
public interface GravedadRepository extends JpaRepository<Gravedad, Long>{
	Gravedad findByNombre(String nombre);
}
