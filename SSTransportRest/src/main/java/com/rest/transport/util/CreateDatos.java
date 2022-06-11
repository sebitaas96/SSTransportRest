package com.rest.transport.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rest.transport.entities.Estado;
import com.rest.transport.entities.TipoCamion;
import com.rest.transport.entities.TipoRemolque;
import com.rest.transport.security.entities.Rol;
import com.rest.transport.security.enums.RolNombre;
import com.rest.transport.security.service.RolService;
import com.rest.transport.service.EstadoService;
import com.rest.transport.service.TipoCamionService;
import com.rest.transport.service.TipoRemolqueService;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateDatos implements CommandLineRunner {

    @Autowired
    RolService rolService;
    
    @Autowired
    TipoCamionService tipoCamionService;
    
    @Autowired
    TipoRemolqueService tipoRemolqueService;
    
    @Autowired
    EstadoService estadoService;
    

    @Override
    public void run(String... args) throws Exception {
    	/*Roles*/
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
    	
    	/*Estados*/
    	/*Estado estado1 = new Estado("Expedido");
    	Estado estado2 = new Estado("Reservado");
    	Estado estado3 = new Estado("Finalizado");
    	Estado estado4 = new Estado("Caducado");
    	estadoService.save(estado1);
    	estadoService.save(estado2);
    	estadoService.save(estado3);
    	estadoService.save(estado4);*/
    	
    	
    	/* Tipo de Camiones*/
    /*	TipoCamion camionEstandar = new TipoCamion("Tractora estandar" , true);
    	TipoCamion camion75 = new TipoCamion("Camion de 7,5T" , false);
    	TipoCamion camion35elevador = new TipoCamion("Camion de 3,5T con elevador trasero" , false);
    	TipoCamion camion35sinelevador = new TipoCamion("Camion de 3,5T sin elevador trasero" , false);
    	TipoCamion furgoneta35elevador = new TipoCamion("Furgoneta de 3,5T con elevador trasero" , false);
    	TipoCamion furgoneta35sinelevador = new TipoCamion("Furgoneta de 3,5T sin elevador trasero" , false);
    	tipoCamionService.save(camionEstandar);
    	tipoCamionService.save(camion75);
    	tipoCamionService.save(camion35elevador);
    	tipoCamionService.save(camion35sinelevador);
    	tipoCamionService.save(furgoneta35elevador);
    	tipoCamionService.save(furgoneta35sinelevador);*/
    	
    	/*Tipo de Remolques*/
    /*	TipoRemolque lonaTauliner =new TipoRemolque("Lona o Tauliner");
    	TipoRemolque cajaCerrada =new TipoRemolque("Caja cerrada");
    	TipoRemolque semirremolque =new TipoRemolque("Semirremolque");
    	TipoRemolque trenCarretera =new TipoRemolque("Tren de carretera");
    	TipoRemolque frigos =new TipoRemolque("Frigorífico");
    	TipoRemolque calorifico =new TipoRemolque("Calorífico");
    	TipoRemolque cisterna =new TipoRemolque("Cisterna");
    	TipoRemolque plataforma =new TipoRemolque("Plataforma");
    	TipoRemolque portaContenedores =new TipoRemolque("Porta-Contenedores");
    	TipoRemolque portaCoches =new TipoRemolque("Porta-Coches");
    	TipoRemolque basculante =new TipoRemolque("Basculante");
    	TipoRemolque especiales =new TipoRemolque("Vehículos especiales y a medida");
    	tipoRemolqueService.save(lonaTauliner);
    	tipoRemolqueService.save(cajaCerrada);
    	tipoRemolqueService.save(semirremolque);
    	tipoRemolqueService.save(trenCarretera);
    	tipoRemolqueService.save(frigos);
    	tipoRemolqueService.save(calorifico);
    	tipoRemolqueService.save(cisterna);
    	tipoRemolqueService.save(plataforma);
    	tipoRemolqueService.save(portaContenedores);
    	tipoRemolqueService.save(portaCoches);
    	tipoRemolqueService.save(basculante);
    	tipoRemolqueService.save(especiales);*/
    	
        
    }

}
