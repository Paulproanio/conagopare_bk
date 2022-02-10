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

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.conagopare.conagoparech.entities.fallecido;

import java.util.Optional;

@Repository
public interface fallecidoRepository extends JpaRepository<fallecido, Long> {

	Optional <fallecido> findByIdFallecido(Long idFallecido);
	
	void deleteByIdFallecido(Long idFallecido);
	
	List<fallecido> findByNombreFallecidoContaining(String nombreFallecido);
	
	List<fallecido> findAllByFechFallecimiento(Date fechFallecimiento);	
	
	@Query(value = "select * from representante r inner join fallecido f\r\n"
			+ "on r.id_representante = f.id_representante \r\n"
			+ "where cedula_representante = ?1", nativeQuery = true)
	List<fallecido> findNichosByCedulaRep(String cedulaRepresentante);
	
	@Query(value = "SELECT * FROM fallecido where codigo_nicho = ?1", nativeQuery = true)
	List<fallecido> findFallxCodnicho(String codigonicho);
	
}
