																/*
 -------------------------------------------------------------------
|
| University: 	ESPOCH Escuela Superior Politécnica del Chimborazo 
| Project: 		Conagopare Chimborazo.
| Author: 		Anastasia MInina, Cristopher García, Raúl Medina, Paúl Proaño (2021)
| File Date: Sat Aug 14 18:29:17 COT 2021
| 
 -------------------------------------------------------------------
																*/
package com.conagopare.conagoparech.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Id;	
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
	
@Entity
@Table(name = "estadoPago")
public class estadoPago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstadoPago;
	
	private String nombreEstadoPago;

	
	public Long getIdEstadoPago() {
		return idEstadoPago;
	}
	
	public void setIdEstadoPago(Long idEstadoPago) {
		this.idEstadoPago = idEstadoPago;
	}
	
	public String getNombreEstadoPago() {
		return nombreEstadoPago;
	}
	
	public void setNombreEstadoPago(String nombreEstadoPago) {
		this.nombreEstadoPago = nombreEstadoPago;
	}	
}
