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
@Table(name = "cementerio")
public class cementerio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCementerio;
	
	private String nombreCementerio;
	private String parroquiaCementerio;
	private String direccionCementerio;
	
	public Long getIdCementerio() {
		return idCementerio;
	}
	
	public void setIdCementerio(Long idCementerio) {
		this.idCementerio = idCementerio;
	}
	
	public String getNombreCementerio() {
		return nombreCementerio;
	}
	
	public void setNombreCementerio(String nombreCementerio) {
		this.nombreCementerio = nombreCementerio;
	}
	
	public String getParroquiaCementerio() {
		return parroquiaCementerio;
	}
	
	public void setParroquiaCementerio(String parroquiaCementerio) {
		this.parroquiaCementerio = parroquiaCementerio;
	}
	
	public String getDireccionCementerio() {
		return direccionCementerio;
	}
	
	public void setDireccionCementerio(String direccionCementerio) {
		this.direccionCementerio = direccionCementerio;
	}
	
}
