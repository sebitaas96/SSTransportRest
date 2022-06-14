package com.rest.transport.repository;

import java.util.Collection;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Notificacion;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
	Collection<Notificacion>findByNotificacionDeUsuarioId(Long idUsuario);
}
