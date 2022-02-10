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
package com.conagopare.conagoparech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conagopare.conagoparech.entities.periodoPago;

import java.util.Optional;

@Repository
public interface periodoPagoRepository extends JpaRepository<periodoPago, Long> {

	Optional <periodoPago> findByIdPeriodoPago(Long idPeriodoPago);
	
	void deleteByIdPeriodoPago(Long idPeriodoPago);
	
}
