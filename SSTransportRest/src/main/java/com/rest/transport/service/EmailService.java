package com.rest.transport.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.rest.transport.entities.Email;
import com.rest.transport.repository.EmailRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Collection;
import java.util.Optional;




@Service
public class EmailService {

	 @Autowired
	    private JavaMailSender mailSender;
	
	 @Autowired
	 	private EmailRepository mensajeRepository;
	 

	    public void sendSimpleEmail(Email mensaje) {
	        SimpleMailMessage message = new SimpleMailMessage();

	        message.setFrom("onussarasebas@gmail.com");
	        message.setTo(mensaje.getDestinatario());
	        message.setText(mensaje.getTexto() + mensaje.getUrl());
	        message.setSubject(mensaje.getAsunto());

	        mailSender.send(message);
	        System.out.println("Mail Send...");
	        
	        mensajeRepository.save(mensaje);
	    }
	    
	    public void sendConfirmationEmail(String email, Long id) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        String texto = "Email de confirmacion para acceder a onus:  ";
	        String url = "http://localhost:4200/confirmacion?q="+id;
	        message.setFrom("onussarasebas@gmail.com");
	        message.setTo(email);
	        message.setText(texto + url);
	        message.setSubject("Email de confirmacion");

	        mailSender.send(message);
	        System.out.println("Mail Send...");
	        
	    }

	    public void sendEmailWithAttachment(String toEmail,
	                                        String body,
	                                        String subject,
	                                        String attachment) throws MessagingException {

	        MimeMessage mimeMessage = mailSender.createMimeMessage();

	        MimeMessageHelper mimeMessageHelper
	                = new MimeMessageHelper(mimeMessage, true);

	        mimeMessageHelper.setFrom("spring.email.from@gmail.com");
	        mimeMessageHelper.setTo(toEmail);
	        mimeMessageHelper.setText(body);
	        mimeMessageHelper.setSubject(subject);

	        FileSystemResource fileSystem
	                = new FileSystemResource(new File(attachment));

	        mimeMessageHelper.addAttachment(fileSystem.getFilename(),
	                fileSystem);

	        mailSender.send(mimeMessage);
	        System.out.println("Mail Send...");
	

}
	    
	    public Optional<Email> findByIdEmpresaTransporteEmail(Long idEmpresa , String email) {
	    	return mensajeRepository.findByInvitacionDeTransporteIdAndDestinatario(idEmpresa, email);
	    }
	    
	    public Optional<Email> findByIdEmpresaPorteEmail(Long idEmpresa , String email) {
	    	return mensajeRepository.findByInvitacionDePorteIdAndDestinatario(idEmpresa, email);
	    }
	    
	    public boolean existsByInvitacionDeTransporteIdAndDestinatario(Long idEmpresa , String email) {
	    	return mensajeRepository.existsByInvitacionDeTransporteIdAndDestinatario(idEmpresa, email);
	    }
	    
	    public boolean existsByInvitacionDePorteIdAndDestinatario(Long idEmpresa , String email) {
	    	return mensajeRepository.existsByInvitacionDePorteIdAndDestinatario(idEmpresa, email);
	    }
	    
	    
	    public Collection<Email>findAllTransporte(Long idEmpresa){
	    	return mensajeRepository.findByInvitacionDeTransporteId(idEmpresa);
	    }
	    
	    public Collection<Email>findAllPorte(Long idEmpresa){
	    	return mensajeRepository.findByInvitacionDePorteId(idEmpresa);
	    }
	    
	    public void deleteEmail(Long idEmail) {
	    	mensajeRepository.deleteById(idEmail);
	    }

	
	    
}
