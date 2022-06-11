package com.rest.transport.cron;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rest.transport.entities.Viaje;
import com.rest.transport.service.ViajeService;

@Component
public class RenewViajes {

	@Autowired
	ViajeService viajeService;
	
	@Scheduled(cron="0 0/1 * * * *")
	public void comprobarViajes() {
		Collection<Viaje> viajes = viajeService.findAllPanel();
		Date fecha = new Date();
		
		for(Viaje v:viajes){
			if(v.getfHoraInicio().getTime()<fecha.getTime()){
				viajeService.caducarEstado(v);
				System.out.println("caducado");
			}
		}
	}
	
}
