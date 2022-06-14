package com.rest.transport.security.service;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.dto.addCuenta;
import com.rest.transport.entities.CuentaBancaria;
import com.rest.transport.entities.Email;
import com.rest.transport.security.entities.Rol;
import com.rest.transport.security.entities.Usuario;
import com.rest.transport.security.repository.UsuarioRepository;
import com.rest.transport.service.EmailService;

@Service
@Transactional
public class UsuarioService {

	  @Autowired
	    UsuarioRepository usuarioRepository;
	 
	  @Autowired
	  EmailService emailService;
	
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

	    public void saveEmpresa(Usuario usuario){
	    	Usuario u =usuarioRepository.save(usuario);
	    	 this.emailService.sendConfirmationEmail(u.getEmail(),u.getId());
	    }
	    
	    public void save(Usuario usuario) {
	    	 usuarioRepository.save(usuario);

	    }
	    
	    public void updatePassword(String pwdNueva , Long idUsuario){
	    	Usuario u = usuarioRepository.getById(idUsuario);
	    	u.setPassword(pwdNueva);
	    	usuarioRepository.save(u);
	    }
	    
	    public void ActivarUsuario(Long idUsuario){
	    	Usuario u = usuarioRepository.getById(idUsuario);
	    	u.setActivo(true);
	    	usuarioRepository.save(u);
	    }
	    
	    
	    public void adCuenta(addCuenta dtoAddCuenta) {
	    	Usuario u = usuarioRepository.getById(dtoAddCuenta.getIdUsuario());
	    	u.setCuentaBancaria(dtoAddCuenta.getCuentaBancaria());
	    	usuarioRepository.save(u);
	    }
	    

}
