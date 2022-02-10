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
package com.conagopare.conagoparech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conagopare.conagoparech.entities.tipoNicho;

import java.util.Optional;

@Repository
public interface tipoNichoRepository extends JpaRepository<tipoNicho, Long> {

	Optional <tipoNicho> findByIdTipoNicho(Long idTipoNicho);
	
	void deleteByIdTipoNicho(Long idTipoNicho);
	
}
