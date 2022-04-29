package com.rest.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.TipoRemolque;

@Repository
public interface TipoRemolqueRepository extends JpaRepository<TipoRemolque, Long> {

}
