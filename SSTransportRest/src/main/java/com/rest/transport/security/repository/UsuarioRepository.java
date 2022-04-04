package com.rest.transport.security.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.security.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
		Optional<Usuario> findByNombreUsuario(String nombreUsuario);
	    boolean existsByNombreUsuario(String nombreUsuario);
	    boolean existsByEmail(String email);
	    boolean existsByDocumento(String documento);
	
}
