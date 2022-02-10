																/*
 -------------------------------------------------------------------
|
| University: 	ESPOCH Escuela Superior Politécnica del Chimborazo 
| Project: 		Conagopare Chimborazo.
| Author: 		Anastasia MInina, Cristopher García, Raúl Medina, Paúl Proaño (2021)
| File Date: Tue Jul 20 23:25:13 COT 2021
| 
 -------------------------------------------------------------------
																*/
package com.conagopare.conagoparech.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;	
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
	
@Entity
@Table(name = "estadoNicho")
public class estadoNicho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstadoNicho;
	
	private String descripcionEstadoNicho;
	
	public Long getIdEstadoNicho() {
		return idEstadoNicho;
	}
	
	public void setIdEstadoNicho(Long idEstadoNicho) {
		this.idEstadoNicho = idEstadoNicho;
	}
	
	public String getDescripcionEstadoNicho() {
		return descripcionEstadoNicho;
	}
	
	public void setDescripcionEstadoNicho(String descripcionEstadoNicho) {
		this.descripcionEstadoNicho = descripcionEstadoNicho;
	}
	
}
