package com.rest.transport.security.controller;




import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transport.dto.CambioPassword;
import com.rest.transport.dto.Mensaje;
import com.rest.transport.dto.addCuenta;
import com.rest.transport.security.entities.Usuario;
import com.rest.transport.security.service.UsuarioService;


@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {
	
    @Autowired
    UsuarioService usuarioService;
   
    
    @Autowired
    PasswordEncoder passwordEncoder;

	@PutMapping("/updatePassword")
	public ResponseEntity<?>updatePassword(@RequestBody CambioPassword cambioPwd){
			System.out.println(cambioPwd.toString());
			Usuario u = usuarioService.getById(cambioPwd.getId_usuario());
			
			if(passwordEncoder.matches(cambioPwd.getPwd_vieja(),u.getPassword())){
				try {
					usuarioService.updatePassword(passwordEncoder.encode(cambioPwd.getPwd_nueva()) , cambioPwd.getId_usuario());
					return new ResponseEntity(new Mensaje("Password actualizada"), HttpStatus.CREATED);
				}
				catch(Exception e) {
					return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
				}
				
			}
			else {
				return new ResponseEntity(new Mensaje("La password actual es incorrecta"), HttpStatus.BAD_REQUEST);
			}
			
	}
	
	@PutMapping("/addCuenta")
	public ResponseEntity<?>updateCuenta(@RequestBody addCuenta dtoAddCuenta ){
		try { 
			usuarioService.adCuenta(dtoAddCuenta);
			return new ResponseEntity(new Mensaje("Cuenta bancaria añadida"), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity(new Mensaje("Ha sucedido un error"), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@GetMapping("/{nombreUsuario}/Usuario")
	public Optional<Usuario> findByIdUsuario(@PathVariable("nombreUsuario") String nombreUsuario){
		return  usuarioService.getByNombreUsuario(nombreUsuario);
	}
}
