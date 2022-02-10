																/*
 -------------------------------------------------------------------
|
| University: 	ESPOCH Escuela Superior Politécnica del Chimborazo 
| Project: 		Conagopare Chimborazo.
| Author: 		Anastasia MInina, Cristopher García, Raúl Medina, Paúl Proaño (2021)
| File Date: 	Tue Jul 20 23:25:13 COT 2021
| 
 -------------------------------------------------------------------
																*/
package com.conagopare.conagoparech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimeZone;
import javax.annotation.PostConstruct;					

@SpringBootApplication
public class ConagoparechApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConagoparechApplication.class, args);
		System.out.println("Active resources for usuario entity");
		System.out.println("GET");
		System.out.println("/api/conagopare/usuario");
		System.out.println("/api/conagopare/usuario/{id}");
		System.out.println("POST");
		System.out.println("/api/conagopare/usuario");
		System.out.println("PUT");
		System.out.println("/api/conagopare/usuario");
		System.out.println("DELETE");
		System.out.println("/api/conagopare/usuario/{id}");
		System.out.println("Active resources for tipoUsuario entity");
		System.out.println("GET");
		System.out.println("/api/conagopare/tipoUsuario");
		System.out.println("/api/conagopare/tipoUsuario/{id}");
		System.out.println("POST");
		System.out.println("/api/conagopare/tipoUsuario");
		System.out.println("PUT");
		System.out.println("/api/conagopare/tipoUsuario");
		System.out.println("DELETE");
		System.out.println("/api/conagopare/tipoUsuario/{id}");
		System.out.println("Active resources for cementerio entity");
		System.out.println("GET");
		System.out.println("/api/conagopare/cementerio");
		System.out.println("/api/conagopare/cementerio/{id}");
		System.out.println("POST");
		System.out.println("/api/conagopare/cementerio");
		System.out.println("PUT");
		System.out.println("/api/conagopare/cementerio");
		System.out.println("DELETE");
		System.out.println("/api/conagopare/cementerio/{id}");
		System.out.println("Active resources for bloque entity");
		System.out.println("GET");
		System.out.println("/api/conagopare/bloque");
		System.out.println("/api/conagopare/bloque/{id}");
		System.out.println("POST");
		System.out.println("/api/conagopare/bloque");
		System.out.println("PUT");
		System.out.println("/api/conagopare/bloque");
		System.out.println("DELETE");
		System.out.println("/api/conagopare/bloque/{id}");
		System.out.println("Active resources for nicho entity");
		System.out.println("GET");
		System.out.println("/api/conagopare/nicho");
		System.out.println("/api/conagopare/nicho/{id}");
		System.out.println("POST");
		System.out.println("/api/conagopare/nicho");
		System.out.println("PUT");
		System.out.println("/api/conagopare/nicho");
		System.out.println("DELETE");
		System.out.println("/api/conagopare/nicho/{id}");
		System.out.println("Active resources for tipoNicho entity");
		System.out.println("GET");
		System.out.println("/api/conagopare/tipoNicho");
		System.out.println("/api/conagopare/tipoNicho/{id}");
		System.out.println("POST");
		System.out.println("/api/conagopare/tipoNicho");
		System.out.println("PUT");
		System.out.println("/api/conagopare/tipoNicho");
		System.out.println("DELETE");
		System.out.println("/api/conagopare/tipoNicho/{id}");
		System.out.println("Active resources for estadoNicho entity");
		System.out.println("GET");
		System.out.println("/api/conagopare/estadoNicho");
		System.out.println("/api/conagopare/estadoNicho/{id}");
		System.out.println("POST");
		System.out.println("/api/conagopare/estadoNicho");
		System.out.println("PUT");
		System.out.println("/api/conagopare/estadoNicho");
		System.out.println("DELETEe");
		System.out.println("/api/conagopare/estadoNicho/{id}");
		
	}
	
	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("America/Guayaquil"));
	}						
}
