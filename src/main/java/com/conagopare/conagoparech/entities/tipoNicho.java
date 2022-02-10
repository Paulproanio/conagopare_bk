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
@Table(name = "tipoNicho")
public class tipoNicho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoNicho;
	
	private String descripcionTipoNicho;
	private Double valorTipoNicho;
	
	public Long getIdTipoNicho() {
		return idTipoNicho;
	}
	
	public void setIdTipoNicho(Long idTipoNicho) {
		this.idTipoNicho = idTipoNicho;
	}
	
	public String getDescripcionTipoNicho() {
		return descripcionTipoNicho;
	}
	
	public void setDescripcionTipoNicho(String descripcionTipoNicho) {
		this.descripcionTipoNicho = descripcionTipoNicho;
	}
	
	public Double getValorTipoNicho() {
		return valorTipoNicho;
	}
	
	public void setValorTipoNicho(Double valorTipoNicho) {
		this.valorTipoNicho = valorTipoNicho;
	}
	
}
