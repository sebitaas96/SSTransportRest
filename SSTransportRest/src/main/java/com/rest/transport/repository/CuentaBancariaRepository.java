package com.rest.transport.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.CuentaBancaria;



@Repository
public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, Long>{
	
}
