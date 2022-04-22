package com.rest.transport.util;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class DeOfuscarUrl {

	public Map<String ,String> deofuscarUrl(String mensaje) {
			
		  Map<String ,String> datos = new HashMap<String ,String>();
		
		  byte[] decodedBytes = Base64.getDecoder().decode(mensaje);
		  String decodedString = new String(decodedBytes);
		  String[] parametros = decodedString.split("&");
		  
		  for(int i = 0 ; i<parametros.length ; i++) {
			  String[] claveValor = parametros[i].split("\\=");
			  datos.put(claveValor[0], claveValor[1]);
		  }
		return datos;
	}
	
	
	public String encodeToBase64(String message) {
		System.out.println("codificando");
	  String [] separado = message.split("\\?");
	  String devolucion = separado[0]+"?q="+Base64.getEncoder().encodeToString(separado[1].getBytes());
	  return devolucion;
}
	
}
