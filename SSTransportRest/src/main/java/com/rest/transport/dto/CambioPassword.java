package com.rest.transport.dto;

public class CambioPassword {
	
	private String pwd_vieja;
	private String pwd_nueva;
	private String pwd_nuevar;
	private Long id_usuario;
	
	public String getPwd_vieja() {
		return pwd_vieja;
	}
	public void setPwd_vieja(String pwd_vieja) {
		this.pwd_vieja = pwd_vieja;
	}
	public String getPwd_nueva() {
		return pwd_nueva;
	}
	public void setPwd_nueva(String pwd_nueva) {
		this.pwd_nueva = pwd_nueva;
	}
	public String getPwd_nuevar() {
		return pwd_nuevar;
	}
	public void setPwd_nuevar(String pwd_nuevar) {
		this.pwd_nuevar = pwd_nuevar;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	@Override
	public String toString() {
		return "CambioPassword [pwd_vieja=" + pwd_vieja + ", pwd_nueva=" + pwd_nueva + ", pwd_nuevar=" + pwd_nuevar
				+ ", id_usuario=" + id_usuario + "]";
	}
	
	
	
}
