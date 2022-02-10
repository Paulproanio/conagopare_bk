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
import com.conagopare.conagoparech.entities.fallecido;
import com.conagopare.conagoparech.entities.pago;
import com.conagopare.conagoparech.repositories.pagoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class pagoService {

	@Autowired
	pagoRepository repo;

	public List<pago> getAll(){
		List<pago> pagoList = repo.findAll();
		if(pagoList.size() > 0) {
			return pagoList;
		} else {
			return new ArrayList<pago>();
		}
	}
     		
	public pago findByIdPago(Long idPago) throws RecordNotFoundException{
		Optional<pago> pago = repo.findByIdPago(idPago);
		if(pago.isPresent()) {
			return pago.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public pago createpago(pago pago){
		return repo.save(pago);
	}

	public pago updatepago(pago pago) throws RecordNotFoundException {
		Optional<pago> pagoTemp = repo.findByIdPago(pago.getIdPago());
	
		if(pagoTemp.isPresent()){
			return repo.save(pago);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletepagoByIdPago(Long idPago) throws RecordNotFoundException{
		Optional<pago> pago = repo.findByIdPago(idPago);
		if(pago.isPresent()) {
		repo.deleteByIdPago(idPago);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public List<fallecido>findPagoByIdnicho(Long idnicho){
		List<fallecido> listpagonicho= repo.findPagoByIdnicho(idnicho);
		
		if (listpagonicho.size()>0) {
			return listpagonicho;
		} else {
			return new ArrayList<fallecido>();
		}
	}
	
	public List<pago>findByPagoNichoRepresentnate(String cedularepresentante){
		List<pago> listanichoreprepago= repo.findByPagoNichoRepresentnate(cedularepresentante);
		
		if (listanichoreprepago.size()>0) {
			return listanichoreprepago;
		} else {
			return new ArrayList<pago>();
		}
	}

}
