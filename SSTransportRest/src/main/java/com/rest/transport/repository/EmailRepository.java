package com.rest.transport.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.transport.entities.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

	Optional<Email>findByInvitacionDeTransporteIdAndDestinatario(Long idEmpresa , String email);
	Optional<Email>findByInvitacionDePorteIdAndDestinatario(Long idEmpresa , String email);
	boolean existsByInvitacionDeTransporteIdAndDestinatario(Long idEmpresa , String email);
	boolean existsByInvitacionDePorteIdAndDestinatario(Long idEmpresa , String email);
	List<Email>findByInvitacionDeTransporteId(Long idEmpresa);
	List<Email>findByInvitacionDePorteId(Long idEmpresa);
}
