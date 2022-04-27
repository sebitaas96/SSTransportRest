package com.rest.transport.security.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.security.entities.Rol;
import com.rest.transport.security.enums.RolNombre;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

	 Optional<Rol> findByRolNombre(RolNombre rolNombre);


}
