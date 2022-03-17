package com.rest.transport.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Provincia;



@Repository
public interface ProvinciaRepository extends CrudRepository<Provincia, Long>{

}
