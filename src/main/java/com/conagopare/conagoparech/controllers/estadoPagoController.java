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
import com.conagopare.conagoparech.entities.estadoPago;
import com.conagopare.conagoparech.services.estadoPagoService;

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
public class estadoPagoController {
	@Autowired
	estadoPagoService service;
	
	@GetMapping("/estadoPago")
	public ResponseEntity<List<estadoPago>> getAll() {
		List<estadoPago> list = service.getAll();
		return new ResponseEntity<List<estadoPago>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/estadoPago/{id}")
	public ResponseEntity<estadoPago> getestadoPagoByIdEstadoPago(@PathVariable("id") Long idEstadoPago) throws RecordNotFoundException {
		estadoPago entity = service.findByIdEstadoPago(idEstadoPago);
		return new ResponseEntity<estadoPago>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/estadoPago")
	public ResponseEntity<estadoPago> createestadoPago(@RequestBody estadoPago estadoPago){
		service.createestadoPago(estadoPago);
		return new ResponseEntity<estadoPago>(estadoPago, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/estadoPago")
	public ResponseEntity<estadoPago> updateestadoPago(@RequestBody estadoPago estadoPago) throws RecordNotFoundException{
		service.updateestadoPago(estadoPago);
		return new ResponseEntity<estadoPago>(estadoPago, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/estadoPago/{id}")
	public HttpStatus deleteestadoPagoByIdEstadoPago(@PathVariable("id") Long idEstadoPago) throws RecordNotFoundException {
		service.deleteestadoPagoByIdEstadoPago(idEstadoPago);
		return HttpStatus.OK;
	}
}				
