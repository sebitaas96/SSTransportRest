package com.rest.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rest.transport.entities.Pais;



@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

}
