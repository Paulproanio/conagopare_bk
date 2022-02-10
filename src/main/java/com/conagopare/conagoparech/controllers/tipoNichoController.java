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

import com.conagopare.conagoparech.services.tipoNichoService;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.tipoNicho;

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
public class tipoNichoController {
	@Autowired
	tipoNichoService service;
	
	@GetMapping("/tipoNicho")
	public ResponseEntity<List<tipoNicho>> getAll() {
		List<tipoNicho> list = service.getAll();
		return new ResponseEntity<List<tipoNicho>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/tipoNicho/{id}")
	public ResponseEntity<tipoNicho> gettipoNichoByIdTipoNicho(@PathVariable("id") Long idTipoNicho) throws RecordNotFoundException {
		tipoNicho entity = service.findByIdTipoNicho(idTipoNicho);
		return new ResponseEntity<tipoNicho>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/tipoNicho")
	public ResponseEntity<tipoNicho> createtipoNicho(@RequestBody tipoNicho tipoNicho){
		service.createtipoNicho(tipoNicho);
		return new ResponseEntity<tipoNicho>(tipoNicho, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/tipoNicho")
	public ResponseEntity<tipoNicho> updatetipoNicho(@RequestBody tipoNicho tipoNicho) throws RecordNotFoundException{
		service.updatetipoNicho(tipoNicho);
		return new ResponseEntity<tipoNicho>(tipoNicho, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/tipoNicho/{id}")
	public HttpStatus deletetipoNichoByIdTipoNicho(@PathVariable("id") Long idTipoNicho) throws RecordNotFoundException {
		service.deletetipoNichoByIdTipoNicho(idTipoNicho);
		return HttpStatus.OK;
	}
}				
