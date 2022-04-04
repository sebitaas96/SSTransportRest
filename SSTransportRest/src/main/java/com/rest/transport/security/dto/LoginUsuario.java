package com.rest.transport.security.dto;

import javax.persistence.Column;

public class LoginUsuario {
	
		
	@Column(nullable=false)
    private String nombreUsuario;

	
	@Column(nullable=false)
    private String password;

	public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
