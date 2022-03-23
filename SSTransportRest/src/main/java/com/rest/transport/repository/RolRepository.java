package com.rest.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
