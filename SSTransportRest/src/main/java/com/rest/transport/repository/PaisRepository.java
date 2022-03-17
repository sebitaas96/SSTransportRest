package com.rest.transport.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Pais;



@Repository
public interface PaisRepository extends CrudRepository<Pais, Long>{

}
