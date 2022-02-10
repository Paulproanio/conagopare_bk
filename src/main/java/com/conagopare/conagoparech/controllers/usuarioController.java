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
package com.conagopare.conagoparech.controllers;

import com.conagopare.conagoparech.services.usuarioService;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.usuario;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/conagopare")
public class usuarioController {
	@Autowired
	usuarioService service;
	
	@GetMapping("/usuario")
	public ResponseEntity<List<usuario>> getAll() {
		List<usuario> list = service.getAll();
		return new ResponseEntity<List<usuario>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<usuario> getusuarioByIdUsuario(@PathVariable("id") Long idUsuario) throws RecordNotFoundException {
		usuario entity = service.findByIdUsuario(idUsuario);
		return new ResponseEntity<usuario>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/usuario")
	public ResponseEntity<usuario> createusuario(@RequestBody usuario usuario){
		service.createusuario(usuario);
		return new ResponseEntity<usuario>(usuario, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/usuario")
	public ResponseEntity<usuario> updateusuario(@RequestBody usuario usuario) throws RecordNotFoundException{
		service.updateusuario(usuario);
		return new ResponseEntity<usuario>(usuario, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/usuario/{id}")
	public HttpStatus deleteusuarioByIdUsuario(@PathVariable("id") Long idUsuario) throws RecordNotFoundException {
		service.deleteusuarioByIdUsuario(idUsuario);
		return HttpStatus.OK;
	}
}				
