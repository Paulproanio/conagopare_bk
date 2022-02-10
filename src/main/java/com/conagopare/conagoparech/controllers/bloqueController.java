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

import com.conagopare.conagoparech.services.bloqueService;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.bloque;
import com.conagopare.conagoparech.entities.nicho;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

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
public class bloqueController {
	@Autowired
	bloqueService service;
	
	@GetMapping("/bloque")
	public ResponseEntity<List<bloque>> getAll() {
		List<bloque> list = service.getAll();
		return new ResponseEntity<List<bloque>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/bloque/{id}")
	public ResponseEntity<bloque> getbloqueByIdBloque(@PathVariable("id") Long idBloque) throws RecordNotFoundException {
		bloque entity = service.findByIdBloque(idBloque);
		return new ResponseEntity<bloque>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/bloque")
	public ResponseEntity<bloque> createbloque(@RequestBody bloque bloque){
		service.createbloque(bloque);
		return new ResponseEntity<bloque>(bloque, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/bloque")
	public ResponseEntity<bloque> updatebloque(@RequestBody bloque bloque) throws RecordNotFoundException{
		service.updatebloque(bloque);
		return new ResponseEntity<bloque>(bloque, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/bloque/{id}")
	@Transactional
	public HttpStatus deletebloqueByIdBloque(@PathVariable("id") Long idBloque) throws RecordNotFoundException {
		service.deletebloqueByIdBloque(idBloque);
		return HttpStatus.OK;
	}
	
	@GetMapping("/bloque/lbxdescb/{descbloque}")
	public ResponseEntity<List<bloque>> getByDescripcionBloque(@PathVariable("descbloque") String descbloque) throws ParseException{
		List<bloque> listaBloquexdescripcion = service.findByDescripcionBloque(descbloque);
		return new ResponseEntity<List<bloque>>(listaBloquexdescripcion , new HttpHeaders(),HttpStatus.OK);
	}
}				
