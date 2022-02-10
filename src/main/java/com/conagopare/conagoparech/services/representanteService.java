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
package com.conagopare.conagoparech.services;

import com.conagopare.conagoparech.repositories.representanteRepository;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.representante;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class representanteService {

	@Autowired
	representanteRepository repo;

	public List<representante> getAll(){
		List<representante> representanteList = repo.findAll();
		if(representanteList.size() > 0) {
			return representanteList;
		} else {
			return new ArrayList<representante>();
		}
	}
     		
	public representante findByIdRepresentante(Long idRepresentante) throws RecordNotFoundException{
		Optional<representante> representante = repo.findByIdRepresentante(idRepresentante);
		if(representante.isPresent()) {
			return representante.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public List<representante> findByCedulaRepresentanteContaining(String cedulaRepresentante){
		List<representante> representanteList = repo.findByCedulaRepresentanteContaining(cedulaRepresentante);
		if(representanteList.size() > 0) {
			return representanteList;
		} else {
			return new ArrayList<representante>();
		}
	}
	
	public List<representante> findByNombreRepresentanteContaining(String nombreRepresentante){
		List<representante> representanteList = repo.findByNombreRepresentanteContaining(nombreRepresentante);
		if(representanteList.size() > 0) {
			return representanteList;
		} else {
			return new ArrayList<representante>();
		}
	}
	
	public representante createrepresentante(representante representante){
		return repo.save(representante);
	}

	public representante updaterepresentante(representante representante) throws RecordNotFoundException {
		Optional<representante> representanteTemp = repo.findByIdRepresentante(representante.getIdRepresentante());
	
		if(representanteTemp.isPresent()){
			return repo.save(representante);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleterepresentanteByIdRepresentante(Long idRepresentante) throws RecordNotFoundException{
		Optional<representante> representante = repo.findByIdRepresentante(idRepresentante);
		if(representante.isPresent()) {
		repo.deleteByIdRepresentante(idRepresentante);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
