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

import com.conagopare.conagoparech.repositories.cementerioRepository;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.cementerio;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class cementerioService {

	@Autowired
	cementerioRepository repo;

	public List<cementerio> getAll(){
		List<cementerio> cementerioList = repo.findAll();
		if(cementerioList.size() > 0) {
			return cementerioList;
		} else {
			return new ArrayList<cementerio>();
		}
	}
     		
	public cementerio findByIdCementerio(Long idCementerio) throws RecordNotFoundException{
		Optional<cementerio> cementerio = repo.findByIdCementerio(idCementerio);
		if(cementerio.isPresent()) {
			return cementerio.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public cementerio createcementerio(cementerio cementerio){
		return repo.save(cementerio);
	}

	public cementerio updatecementerio(cementerio cementerio) throws RecordNotFoundException {
		Optional<cementerio> cementerioTemp = repo.findByIdCementerio(cementerio.getIdCementerio());
	
		if(cementerioTemp.isPresent()){
			return repo.save(cementerio);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletecementerioByIdCementerio(Long idCementerio) throws RecordNotFoundException{
		Optional<cementerio> cementerio = repo.findByIdCementerio(idCementerio);
		if(cementerio.isPresent()) {
		repo.deleteByIdCementerio(idCementerio);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
