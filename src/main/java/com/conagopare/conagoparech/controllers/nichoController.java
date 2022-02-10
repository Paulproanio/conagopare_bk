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

import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.nicho;
import com.conagopare.conagoparech.services.nichoService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/conagopare")
public class nichoController {
	@Autowired
	nichoService service;
	
	@GetMapping("/nicho")
	public ResponseEntity<List<nicho>> getAll() {
		List<nicho> list = service.getAll();
		return new ResponseEntity<List<nicho>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/nicho/{id}")
	public ResponseEntity<nicho> getnichoByIdNicho(@PathVariable("id") Long idNicho) throws RecordNotFoundException {
		nicho entity = service.findByIdNicho(idNicho);
		return new ResponseEntity<nicho>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/nicho")
	public ResponseEntity<nicho> createnicho(@RequestBody nicho nicho){
		service.createnicho(nicho);
		return new ResponseEntity<nicho>(nicho, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/nicho")
	public ResponseEntity<nicho> updatenicho(@RequestBody nicho nicho) throws RecordNotFoundException{
		service.updatenicho(nicho);
		return new ResponseEntity<nicho>(nicho, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/nicho/{id}")
	@Transactional
	public HttpStatus deletenichoByIdNicho(@PathVariable("id") Long idNicho) throws RecordNotFoundException {
		service.deletenichoByIdNicho(idNicho);
		return HttpStatus.OK;
	}
	
	@GetMapping("/nicho/xidesnicho/{idEstado}")
	public ResponseEntity<List<nicho>> getByVistaVentas(@PathVariable("idEstado") Long idEstado) throws ParseException{
		List<nicho> listaNichos = service.findByEstadoNicho(idEstado);
		return new ResponseEntity<List<nicho>>(listaNichos , new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/nicho/xidcem/{idCementerio}")
	public ResponseEntity<List<nicho>> getByIdCementerioNicho(@PathVariable("idCementerio") Long idCementerio) throws ParseException{
		List<nicho> listaNichsoxcementerio = service.findByIdCementerio(idCementerio);
		return new ResponseEntity<List<nicho>>(listaNichsoxcementerio , new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/nicho/xnn/{numeronicho}")
	public ResponseEntity<List<nicho>> getByNumNicho(@PathVariable("numeronicho") Long numeronicho) throws ParseException{
		List<nicho> listaNichsoxnumnicho = service.findByNumNicho(numeronicho);
		return new ResponseEntity<List<nicho>>(listaNichsoxnumnicho , new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/nicho/xidb/{idbloque}")
	public ResponseEntity<List<nicho>> getByIdBloque(@PathVariable("idbloque") Long idbloque) throws ParseException{
		List<nicho> listaNichoxidbloque = service.findByIdBloque(idbloque);
		return new ResponseEntity<List<nicho>>(listaNichoxidbloque , new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/nicho/lnxidb/{idbloque}")
	public ResponseEntity<List<nicho>> getByIdBloqueNichos(@PathVariable("idbloque") Long idbloque) throws ParseException{
		List<nicho> listaNichos = service.findByNichosxIdBloque(idbloque);
		return new ResponseEntity<List<nicho>>(listaNichos , new HttpHeaders(),HttpStatus.OK);
	}
}				
