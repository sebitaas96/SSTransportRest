package com.rest.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long>{

}
