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
import com.conagopare.conagoparech.entities.estadoPago;
import com.conagopare.conagoparech.repositories.estadoPagoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class estadoPagoService {

	@Autowired
	estadoPagoRepository repo;

	public List<estadoPago> getAll(){
		List<estadoPago> estadoPagoList = repo.findAll();
		if(estadoPagoList.size() > 0) {
			return estadoPagoList;
		} else {
			return new ArrayList<estadoPago>();
		}
	}
     		
	public estadoPago findByIdEstadoPago(Long idEstadoPago) throws RecordNotFoundException{
		Optional<estadoPago> estadoPago = repo.findByIdEstadoPago(idEstadoPago);
		if(estadoPago.isPresent()) {
			return estadoPago.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public estadoPago createestadoPago(estadoPago estadoPago){
		return repo.save(estadoPago);
	}

	public estadoPago updateestadoPago(estadoPago estadoPago) throws RecordNotFoundException {
		Optional<estadoPago> estadoPagoTemp = repo.findByIdEstadoPago(estadoPago.getIdEstadoPago());
	
		if(estadoPagoTemp.isPresent()){
			return repo.save(estadoPago);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteestadoPagoByIdEstadoPago(Long idEstadoPago) throws RecordNotFoundException{
		Optional<estadoPago> estadoPago = repo.findByIdEstadoPago(idEstadoPago);
		if(estadoPago.isPresent()) {
		repo.deleteByIdEstadoPago(idEstadoPago);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
