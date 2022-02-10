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
import com.conagopare.conagoparech.entities.fallecido;
import com.conagopare.conagoparech.entities.pago;
import com.conagopare.conagoparech.services.pagoService;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/conagopare")
public class pagoController {
	@Autowired
	pagoService service;
	
	@GetMapping("/pago")
	public ResponseEntity<List<pago>> getAll() {
		List<pago> list = service.getAll();
		return new ResponseEntity<List<pago>>(list, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	@GetMapping("/pago/{id}")
	public ResponseEntity<pago> getpagoByIdPago(@PathVariable("id") Long idPago) throws RecordNotFoundException {
		pago entity = service.findByIdPago(idPago);
		return new ResponseEntity<pago>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/pago")
	public ResponseEntity<pago> createpago(@RequestBody pago pago){
		service.createpago(pago);
		return new ResponseEntity<pago>(pago, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/pago")
	public ResponseEntity<pago> updatepago(@RequestBody pago pago) throws RecordNotFoundException{
		service.updatepago(pago);
		return new ResponseEntity<pago>(pago, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/pago/{id}")
	public HttpStatus deletepagoByIdPago(@PathVariable("id") Long idPago) throws RecordNotFoundException {
		service.deletepagoByIdPago(idPago);
		return HttpStatus.OK;
	}
	
	@GetMapping("/pago/xidnic/{idnicho}")
	public ResponseEntity<List<fallecido>> getpagoByIdnicho(@PathVariable("idnicho") Long idnicho) throws ParseException{
		List<fallecido> listpago = service.findPagoByIdnicho(idnicho);
		return new ResponseEntity<List<fallecido>>(listpago , new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/pago/rep/{cedularepresentante}")
	public ResponseEntity<List<pago>> getpagonichorepre(@PathVariable("cedularepresentante") String cedularepresentante) throws ParseException{
		List<pago> listpagonichorepre = service.findByPagoNichoRepresentnate(cedularepresentante);
		return new ResponseEntity<List<pago>>(listpagonichorepre , new HttpHeaders(),HttpStatus.OK);
	}

}				
