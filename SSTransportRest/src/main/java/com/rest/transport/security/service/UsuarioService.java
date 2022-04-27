package com.rest.transport.security.service;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.dto.addCuenta;
import com.rest.transport.entities.CuentaBancaria;
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
	    
	    public Usuario getById(Long idUsuario){
	    	return usuarioRepository.getById(idUsuario);
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
	    
	    public void updatePassword(String pwdNueva , Long idUsuario){
	    	Usuario u = usuarioRepository.getById(idUsuario);
	    	u.setPassword(pwdNueva);
	    	usuarioRepository.save(u);
	    }
	    
	    public void adCuenta(addCuenta dtoAddCuenta) {
	    	Usuario u = usuarioRepository.getById(dtoAddCuenta.getIdUsuario());
	    	u.setCuentaBancaria(dtoAddCuenta.getCuentaBancaria());
	    	usuarioRepository.save(u);
	    }
	    

}
