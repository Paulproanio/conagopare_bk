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

import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.usuario;
import com.conagopare.conagoparech.repositories.usuarioRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class usuarioService {

	@Autowired
	usuarioRepository repo;

	public List<usuario> getAll(){
		List<usuario> usuarioList = repo.findAll();
		if(usuarioList.size() > 0) {
			return usuarioList;
		} else {
			return new ArrayList<usuario>();
		}
	}
     		
	public usuario findByIdUsuario(Long idUsuario) throws RecordNotFoundException{
		Optional<usuario> usuario = repo.findByIdUsuario(idUsuario);
		if(usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public usuario createusuario(usuario usuario){
		return repo.save(usuario);
	}

	public usuario updateusuario(usuario usuario) throws RecordNotFoundException {
		Optional<usuario> usuarioTemp = repo.findByIdUsuario(usuario.getIdUsuario());
	
		if(usuarioTemp.isPresent()){
			return repo.save(usuario);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteusuarioByIdUsuario(Long idUsuario) throws RecordNotFoundException{
		Optional<usuario> usuario = repo.findByIdUsuario(idUsuario);
		if(usuario.isPresent()) {
		repo.deleteByIdUsuario(idUsuario);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
