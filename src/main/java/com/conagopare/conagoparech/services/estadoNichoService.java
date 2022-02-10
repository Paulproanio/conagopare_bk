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
package com.conagopare.conagoparech.services;

import com.conagopare.conagoparech.repositories.estadoNichoRepository;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.estadoNicho;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class estadoNichoService {

	@Autowired
	estadoNichoRepository repo;

	public List<estadoNicho> getAll(){
		List<estadoNicho> estadoNichoList = repo.findAll();
		if(estadoNichoList.size() > 0) {
			return estadoNichoList;
		} else {
			return new ArrayList<estadoNicho>();
		}
	}
     		
	public estadoNicho findByIdEstadoNicho(Long idEstadoNicho) throws RecordNotFoundException{
		Optional<estadoNicho> estadoNicho = repo.findByIdEstadoNicho(idEstadoNicho);
		if(estadoNicho.isPresent()) {
			return estadoNicho.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public estadoNicho createestadoNicho(estadoNicho estadoNicho){
		return repo.save(estadoNicho);
	}

	public estadoNicho updateestadoNicho(estadoNicho estadoNicho) throws RecordNotFoundException {
		Optional<estadoNicho> estadoNichoTemp = repo.findByIdEstadoNicho(estadoNicho.getIdEstadoNicho());
	
		if(estadoNichoTemp.isPresent()){
			return repo.save(estadoNicho);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteestadoNichoByIdEstadoNicho(Long idEstadoNicho) throws RecordNotFoundException{
		Optional<estadoNicho> estadoNicho = repo.findByIdEstadoNicho(idEstadoNicho);
		if(estadoNicho.isPresent()) {
		repo.deleteByIdEstadoNicho(idEstadoNicho);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
