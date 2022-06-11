package com.rest.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
	Estado findByNombre(String nombre);
}
