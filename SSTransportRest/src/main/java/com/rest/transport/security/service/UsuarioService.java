package com.rest.transport.security.service;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.security.entities.Usuario;
import com.rest.transport.security.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	  @Autowired
	    UsuarioRepository usuarioRepository;
	 
	
	    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
	        return usuarioRepository.findByNombreUsuario(nombreUsuario);
	    }

	    public boolean existsByNombreUsuario(String nombreUsuario){
	        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
	    }

	    public boolean existsByEmail(String email){
	        return usuarioRepository.existsByEmail(email);
	    }
	    
	    public boolean existsByDocumento(String documento) {
	    	return usuarioRepository.existsByDocumento(documento);
	    }

	    public void save(Usuario usuario){ 	
	    	usuarioRepository.save(usuario);
	    }
	
}
