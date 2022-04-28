
package com.rest.transport.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Email {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String destinatario;
	private String asunto;
	private String texto;
	private String url;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne(optional=true)
	private Transporte invitacionDeTransporte;

	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne(optional=true)
	private Porte invitacionDePorte;
	
	public Email() {
		
	}
	
	public Email(String destinatario, String asunto, String texto, String url,Transporte invitacionDeTransporte , 
			Porte invitacionDePorte) {
		super();
		this.destinatario = destinatario;
		this.asunto = asunto;
		this.texto = texto;
		this.url = url;
		this.invitacionDeTransporte = invitacionDeTransporte;
		this.invitacionDePorte = invitacionDePorte;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Transporte getInvitacionDeTransporte() {
		return invitacionDeTransporte;
	}

	public void setInvitacionDeTransporte(Transporte invitacionDeTransporte) {
		this.invitacionDeTransporte = invitacionDeTransporte;
		//this.invitacionDeTransporte.getInvitaciones().add(this);
	}

	public Porte getInvitacionDePorte() {
		return invitacionDePorte;
	}

	public void setInvitacionDePorte(Porte invitacionDePorte) {
		this.invitacionDePorte = invitacionDePorte;
		//this.invitacionDePorte.getInvitaciones().add(this);
	}
	
	
	

	
	

}
