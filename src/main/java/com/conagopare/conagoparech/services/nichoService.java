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

import com.conagopare.conagoparech.repositories.nichoRepository;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.nicho;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class nichoService {

	@Autowired
	nichoRepository repo;

	public List<nicho> getAll(){
		List<nicho> nichoList = repo.findAll();
		if(nichoList.size() > 0) {
			return nichoList;
		} else {
			return new ArrayList<nicho>();
		}
	}
     		
	public nicho findByIdNicho(Long idNicho) throws RecordNotFoundException{
		Optional<nicho> nicho = repo.findByIdNicho(idNicho);
		if(nicho.isPresent()) {
			return nicho.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public nicho createnicho(nicho nicho){
		return repo.save(nicho);
	}

	public nicho updatenicho(nicho nicho) throws RecordNotFoundException {
		Optional<nicho> nichoTemp = repo.findByIdNicho(nicho.getIdNicho());
	
		if(nichoTemp.isPresent()){
			return repo.save(nicho);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletenichoByIdNicho(Long idNicho) throws RecordNotFoundException{
		Optional<nicho> nicho = repo.findByIdNicho(idNicho);
		if(nicho.isPresent()) {
		repo.deleteByIdNicho(idNicho);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public List<nicho>findByEstadoNicho(Long idEstado){
		List<nicho> listEstadoNicho= repo.findByEstadoNicho(idEstado);
		
		if (listEstadoNicho.size()>0) {
			return listEstadoNicho;
		} else {
			return new ArrayList<nicho>();
		}
	}
	
	public List<nicho>findByIdCementerio(Long idCementerio){
		List<nicho> listNichosCementerio= repo.findByIdCementerio(idCementerio);
		
		if (listNichosCementerio.size()>0) {
			return listNichosCementerio;
		} else {
			return new ArrayList<nicho>();
		}
	}

	public List<nicho>findByNumNicho(Long numeronicho){
		List<nicho> listNichosxnumnicho= repo.findByNumNicho(numeronicho);
		
		if (listNichosxnumnicho.size()>0) {
			return listNichosxnumnicho;
		} else {
			return new ArrayList<nicho>();
		}
	}
	public List<nicho>findByIdBloque(Long idbloque){
		List<nicho> listBloquexid= repo.findByIdBloque(idbloque);
		
		if (listBloquexid.size()>0) {
			return listBloquexid;
		} else {
			return new ArrayList<nicho>();
		}
	}
	
	public List<nicho>findByNichosxIdBloque(Long idbloque){
		List<nicho> listanichos= repo.findByNichosxIdBloque(idbloque);
		
		if (listanichos.size()>0) {
			return listanichos;
		} else {
			return new ArrayList<nicho>();
		}
	}
}
