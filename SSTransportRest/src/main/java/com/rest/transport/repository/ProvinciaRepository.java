package com.rest.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Provincia;



@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{

}
