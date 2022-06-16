package com.rest.transport.service;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transport.dto.AsignarCamion;
import com.rest.transport.dto.AsignarConductor;
import com.rest.transport.dto.AsignarRemolque;
import com.rest.transport.dto.ReactivarViaje;
import com.rest.transport.dto.ReservarViaje;
import com.rest.transport.dto.UpdateFecha;
import com.rest.transport.entities.Camion;
import com.rest.transport.entities.Conductor;
import com.rest.transport.entities.Direccion;
import com.rest.transport.entities.Estado;
import com.rest.transport.entities.Expedidor;
import com.rest.transport.entities.Porte;
import com.rest.transport.entities.Remolque;
import com.rest.transport.entities.Transporte;
import com.rest.transport.entities.Viaje;
import com.rest.transport.repository.CamionRepository;
import com.rest.transport.repository.ConductorRepository;
import com.rest.transport.repository.DireccionRepository;
import com.rest.transport.repository.EstadoRepository;
import com.rest.transport.repository.ExpedidorRepository;
import com.rest.transport.repository.PorteRepository;
import com.rest.transport.repository.RemolqueRepository;
import com.rest.transport.repository.TransporteRepository;
import com.rest.transport.repository.ViajeRepository;


@Service
public class ViajeService {

	@Autowired
	ViajeRepository viajeRepository;
	
	@Autowired
	DireccionRepository direccionRepository;
	
	@Autowired
	TransporteRepository transporteRepository;
	
	@Autowired
	ConductorRepository conductoRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	ConductorRepository conductorRepository;
	
	@Autowired
	CamionRepository camionRepository;
	
	@Autowired
	RemolqueRepository remolqueRepository;
	
	@Autowired
	ExpedidorRepository expedidorRepository;
	
	@Autowired
	PorteRepository porteRepository;
	
	@Autowired
	CamionService camionService;
	
	@Autowired
	RemolqueService remolqueService;
	
	public void save(Viaje viaje) {
		System.out.println("Guardando viaje");
		Direccion recogida =  new Direccion(
				viaje.getRecogidaDeDireccion().getTipo(),
				viaje.getRecogidaDeDireccion().getNombre(),
				viaje.getRecogidaDeDireccion().getNumero(),
				viaje.getRecogidaDeDireccion().getDireccionDeLocalidad()
				);
		Direccion recogidaS =direccionRepository.saveAndFlush(recogida);
		Direccion entrega =  new Direccion(
				viaje.getEntregaDeDireccion().getTipo(),
				viaje.getEntregaDeDireccion().getNombre(),
				viaje.getEntregaDeDireccion().getNumero(),
				viaje.getEntregaDeDireccion().getDireccionDeLocalidad()
				);
		Direccion entregaS = direccionRepository.saveAndFlush(entrega);
		viaje.setRecogidaDeDireccion(recogidaS);
		viaje.setEntregaDeDireccion(entregaS);
		try {
			Estado estado = estadoRepository.findByNombre("Expedido");
			viaje.setViajeDeEstado(estado);
			viajeRepository.saveAndFlush(viaje);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public Collection<Viaje>findAll(Long idEmpresa){
		return viajeRepository.findByViajeDePorteId(idEmpresa);
		
	}
	
	public Collection<Viaje>findAllTransporte(Long idEmpresa){
		return viajeRepository.findByViajeDeTransporteId(idEmpresa);
		
	}
	
	
	public Collection<Viaje>findAllPanel(){
		Estado estado = estadoRepository.findByNombre("Expedido");
		return viajeRepository.findByViajeDeEstadoId(estado.getId());
		
	}
	
	public Collection<Viaje>findAllReservado(){
		Estado estado = estadoRepository.findByNombre("Reservado");
		return viajeRepository.findByViajeDeEstadoId(estado.getId());
	}
	
	public Collection<Viaje>findAllExpedidor(Long idExpedidor){
		return viajeRepository.findByViajeDeExpedidorId(idExpedidor);
		
	}
	
	public Collection<Viaje>findAllConductor(Long idConductor){
		return viajeRepository.findByViajeDeConductorId(idConductor);
		
	}
	
	public Optional<Viaje> findViajeId(Long idViaje) {
		return viajeRepository.findById(idViaje);
	}
	
	public Optional<Viaje> findViajeIdPago(Long idPago) {
		return viajeRepository.findByPagoId(idPago);
	}
	
	public void reservarViaje(ReservarViaje reservarViaje) throws Exception {
		Viaje v = viajeRepository.getById(reservarViaje.getIdViaje());
		if(v.getViajeDeEstado().getNombre().equals("Expedido")) {
			Transporte t = transporteRepository.getById(reservarViaje.getTransporte().getId());
			v.setViajeDeTransporte(t);
			if(reservarViaje.getConductor() !=null) {
				boolean haveOtherTrip=false;
				Collection <Viaje> viajes = viajeRepository.findByViajeDeConductorId(reservarViaje.getConductor().getId());
				
				for(Viaje viaje:viajes) {
					if(viaje.getId() != v.getId() && viaje.getViajeDeEstado().getNombre().equals("Reservado")
							|| viaje.getId() != v.getId() && viaje.getViajeDeEstado().getNombre().equals("Transito")) {
						if(viaje.getfHoraInicio().getTime() == v.getfHoraInicio().getTime()) {
							throw new Exception("Ya tienes un viaje asignado para esta fecha y hora");
						}
						else if(v.getfHoraInicio().getTime() < viaje.getfHoraInicio().getTime()
								&& v.getfHoraFin().getTime() >=viaje.getfHoraInicio().getTime() 
								) {
							throw new Exception("La hora de finalizacion del viaje se contrapea con la de inicio de otro viaje asignado");
						}
						else if(v.getfHoraInicio().getTime() > viaje.getfHoraInicio().getTime() &&
								v.getfHoraInicio().getTime() < viaje.getfHoraFin().getTime() 
								) {
							throw new Exception("La hora de inicio del viaje se contrapea con otro viaje asignado");
						}
					}
				}
				
				System.out.println("SI HAY CONDUCTOR");
				boolean haveCamion = false;
				boolean haveRemolque = false;	
				Collection<Camion> cam = camionService.findAllConductor(reservarViaje.getConductor().getId());
			

				for(Camion camion : cam) {
					if(camion.getCamionDeTipoCamion().getId() == v.getViajeDeTipoCamion().getId()) {
						haveCamion = true;
					}
				}
				
				if(v.getViajeDeTipoRemolque()!=null) {
					Collection<Remolque> rem = remolqueService.findAllConductor(reservarViaje.getConductor().getId());
					for(Remolque remolque : rem) {
						if(remolque.getRemolqueDeTipoRemolque().getId()== v.getViajeDeTipoRemolque().getId()) {
							haveRemolque = true;
						}
					}
					if(haveCamion && haveRemolque) {
						Conductor c = conductorRepository.getById(reservarViaje.getConductor().getId());
						v.setViajeDeConductor(c);;
					}
					else {
						throw new Exception("El conductor no dispone del equipo necesario");
					}
				}else {
					if(haveCamion) {
						Conductor c = conductorRepository.getById(reservarViaje.getConductor().getId());
						v.setViajeDeConductor(c);;
					}
					else {
						throw new Exception("El conductor no dispone del equipo necesario");
					}
				}
					
				
			}
				Estado e = estadoRepository.findByNombre("Reservado");
				v.setViajeDeEstado(e);
				viajeRepository.saveAndFlush(v);	
			
			
		}
		else {
			throw new Exception("El viaje ya no esta disponible");
		}
		
	}
	
	public void caducarEstado(Viaje v) {
		Estado estado = estadoRepository.findByNombre("Caducado");
		v.setViajeDeEstado(estado);
		viajeRepository.saveAndFlush(v);
	}
	
	
	public void transitoEstado(Viaje v){
		System.out.println("Y ahor aqui");
		Estado estado = estadoRepository.findByNombre("Transito");
		v.setViajeDeEstado(estado);
		viajeRepository.saveAndFlush(v);
	}
	
	public void cancelarViaje(Long idViaje) {
		Estado e = estadoRepository.findByNombre("Caducado");
		Viaje v = viajeRepository.getById(idViaje);
		v.setViajeDeEstado(e);
		v.setViajeDeConductor(null);
		v.setViajeDeCamion(null);
		v.setViajeDeRemolque(null);
		viajeRepository.saveAndFlush(v);
	}
	
	public void iniciarViaje(Long idViaje) {
		System.out.println("o aqui");
		Estado e = estadoRepository.findByNombre("Transito");
		Viaje v = viajeRepository.getById(idViaje);
		v.setViajeDeEstado(e);
		viajeRepository.saveAndFlush(v);
	}
	
	public void finalizarViaje(Long idViaje) {
		System.out.println("Estoy aqui");
		System.out.println(idViaje);
		Estado e = estadoRepository.findByNombre("Finalizado");
		System.out.println(e.getId());
		Viaje v = viajeRepository.getById(idViaje);
		v.setViajeDeEstado(e);
		viajeRepository.saveAndFlush(v);
	}
	
	
	
	public void reactivarViaje(ReactivarViaje reactivarViaje) {
		Estado e = estadoRepository.findByNombre("Expedido");
		Viaje v = viajeRepository.getById(reactivarViaje.getIdViaje());
		v.setfHoraInicio(reactivarViaje.getfInicio());
		v.setfHoraFin(reactivarViaje.getfFin());
		v.setViajeDeEstado(e);
		viajeRepository.saveAndFlush(v);
	}
	
	public void asignarConductor(AsignarConductor asignarConductor) throws Exception {
		Viaje v = viajeRepository.getById(asignarConductor.getIdViaje());
		
		boolean haveOtherTrip=false;
		Collection <Viaje> viajes = viajeRepository.findByViajeDeConductorId(asignarConductor.getConductor().getId());
		
		for(Viaje viaje:viajes) {
			if(viaje.getId() != v.getId() && viaje.getViajeDeEstado().getNombre().equals("Reservado")
					|| viaje.getId() != v.getId() && viaje.getViajeDeEstado().getNombre().equals("Transito")) {
				if(viaje.getfHoraInicio().getTime() == v.getfHoraInicio().getTime()) {
					throw new Exception("El conductor ya tiene un viaje asignado para esta fecha y hora");
				}
				else if(v.getfHoraInicio().getTime() < viaje.getfHoraInicio().getTime()
						&& v.getfHoraFin().getTime() >=viaje.getfHoraInicio().getTime() 
						) {
					throw new Exception("La hora de finalizacion del viaje se contrapea con la de inicio de otro viaje asignado");
				}
				else if(v.getfHoraInicio().getTime() > viaje.getfHoraInicio().getTime() &&
						v.getfHoraInicio().getTime() < viaje.getfHoraFin().getTime() 
						) {
					throw new Exception("La hora de inicio del viaje se contrapea con otro viaje asignado");
				}
			}
		}
		
		
		
		boolean haveCamion = false;
		boolean haveRemolque = false;	
		Collection<Camion> cam = camionService.findAllConductor(asignarConductor.getConductor().getId());
	

		
		for(Camion camion : cam) {
			if(camion.getCamionDeTipoCamion().getId() == v.getViajeDeTipoCamion().getId()) {
				haveCamion = true;
			}
		}
		
		if(v.getViajeDeTipoRemolque()!=null) {
			Collection<Remolque> rem = remolqueService.findAllConductor(asignarConductor.getConductor().getId());
			for(Remolque remolque : rem) {
				if(remolque.getRemolqueDeTipoRemolque().getId()== v.getViajeDeTipoRemolque().getId()) {
					haveRemolque = true;
				}
			}
			if(haveCamion && haveRemolque) {
				Conductor c = conductorRepository.getById(asignarConductor.getConductor().getId());
				v.setViajeDeConductor(c);;
				viajeRepository.saveAndFlush(v);
			}
			else {
				throw new Exception("El conductor no dispone del equipo necesario");
			}
		}else {
			if(haveCamion) {
				Conductor c = conductorRepository.getById(asignarConductor.getConductor().getId());
				v.setViajeDeConductor(c);;
				viajeRepository.saveAndFlush(v);
			}
			else {
				throw new Exception("El conductor no dispone del equipo necesario");
			}
		}
		
		
	}
	
	public void asignarCamion(AsignarCamion asignarCamion) throws Exception {
		Viaje v  = viajeRepository.getById(asignarCamion.getIdViaje());
		Camion c = camionRepository.getById(asignarCamion.getCamion().getId());
		
		if(!c.isEstado()) {
			throw new Exception("El vehículo no esta activo");
		}
		
		v.setViajeDeCamion(c);
		viajeRepository.saveAndFlush(v);
	}
	
	public void asignarRemolque(AsignarRemolque asignarRemolque) throws Exception {
		Viaje v  = viajeRepository.getById(asignarRemolque.getIdViaje());
		Remolque r = remolqueRepository.getById(asignarRemolque.getRemolque().getId());
		
		if(!r.isEstado()) {
			throw new Exception("El vehículo no esta activo");
		}
		
		v.setViajeDeRemolque(r);
		viajeRepository.saveAndFlush(v);
	}
	
	public void updateConductor(Long idViaje) {
		Viaje v = viajeRepository.getById(idViaje);
		Conductor c = conductorRepository.getById(v.getViajeDeConductor().getId());
		if(v.getViajeDeCamion()!=null) {
			Camion cm = camionRepository.getById(v.getViajeDeCamion().getId());	
			cm.removeViaje(v);
		}
		
		if(v.getViajeDeRemolque()!=null) {
			Remolque r = remolqueRepository.getById(v.getViajeDeRemolque().getId());
			r.removeViaje(v);
		}
		
		c.removeViaje(v);
		viajeRepository.save(v);
	}
	
	public void updateFechaInicio(UpdateFecha updateFecha) {
		Viaje v  = viajeRepository.getById(updateFecha.getIdViaje());
		Date fin = new Date (updateFecha.getFecha().getTime() + (v.getTiempo()*1000));
		v.setfHoraFin(fin);
		v.setfHoraInicio(updateFecha.getFecha());
		viajeRepository.saveAndFlush(v);
	}
	
	public void updateFechaFin(UpdateFecha updateFecha) {
		Viaje v  = viajeRepository.getById(updateFecha.getIdViaje());
		v.setfHoraFin(updateFecha.getFecha());
		viajeRepository.saveAndFlush(v);
	}
	
	public void deleteViaje(Long idViaje) {
		viajeRepository.deleteById(idViaje);
	}
	
}
