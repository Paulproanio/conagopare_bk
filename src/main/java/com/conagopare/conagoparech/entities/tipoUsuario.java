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
@Table(name = "tipoUsuario")
public class tipoUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoUsuario;
	
	private String descripcionTipoUsuario;
	
	public Long getIdTipoUsuario() {
		return idTipoUsuario;
	}
	
	public void setIdTipoUsuario(Long idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	
	public String getDescripcionTipoUsuario() {
		return descripcionTipoUsuario;
	}
	
	public void setDescripcionTipoUsuario(String descripcionTipoUsuario) {
		this.descripcionTipoUsuario = descripcionTipoUsuario;
	}
	
}
