package com.rest.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Localidad;


@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Long>{

}
