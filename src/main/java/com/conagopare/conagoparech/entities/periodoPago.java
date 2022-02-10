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
@Table(name = "periodoPago")
public class periodoPago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPeriodoPago;
	
	private String nombrePeriodoPago;
	private Double periodoPago;
	
	public Long getIdPeriodoPago() {
		return idPeriodoPago;
	}
	
	public void setIdPeriodoPago(Long idPeriodoPago) {
		this.idPeriodoPago = idPeriodoPago;
	}
	
	public String getNombrePeriodoPago() {
		return nombrePeriodoPago;
	}
	
	public void setNombrePeriodoPago(String nombrePeriodoPago) {
		this.nombrePeriodoPago = nombrePeriodoPago;
	}
	
	public Double getPeriodoPago() {
		return periodoPago;
	}
	
	public void setPeriodoPago(Double periodoPago) {
		this.periodoPago = periodoPago;
	}
	
}
