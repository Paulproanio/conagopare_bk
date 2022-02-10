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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
	
@Entity
@Table(name = "bloque")
public class bloque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBloque;
	
	private String descripcionBloque;
	
	public Long getIdBloque() {
		return idBloque;
	}
	
	public void setIdBloque(Long idBloque) {
		this.idBloque = idBloque;
	}
	
	public String getDescripcionBloque() {
		return descripcionBloque;
	}
	
	public void setDescripcionBloque(String descripcionBloque) {
		this.descripcionBloque = descripcionBloque;
	}
}
