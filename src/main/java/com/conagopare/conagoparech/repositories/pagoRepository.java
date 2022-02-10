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
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.conagopare.conagoparech.entities.fallecido;
import com.conagopare.conagoparech.entities.pago;

import java.util.List;
import java.util.Optional;

@Repository
public interface pagoRepository extends JpaRepository<pago, Long> {

	Optional <pago> findByIdPago(Long idPago);
	
	void deleteByIdPago(Long idPago);
	
	@Query(value = "SELECT * FROM pago WHERE  id_estado_pago = 1 and idnicho = ?1", nativeQuery = true)
	List<fallecido> findPagoByIdnicho(Long idnicho);
	
	@Query(value = "select * from pago pa \r\n"
			+ "inner join nicho n on pa.idnicho = n.id_nicho \r\n"
			+ "inner join fallecido f on n.id_nicho = f.id_nicho  \r\n"
			+ "inner join representante r on f.id_representante = r.id_representante\r\n"
			+ "where r.cedula_representante = ?1", nativeQuery = true)
	List<pago> findByPagoNichoRepresentnate(String cedularepresentante);
	
}
