package com.rest.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.transport.entities.TipoCamion;

@Repository
public interface TipoCamionRepository extends JpaRepository<TipoCamion, Long> {

}
