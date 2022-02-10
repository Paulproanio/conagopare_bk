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
package com.conagopare.conagoparech.services;

import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.periodoPago;
import com.conagopare.conagoparech.repositories.periodoPagoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class periodoPagoService {

	@Autowired
	periodoPagoRepository repo;

	public List<periodoPago> getAll(){
		List<periodoPago> periodoPagoList = repo.findAll();
		if(periodoPagoList.size() > 0) {
			return periodoPagoList;
		} else {
			return new ArrayList<periodoPago>();
		}
	}
     		
	public periodoPago findByIdPeriodoPago(Long idPeriodoPago) throws RecordNotFoundException{
		Optional<periodoPago> periodoPago = repo.findByIdPeriodoPago(idPeriodoPago);
		if(periodoPago.isPresent()) {
			return periodoPago.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public periodoPago createperiodoPago(periodoPago periodoPago){
		return repo.save(periodoPago);
	}

	public periodoPago updateperiodoPago(periodoPago periodoPago) throws RecordNotFoundException {
		Optional<periodoPago> periodoPagoTemp = repo.findByIdPeriodoPago(periodoPago.getIdPeriodoPago());
	
		if(periodoPagoTemp.isPresent()){
			return repo.save(periodoPago);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteperiodoPagoByIdPeriodoPago(Long idPeriodoPago) throws RecordNotFoundException{
		Optional<periodoPago> periodoPago = repo.findByIdPeriodoPago(idPeriodoPago);
		if(periodoPago.isPresent()) {
		repo.deleteByIdPeriodoPago(idPeriodoPago);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
