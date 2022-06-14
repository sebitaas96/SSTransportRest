package com.rest.transport.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rest.transport.dto.NuevaNotificacion;
import com.rest.transport.entities.Gravedad;
import com.rest.transport.entities.Notificacion;
import com.rest.transport.entities.Pago;
import com.rest.transport.repository.GravedadRepository;
import com.rest.transport.repository.NotificacionRepository;
import com.rest.transport.security.entities.Usuario;
import com.rest.transport.security.repository.UsuarioRepository;

@Service
public class NotificacionService {
	
	@Autowired
	NotificacionRepository notificacionRepository;
	
	@Autowired
	GravedadRepository gravedadRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public void save(NuevaNotificacion nuevaNotificacion){
		Usuario u = usuarioRepository.getById(nuevaNotificacion.getIdUsuario());
		Gravedad v = gravedadRepository.getById(nuevaNotificacion.getIdGravedad());
		
		Notificacion n = new Notificacion();
		n.setFecha(nuevaNotificacion.getFecha());
		n.setNombre(nuevaNotificacion.getNombre());
		n.setNotificacionDeGravedad(v);
		n.setNotificacionDeUsuario(u);
		notificacionRepository.saveAndFlush(n);
	}
	
	
	public Collection<Notificacion> findAll(Long idUsuario){
		return notificacionRepository.findByNotificacionDeUsuarioId(idUsuario);
	}
	
	public void deleteNotificacion( Long idNotificacion) {
		try {
			notificacionRepository.deleteById(idNotificacion);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
