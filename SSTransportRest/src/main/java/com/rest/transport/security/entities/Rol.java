package com.rest.transport.security.entities;

import java.util.ArrayList;



import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest.transport.security.enums.RolNombre;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	@Enumerated(EnumType.STRING)
	private RolNombre rolNombre;

	@ManyToMany(mappedBy="roles",cascade = CascadeType.ALL)
	private Collection<Usuario>usuarios;

	
	
	public Rol() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public Rol(RolNombre nombre) {
		super();
		this.rolNombre = nombre;
		this.usuarios = new ArrayList<Usuario>();
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RolNombre getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(RolNombre rolNombre) {
		this.rolNombre = rolNombre;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	



	
	
	
	
	
}
