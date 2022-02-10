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

import com.conagopare.conagoparech.repositories.tipoUsuarioRepository;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.tipoUsuario;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class tipoUsuarioService {

	@Autowired
	tipoUsuarioRepository repo;

	public List<tipoUsuario> getAll(){
		List<tipoUsuario> tipoUsuarioList = repo.findAll();
		if(tipoUsuarioList.size() > 0) {
			return tipoUsuarioList;
		} else {
			return new ArrayList<tipoUsuario>();
		}
	}
     		
	public tipoUsuario findByIdTipoUsuario(Long idTipoUsuario) throws RecordNotFoundException{
		Optional<tipoUsuario> tipoUsuario = repo.findByIdTipoUsuario(idTipoUsuario);
		if(tipoUsuario.isPresent()) {
			return tipoUsuario.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public tipoUsuario createtipoUsuario(tipoUsuario tipoUsuario){
		return repo.save(tipoUsuario);
	}

	public tipoUsuario updatetipoUsuario(tipoUsuario tipoUsuario) throws RecordNotFoundException {
		Optional<tipoUsuario> tipoUsuarioTemp = repo.findByIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
	
		if(tipoUsuarioTemp.isPresent()){
			return repo.save(tipoUsuario);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletetipoUsuarioByIdTipoUsuario(Long idTipoUsuario) throws RecordNotFoundException{
		Optional<tipoUsuario> tipoUsuario = repo.findByIdTipoUsuario(idTipoUsuario);
		if(tipoUsuario.isPresent()) {
		repo.deleteByIdTipoUsuario(idTipoUsuario);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
