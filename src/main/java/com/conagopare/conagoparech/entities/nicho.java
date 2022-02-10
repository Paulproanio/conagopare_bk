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
@Table(name = "nicho")
public class nicho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNicho;
	
	@ManyToOne
	@JoinColumn(name="idBloque")
	private bloque bloque;
	
	@ManyToOne
	@JoinColumn(name="idTipoNicho")
	private tipoNicho tipoNicho;
	
	@ManyToOne
	@JoinColumn(name="idEstadoNicho")
	private estadoNicho estadoNicho;
	
	@ManyToOne
	@JoinColumn(name="idCementerio")
	private cementerio cementerio;
	
	private Long numeroNicho;
	
	
	public Long getIdNicho() {
		return idNicho;
	}
	
	public void setIdNicho(Long idNicho) {
		this.idNicho = idNicho;
	}

	public bloque getBloque() {
		return bloque;
	}

	public void setBloque(bloque bloque) {
		this.bloque = bloque;
	}

	public tipoNicho getTipoNicho() {
		return tipoNicho;
	}

	public void setTipoNicho(tipoNicho tipoNicho) {
		this.tipoNicho = tipoNicho;
	}

	public estadoNicho getEstadoNicho() {
		return estadoNicho;
	}

	public void setEstadoNicho(estadoNicho estadoNicho) {
		this.estadoNicho = estadoNicho;
	}

	public cementerio getCementerio() {
		return cementerio;
	}

	public void setCementerio(cementerio cementerio) {
		this.cementerio = cementerio;
	}

	public Long getNumeroNicho() {
		return numeroNicho;
	}

	public void setNumeroNicho(Long numeroNicho) {
		this.numeroNicho = numeroNicho;
	}
	
}
