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
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.conagopare.conagoparech.entities.bloque;

import java.util.List;
import java.util.Optional;

@Repository
public interface bloqueRepository extends JpaRepository<bloque, Long> {

	Optional <bloque> findByIdBloque(Long idBloque);
	
	void deleteByIdBloque(Long idBloque);
	
	@Query(value = "select * from bloque where descripcion_bloque = ?1", nativeQuery = true)
	List<bloque> findByDescripcionBloque(String descbloque);	
	
}
