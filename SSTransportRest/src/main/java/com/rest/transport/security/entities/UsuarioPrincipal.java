package com.rest.transport.security.entities;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rest.transport.entities.CuentaBancaria;
import com.rest.transport.entities.Direccion;
import com.rest.transport.entities.Provincia;

public class UsuarioPrincipal implements UserDetails {
	
	private String nombre;
	private String nombreUsuario;
	private String password;
	private String documento;
	private String email;
	private String telefono;
	private boolean activo;
	private Direccion residenteDeDireccion;
	private Provincia operadorDeProvincia;
	private CuentaBancaria cuentaBancaria;
	private Collection<?extends GrantedAuthority> authorities;
	
	
	public UsuarioPrincipal(String nombre, String nombreUsuario,String password , String documento, String email, String telefono, boolean activo,Direccion residenteDeDireccion,
			Provincia operadorDeProvincia,CuentaBancaria cuentaBancaria,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.documento = documento;
		this.email = email;
		this.telefono = telefono;
		this.activo = activo;
		this.residenteDeDireccion = residenteDeDireccion;
		this.operadorDeProvincia = operadorDeProvincia;
		this.cuentaBancaria = cuentaBancaria;
		this.authorities = authorities;
	}
	
	public static UsuarioPrincipal build(Usuario usuario) {
		List<GrantedAuthority>authorities = usuario.getRoles().stream().map(
		rol-> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());	
		return new UsuarioPrincipal(usuario.getNombre() , usuario.getNombreUsuario(),
				usuario.getPassword() , usuario.getDocumento() , usuario.getEmail(),usuario.getTelefono(),usuario.isActivo(),usuario.getResidenteDeDireccion(),usuario.getOperadorDeProvincia(),usuario.getCuentaBancaria(), authorities);
	}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nombreUsuario;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}

	public boolean isActivo() {
		return activo;
	}
	
	public Direccion getResidenteDeDireccion() {
		return residenteDeDireccion;
	}

	public Provincia getOperadorDeProvincia() {
		return operadorDeProvincia;
	}

	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}


	
	

	
	
	
	
}
