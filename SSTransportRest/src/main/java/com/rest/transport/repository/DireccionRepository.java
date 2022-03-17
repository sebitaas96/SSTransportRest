package com.rest.transport.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Direccion;

@Repository
public interface DireccionRepository extends CrudRepository<Direccion, Long>{

}
