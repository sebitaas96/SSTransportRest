package com.rest.transport.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.CuentaBancaria;



@Repository
public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, Long>{
	boolean existsByIban(String iban);
	Optional<CuentaBancaria>findByIban(String iban);
}
