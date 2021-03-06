package com.rest.transport.cron;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rest.transport.entities.Gravedad;
import com.rest.transport.entities.Notificacion;
import com.rest.transport.entities.Viaje;
import com.rest.transport.service.NotificacionService;
import com.rest.transport.service.ViajeService;

@Component
public class RenewViajes {

	@Autowired
	ViajeService viajeService;
	
	@Autowired
	NotificacionService notificacionService;
	
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
	
	@Scheduled(cron="0 0/1 * * * *")
	public void comprobarInicioViajes(){
		Collection<Viaje> viajes = viajeService.findAllReservado();
		Date fecha = new Date();
		
		for(Viaje v :viajes) {
			if(v.getfHoraInicio().getTime()<fecha.getTime()){
				if(v.getViajeDeConductor() != null && v.getViajeDeCamion()!=null ) {
					
					if(v.getViajeDeTipoRemolque() !=null) {
						if(v.getViajeDeRemolque() !=null) {
							viajeService.transitoEstado(v);
						}
						else {
							v.setViajeDeConductor(null);
							v.setViajeDeCamion(null);
							v.setViajeDeRemolque(null);
							viajeService.caducarEstado(v);
						}
					}
					else {
						viajeService.transitoEstado(v);		
					}
					
				}
				else {
					v.setViajeDeConductor(null);
					v.setViajeDeCamion(null);
					v.setViajeDeRemolque(null);
					viajeService.caducarEstado(v);
				}
			}
		}
		
	}
	
}
