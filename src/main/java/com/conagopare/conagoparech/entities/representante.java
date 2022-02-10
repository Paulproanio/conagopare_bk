																/*
 -------------------------------------------------------------------
|
| University: 	ESPOCH Escuela Superior Politécnica del Chimborazo 
| Project: 		Conagopare Chimborazo.
| Author: 		Anastasia MInina, Cristopher García, Raúl Medina, Paúl Proaño (2021)
| File Date: Tue Jul 27 21:25:09 COT 2021
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
@Table(name = "representante")
public class representante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRepresentante;
	
	private String cedulaRepresentante;
	private String nombreRepresentante;
	private String telefonoFijoRepresentante;
	private String telefonoCelRepresentante;
	private String direccionRepresentante;
	
	public Long getIdRepresentante() {
		return idRepresentante;
	}
	
	public void setIdRepresentante(Long idRepresentante) {
		this.idRepresentante = idRepresentante;
	}
	
	public String getCedulaRepresentante() {
		return cedulaRepresentante;
	}
	
	public void setCedulaRepresentante(String cedulaRepresentante) {
		this.cedulaRepresentante = cedulaRepresentante;
	}
	
	public String getNombreRepresentante() {
		return nombreRepresentante;
	}
	
	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}
	
	public String getTelefonoFijoRepresentante() {
		return telefonoFijoRepresentante;
	}
	
	public void setTelefonoFijoRepresentante(String telefonoFijoRepresentante) {
		this.telefonoFijoRepresentante = telefonoFijoRepresentante;
	}
	
	public String getTelefonoCelRepresentante() {
		return telefonoCelRepresentante;
	}
	
	public void setTelefonoCelRepresentante(String telefonoCelRepresentante) {
		this.telefonoCelRepresentante = telefonoCelRepresentante;
	}
	
	public String getDireccionRepresentante() {
		return direccionRepresentante;
	}
	
	public void setDireccionRepresentante(String direccionRepresentante) {
		this.direccionRepresentante = direccionRepresentante;
	}
	
}
