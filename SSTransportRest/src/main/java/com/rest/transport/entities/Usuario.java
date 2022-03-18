package com.rest.transport.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	@Column(unique = true)
	private String documento;
	
	@Column(unique = true)
	private String email;
	
	private String telefono;
	
	
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Rol rolDeUsuario;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Direccion residenteDeDireccion;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Provincia operadorDeProvincia;
	
	
	@OneToMany(mappedBy = "camionDeUsuario" , cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Camion> camiones;
	
	@OneToMany(mappedBy = "remolqueDeUsuario" , cascade =  CascadeType.ALL)
	@JsonIgnore
	private Collection<Remolque> remolques;
	
	@OneToOne
	private CuentaBancaria  cuentaBancaria;
	
	public Usuario() {
		this.camiones = new ArrayList<Camion>();
		this.remolques = new ArrayList<Remolque>();
		
	}

	public Usuario(String nombre, String apellido, String documento, String email, String telefono, Rol rolDeUsuario,
			Direccion residenteDeDireccion, Provincia operadorDeProvincia, CuentaBancaria cuentaBancaria) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.email = email;
		this.telefono = telefono;
		this.rolDeUsuario = rolDeUsuario;
		this.rolDeUsuario.getUsuarios().add(this);
		this.residenteDeDireccion = residenteDeDireccion;
		this.residenteDeDireccion.getResidentes().add(this);
		this.operadorDeProvincia = operadorDeProvincia;
		this.operadorDeProvincia.getOperadores().add(this);
		this.cuentaBancaria = cuentaBancaria;
		this.camiones = new ArrayList<Camion>();
		this.remolques = new ArrayList<Remolque>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public Rol getRolDeUsuario() {
		return rolDeUsuario;
	}

	public void setRolDeUsuario(Rol rolDeUsuario) {
		this.rolDeUsuario = rolDeUsuario;
		this.rolDeUsuario.getUsuarios().add(this);
	}

	public Direccion getResidenteDeDireccion() {
		return residenteDeDireccion;
	}

	public void setResidenteDeDireccion(Direccion residenteDeDireccion) {
		this.residenteDeDireccion = residenteDeDireccion;
		this.residenteDeDireccion.getResidentes().add(this);
	}

	public Provincia getOperadorDeProvincia() {
		return operadorDeProvincia;
	}

	public void setOperadorDeProvincia(Provincia operadorDeProvincia) {
		this.operadorDeProvincia = operadorDeProvincia;
		this.operadorDeProvincia.getOperadores().add(this);
	}

	public Collection<Camion> getCamiones() {
		return camiones;
	}

	public void setCamiones(Collection<Camion> camiones) {
		this.camiones = camiones;
	}

	public Collection<Remolque> getRemolques() {
		return remolques;
	}

	public void setRemolques(Collection<Remolque> remolques) {
		this.remolques = remolques;
	}

	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	
	

}
