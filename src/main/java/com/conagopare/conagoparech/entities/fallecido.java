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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;
import javax.persistence.Basic;
import org.hibernate.annotations.CreationTimestamp;
	
@Entity
@Table(name = "fallecido")
public class fallecido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFallecido;
	
	private String nombreFallecido;
	@Basic
	//@CreationTimestamp
	private Date fechFallecimiento;
	
	@ManyToOne
	@JoinColumn(name="idRepresentante")
	private representante representante;
	

	private String codigoNicho;
	@ManyToOne
	@JoinColumn(name="idNicho")	
	private nicho nicho;
	
	
	public Long getIdFallecido() {
		return idFallecido;
	}
	
	public void setIdFallecido(Long idFallecido) {
		this.idFallecido = idFallecido;
	}
	
	public String getNombreFallecido() {
		return nombreFallecido;
	}
	
	public void setNombreFallecido(String nombreFallecido) {
		this.nombreFallecido = nombreFallecido;
	}
	
	public Date getFechFallecimiento() {
		return fechFallecimiento;
	}
	
	public void setFechFallecimiento(Date fechFallecimiento) {
		this.fechFallecimiento = fechFallecimiento;
	}

	public representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(representante representante) {
		this.representante = representante;
	}

	public String getCodigoNicho() {
		return codigoNicho;
	}

	public void setCodigoNicho(String codigoNicho) {
		this.codigoNicho = codigoNicho;
	}

	public nicho getNicho() {
		return nicho;
	}

	public void setNicho(nicho nicho) {
		this.nicho = nicho;
	}
	
}
