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

import com.conagopare.conagoparech.services.cementerioService;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.cementerio;

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
public class cementerioController {
	@Autowired
	cementerioService service;
	
	@GetMapping("/cementerio")
	public ResponseEntity<List<cementerio>> getAll() {
		List<cementerio> list = service.getAll();
		return new ResponseEntity<List<cementerio>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/cementerio/{id}")
	public ResponseEntity<cementerio> getcementerioByIdCementerio(@PathVariable("id") Long idCementerio) throws RecordNotFoundException {
		cementerio entity = service.findByIdCementerio(idCementerio);
		return new ResponseEntity<cementerio>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/cementerio")
	public ResponseEntity<cementerio> createcementerio(@RequestBody cementerio cementerio){
		service.createcementerio(cementerio);
		return new ResponseEntity<cementerio>(cementerio, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/cementerio")
	public ResponseEntity<cementerio> updatecementerio(@RequestBody cementerio cementerio) throws RecordNotFoundException{
		service.updatecementerio(cementerio);
		return new ResponseEntity<cementerio>(cementerio, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/cementerio/{id}")
	public HttpStatus deletecementerioByIdCementerio(@PathVariable("id") Long idCementerio) throws RecordNotFoundException {
		service.deletecementerioByIdCementerio(idCementerio);
		return HttpStatus.OK;
	}
}				
