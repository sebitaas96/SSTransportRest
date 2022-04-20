package com.rest.transport.entities;


public class Mensaje {
	
	private String destinatario;
	private String asunto;
	private String texto;
	public Mensaje(String destinatario, String asunto, String texto) {
		super();
		this.destinatario = destinatario;
		this.asunto = asunto;
		this.texto = texto;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	

}
