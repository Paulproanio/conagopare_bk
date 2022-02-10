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

import com.conagopare.conagoparech.repositories.tipoNichoRepository;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.tipoNicho;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class tipoNichoService {

	@Autowired
	tipoNichoRepository repo;

	public List<tipoNicho> getAll(){
		List<tipoNicho> tipoNichoList = repo.findAll();
		if(tipoNichoList.size() > 0) {
			return tipoNichoList;
		} else {
			return new ArrayList<tipoNicho>();
		}
	}
     		
	public tipoNicho findByIdTipoNicho(Long idTipoNicho) throws RecordNotFoundException{
		Optional<tipoNicho> tipoNicho = repo.findByIdTipoNicho(idTipoNicho);
		if(tipoNicho.isPresent()) {
			return tipoNicho.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public tipoNicho createtipoNicho(tipoNicho tipoNicho){
		return repo.save(tipoNicho);
	}

	public tipoNicho updatetipoNicho(tipoNicho tipoNicho) throws RecordNotFoundException {
		Optional<tipoNicho> tipoNichoTemp = repo.findByIdTipoNicho(tipoNicho.getIdTipoNicho());
	
		if(tipoNichoTemp.isPresent()){
			return repo.save(tipoNicho);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletetipoNichoByIdTipoNicho(Long idTipoNicho) throws RecordNotFoundException{
		Optional<tipoNicho> tipoNicho = repo.findByIdTipoNicho(idTipoNicho);
		if(tipoNicho.isPresent()) {
		repo.deleteByIdTipoNicho(idTipoNicho);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
