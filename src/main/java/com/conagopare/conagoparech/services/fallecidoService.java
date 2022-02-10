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

import com.conagopare.conagoparech.repositories.fallecidoRepository;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.fallecido;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class fallecidoService {

	@Autowired
	fallecidoRepository repo;

	public List<fallecido> getAll(){
		List<fallecido> fallecidoList = repo.findAll();
		if(fallecidoList.size() > 0) {
			return fallecidoList;
		} else {
			return new ArrayList<fallecido>();
		}
	}
     		
	public fallecido findByIdFallecido(Long idFallecido) throws RecordNotFoundException{
		Optional<fallecido> fallecido = repo.findByIdFallecido(idFallecido);
		if(fallecido.isPresent()) {
			return fallecido.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public List<fallecido> findByNombreFallecidoContaining(String nombreFallecido){
		List<fallecido> fallecidoList = repo.findByNombreFallecidoContaining(nombreFallecido);
		if(fallecidoList.size() > 0) {
			return fallecidoList;
		} else {
			return new ArrayList<fallecido>();
		}
	}
	
	public List<fallecido> findByFechFallecimiento(Date fechFallecimiento){
		List<fallecido> fallecidoList = repo.findAllByFechFallecimiento(fechFallecimiento);		
		if(fallecidoList.size() > 0) {
			return fallecidoList;
		} else {
			return new ArrayList<fallecido>();
		}
	}
	
	public fallecido createfallecido(fallecido fallecido){
		return repo.save(fallecido);
	}

	public fallecido updatefallecido(fallecido fallecido) throws RecordNotFoundException {
		Optional<fallecido> fallecidoTemp = repo.findByIdFallecido(fallecido.getIdFallecido());
	
		if(fallecidoTemp.isPresent()){
			return repo.save(fallecido);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletefallecidoByIdFallecido(Long idFallecido) throws RecordNotFoundException{
		Optional<fallecido> fallecido = repo.findByIdFallecido(idFallecido);
		if(fallecido.isPresent()) {
		repo.deleteByIdFallecido(idFallecido);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}	
	
	public List<fallecido>findByVistaVentas(String cedulaRepresentante){
		List<fallecido> listNichRep= repo.findNichosByCedulaRep(cedulaRepresentante);
		
		if (listNichRep.size()>0) {
			return listNichRep;
		} else {
			return new ArrayList<fallecido>();
		}
	}
	
	public List<fallecido>findFallxCodnicho(String codigonicho){
		List<fallecido> listFallexist= repo.findFallxCodnicho(codigonicho);
		
		if (listFallexist.size()>0) {
			return listFallexist;
		} else {
			return new ArrayList<fallecido>();
		}
	}

}
