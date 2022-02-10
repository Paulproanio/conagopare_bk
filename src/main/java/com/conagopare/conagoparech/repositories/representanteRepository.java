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
package com.conagopare.conagoparech.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conagopare.conagoparech.entities.representante;

import java.util.Optional;

@Repository
public interface representanteRepository extends JpaRepository<representante, Long> {

	Optional <representante> findByIdRepresentante(Long idRepresentante);
	
	void deleteByIdRepresentante(Long idRepresentante);
	
	List<representante> findByCedulaRepresentanteContaining(String cedulaRepresentante);
	
	List<representante> findByNombreRepresentanteContaining(String nombreRepresentante);
	
}
