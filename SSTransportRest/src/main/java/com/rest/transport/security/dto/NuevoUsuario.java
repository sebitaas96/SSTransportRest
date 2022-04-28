package com.rest.transport.security.dto;


import java.util.Collection;

import javax.persistence.Column;

import com.rest.transport.entities.CuentaBancaria;
import com.rest.transport.entities.Direccion;
import com.rest.transport.entities.Provincia;


public class NuevoUsuario {
	
		@Column(nullable=false)
	    private String nombre;
	    
		@Column(nullable=false)
	    private String nombreUsuario;
		
		@Column(nullable=false)
	    private String password;
	    
		@Column(nullable=false)
		private String documento;
		
		@Column(nullable=false)
	    private String email;
		
		@Column(nullable=false)
		private String telefono;
		
		@Column(nullable=true)
		private Direccion residenteDeDireccion;
		
		@Column(nullable=true)
		private Provincia operadorDeProvincia;
		@Column(nullable=true)
		private CuentaBancaria cuentaBancaria;
		
	    private Collection<String>roles;

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

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

		public String getDocumento() {
			return documento;
		}

		public void setDocumento(String documento) {
			this.documento = documento;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public Direccion getResidenteDeDireccion() {
			return residenteDeDireccion;
		}

		public void setResidenteDeDireccion(Direccion residenteDeDireccion) {
			this.residenteDeDireccion = residenteDeDireccion;
		}

		public Provincia getOperadorDeProvincia() {
			return operadorDeProvincia;
		}

		public void setOperadorDeProvincia(Provincia operadorDeProvincia) {
			this.operadorDeProvincia = operadorDeProvincia;
		}

		public CuentaBancaria getCuentaBancaria() {
			return cuentaBancaria;
		}

		public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
			this.cuentaBancaria = cuentaBancaria;
		}

		public Collection<String> getRoles() {
			return roles;
		}

		public void setRoles(Collection<String> roles) {
			this.roles = roles;
		}

	    



}
