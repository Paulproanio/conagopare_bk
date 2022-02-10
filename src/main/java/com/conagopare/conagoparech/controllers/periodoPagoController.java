																/*
 -------------------------------------------------------------------
|
| University: 	ESPOCH Escuela Superior Politécnica del Chimborazo 
| Project: 		Conagopare Chimborazo.
| Author: 		Anastasia MInina, Cristopher García, Raúl Medina, Paúl Proaño (2021)
| File Date: Sat Aug 14 18:29:18 COT 2021
| 
 -------------------------------------------------------------------
																*/
package com.conagopare.conagoparech.controllers;

import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.periodoPago;
import com.conagopare.conagoparech.services.periodoPagoService;

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
public class periodoPagoController {
	@Autowired
	periodoPagoService service;
	
	@GetMapping("/periodoPago")
	public ResponseEntity<List<periodoPago>> getAll() {
		List<periodoPago> list = service.getAll();
		return new ResponseEntity<List<periodoPago>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/periodoPago/{id}")
	public ResponseEntity<periodoPago> getperiodoPagoByIdPeriodoPago(@PathVariable("id") Long idPeriodoPago) throws RecordNotFoundException {
		periodoPago entity = service.findByIdPeriodoPago(idPeriodoPago);
		return new ResponseEntity<periodoPago>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/periodoPago")
	public ResponseEntity<periodoPago> createperiodoPago(@RequestBody periodoPago periodoPago){
		service.createperiodoPago(periodoPago);
		return new ResponseEntity<periodoPago>(periodoPago, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/periodoPago")
	public ResponseEntity<periodoPago> updateperiodoPago(@RequestBody periodoPago periodoPago) throws RecordNotFoundException{
		service.updateperiodoPago(periodoPago);
		return new ResponseEntity<periodoPago>(periodoPago, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/periodoPago/{id}")
	public HttpStatus deleteperiodoPagoByIdPeriodoPago(@PathVariable("id") Long idPeriodoPago) throws RecordNotFoundException {
		service.deleteperiodoPagoByIdPeriodoPago(idPeriodoPago);
		return HttpStatus.OK;
	}
}				
