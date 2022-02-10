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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;
import javax.persistence.Basic;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.CrossOrigin;
	
@Entity
@Table(name = "pago")
public class pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPago;
	
	private Double valorPago;
	@Basic
	//@CreationTimestamp
	private Date fechaPago;
	@Basic
	private Date fechaValidez;
	@ManyToOne
	@JoinColumn(name="idnicho")
	private nicho nicho;
	
	@ManyToOne
	@JoinColumn(name="idEstadoPago")
	private estadoPago estadoPago;
	
	private Long idTipoRegistroPago;
	
	public Long getIdPago() {
		return idPago;
	}
	
	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}
	
	public Double getValorPago() {
		return valorPago;
	}
	
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	
	public Date getFechaPago() {
		return fechaPago;
	}
	
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	public Date getFechaValidez() {
		return fechaValidez;
	}
	
	public void setFechaValidez(Date fechaValidez) {
		this.fechaValidez = fechaValidez;
	}
		
	public nicho getNicho() {
		return nicho;
	}

	public void setNicho(nicho nicho) {
		this.nicho = nicho;
	}

	public estadoPago getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(estadoPago estadoPago) {
		this.estadoPago = estadoPago;
	}

	public Long getIdTipoRegistroPago() {
		return idTipoRegistroPago;
	}
	
	public void setIdTipoRegistroPago(Long idTipoRegistroPago) {
		this.idTipoRegistroPago = idTipoRegistroPago;
	}
	
}
