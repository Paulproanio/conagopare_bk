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

import com.conagopare.conagoparech.services.tipoUsuarioService;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.tipoUsuario;

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
public class tipoUsuarioController {
	@Autowired
	tipoUsuarioService service;
	
	@GetMapping("/tipoUsuario")
	public ResponseEntity<List<tipoUsuario>> getAll() {
		List<tipoUsuario> list = service.getAll();
		return new ResponseEntity<List<tipoUsuario>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/tipoUsuario/{id}")
	public ResponseEntity<tipoUsuario> gettipoUsuarioByIdTipoUsuario(@PathVariable("id") Long idTipoUsuario) throws RecordNotFoundException {
		tipoUsuario entity = service.findByIdTipoUsuario(idTipoUsuario);
		return new ResponseEntity<tipoUsuario>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/tipoUsuario")
	public ResponseEntity<tipoUsuario> createtipoUsuario(@RequestBody tipoUsuario tipoUsuario){
		service.createtipoUsuario(tipoUsuario);
		return new ResponseEntity<tipoUsuario>(tipoUsuario, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/tipoUsuario")
	public ResponseEntity<tipoUsuario> updatetipoUsuario(@RequestBody tipoUsuario tipoUsuario) throws RecordNotFoundException{
		service.updatetipoUsuario(tipoUsuario);
		return new ResponseEntity<tipoUsuario>(tipoUsuario, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/tipoUsuario/{id}")
	public HttpStatus deletetipoUsuarioByIdTipoUsuario(@PathVariable("id") Long idTipoUsuario) throws RecordNotFoundException {
		service.deletetipoUsuarioByIdTipoUsuario(idTipoUsuario);
		return HttpStatus.OK;
	}
}				
