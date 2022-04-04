package com.rest.transport.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.rest.transport.dto.Mensaje;
import com.rest.transport.entities.Transporte;
import com.rest.transport.repository.DireccionRepository;
import com.rest.transport.security.dto.JwtDto;
import com.rest.transport.security.dto.LoginUsuario;
import com.rest.transport.security.dto.NuevoUsuario;
import com.rest.transport.security.entities.Usuario;
import com.rest.transport.security.enums.RolNombre;
import com.rest.transport.security.jwt.JwtProvider;
import com.rest.transport.security.service.RolService;
import com.rest.transport.security.service.UsuarioService;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;
    

	@Autowired
	DireccionRepository direccionRepository;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody NuevoUsuario nuevoUsuario,BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
        	return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        }
            
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
        	return new ResponseEntity(new Mensaje("El nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }	
            
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
        	return new ResponseEntity(new Mensaje("Ya hay una cuenta registrada con este email"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByDocumento(nuevoUsuario.getDocumento())) {
        	return new ResponseEntity(new Mensaje("Ya hay una cuenta registrada con este documento"), HttpStatus.BAD_REQUEST);
        }
            
      
            Usuario usuario =new Transporte(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), passwordEncoder.encode(nuevoUsuario.getPassword()),
            		nuevoUsuario.getDocumento(),nuevoUsuario.getEmail(),nuevoUsuario.getTelefono(), nuevoUsuario.getResidenteDeDireccion() , 
            		nuevoUsuario.getOperadorDeProvincia(),null);
            
          /*  Set<Rol> roles = new HashSet<>();*/
            usuario.addUsuarios(rolService.getByRolNombre(RolNombre.ROLE_TRANSPORTE).get());
           /* if(nuevoUsuario.getRoles().contains("admin"))
                roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());*/
          //  usuario.setRoles(roles);

            direccionRepository.save(nuevoUsuario.getResidenteDeDireccion());
            try {
            	usuarioService.save(usuario);
            	return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
            }
            catch(Exception e) {
            	System.out.println(e.getMessage());
            	return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
            }
            
           

    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}