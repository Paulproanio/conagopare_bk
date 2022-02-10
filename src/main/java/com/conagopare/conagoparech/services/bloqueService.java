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

import com.conagopare.conagoparech.repositories.bloqueRepository;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.bloque;
import com.conagopare.conagoparech.entities.nicho;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class bloqueService {

	@Autowired
	bloqueRepository repo;

	public List<bloque> getAll(){
		List<bloque> bloqueList = repo.findAll();
		if(bloqueList.size() > 0) {
			return bloqueList;
		} else {
			return new ArrayList<bloque>();
		}
	}
     		
	public bloque findByIdBloque(Long idBloque) throws RecordNotFoundException{
		Optional<bloque> bloque = repo.findByIdBloque(idBloque);
		if(bloque.isPresent()) {
			return bloque.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public bloque createbloque(bloque bloque){
		return repo.save(bloque);
	}

	public bloque updatebloque(bloque bloque) throws RecordNotFoundException {
		Optional<bloque> bloqueTemp = repo.findByIdBloque(bloque.getIdBloque());
	
		if(bloqueTemp.isPresent()){
			return repo.save(bloque);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletebloqueByIdBloque(Long idBloque) throws RecordNotFoundException{
		Optional<bloque> bloque = repo.findByIdBloque(idBloque);
		if(bloque.isPresent()) {
		repo.deleteByIdBloque(idBloque);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public List<bloque>findByDescripcionBloque(String descbloque){
		List<bloque> listBloquesxdesc = repo.findByDescripcionBloque(descbloque);
		
		if (listBloquesxdesc.size()>0) {
			return listBloquesxdesc;
		} else {
			return new ArrayList<bloque>();
		}
	}

}
