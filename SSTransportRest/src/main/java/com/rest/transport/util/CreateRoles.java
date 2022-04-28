package com.rest.transport.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rest.transport.security.entities.Rol;
import com.rest.transport.security.enums.RolNombre;
import com.rest.transport.security.service.RolService;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
    	/*Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolTransporte = new Rol(RolNombre.ROLE_TRANSPORTE);
        Rol rolPorte = new Rol(RolNombre.ROLE_PORTE);
        Rol rolConductor = new Rol(RolNombre.ROLE_CONDUCTOR);
        Rol rolExpedidor = new Rol(RolNombre.ROLE_EXPEDIDOR);
        rolService.save(rolAdmin);
        rolService.save(rolTransporte);
        rolService.save(rolPorte);
        rolService.save(rolConductor);
        rolService.save(rolExpedidor);
        */
    	
    	
        
    }

}
