package com.rest.transport.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.CuentaBancaria;
import com.rest.transport.repository.CuentaBancariaRepository;
import com.rest.transport.security.entities.Usuario;
import com.rest.transport.security.repository.UsuarioRepository;


@Service
public class CuentaBancariaService {
	
	@Autowired
	CuentaBancariaRepository cuentaBancariaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	 public Optional<CuentaBancaria> findById(Long idCuenta) {
	    	return cuentaBancariaRepository.findById(idCuenta);
	  }
	 
	 public CuentaBancaria createCuenta(CuentaBancaria cuentaBancaria) {
		 return cuentaBancariaRepository.save(cuentaBancaria);
	 }
	 
	 public void updateCuenta(CuentaBancaria cuentaBancaria) {
		 CuentaBancaria c = cuentaBancariaRepository.getById(cuentaBancaria.getId());
		 c.setIban(cuentaBancaria.getIban());
		 c.setNombreTitular(cuentaBancaria.getNombreTitular());
		 c.setSwiftBic(cuentaBancaria.getSwiftBic());
		 cuentaBancariaRepository.save(c);
	 }
}
