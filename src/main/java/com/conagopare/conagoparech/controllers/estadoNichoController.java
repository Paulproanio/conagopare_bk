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

import com.conagopare.conagoparech.services.estadoNichoService;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.estadoNicho;

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
public class estadoNichoController {
	@Autowired
	estadoNichoService service;
	
	@GetMapping("/estadoNicho")
	public ResponseEntity<List<estadoNicho>> getAll() {
		List<estadoNicho> list = service.getAll();
		return new ResponseEntity<List<estadoNicho>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/estadoNicho/{id}")
	public ResponseEntity<estadoNicho> getestadoNichoByIdEstadoNicho(@PathVariable("id") Long idEstadoNicho) throws RecordNotFoundException {
		estadoNicho entity = service.findByIdEstadoNicho(idEstadoNicho);
		return new ResponseEntity<estadoNicho>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/estadoNicho")
	public ResponseEntity<estadoNicho> createestadoNicho(@RequestBody estadoNicho estadoNicho){
		service.createestadoNicho(estadoNicho);
		return new ResponseEntity<estadoNicho>(estadoNicho, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/estadoNicho")
	public ResponseEntity<estadoNicho> updateestadoNicho(@RequestBody estadoNicho estadoNicho) throws RecordNotFoundException{
		service.updateestadoNicho(estadoNicho);
		return new ResponseEntity<estadoNicho>(estadoNicho, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/estadoNicho/{id}")
	public HttpStatus deleteestadoNichoByIdEstadoNicho(@PathVariable("id") Long idEstadoNicho) throws RecordNotFoundException {
		service.deleteestadoNichoByIdEstadoNicho(idEstadoNicho);
		return HttpStatus.OK;
	}
}				
