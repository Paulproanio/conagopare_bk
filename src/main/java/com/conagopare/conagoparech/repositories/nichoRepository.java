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

import com.conagopare.conagoparech.entities.nicho;

import java.util.List;
import java.util.Optional;

@Repository
public interface nichoRepository extends JpaRepository<nicho, Long> {

	Optional <nicho> findByIdNicho(Long idNicho);
	
	void deleteByIdNicho(Long idNicho);
	
	@Query(value = "select * from nicho where id_estado_nicho = ?1", nativeQuery = true)
	List<nicho> findByEstadoNicho(Long idEstado);	
	
	@Query(value = "select * from nicho where  id_cementerio = ?1", nativeQuery = true)
	List<nicho> findByIdCementerio(Long idCementerio);	
	
	@Query(value = "SELECT * FROM nicho where numero_nicho = ?1", nativeQuery = true)
	List<nicho> findByNumNicho(Long numeronicho);	
	
	@Query(value = "select * from nicho where id_bloque = ?1", nativeQuery = true)
	List<nicho> findByIdBloque(Long idbloque);	
	
	@Query(value = "select * from nicho n inner join bloque b\r\n"
			+ "on n.id_bloque = b.id_bloque \r\n"
			+ "where n.id_estado_nicho= 2 and b.id_bloque = ?1", nativeQuery = true)
	List<nicho> findByNichosxIdBloque(Long idbloque);	
}
