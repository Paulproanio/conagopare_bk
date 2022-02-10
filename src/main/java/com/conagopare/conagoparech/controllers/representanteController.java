																/*
 -------------------------------------------------------------------
|
| University: 	ESPOCH Escuela Superior Politécnica del Chimborazo 
| Project: 		Conagopare Chimborazo.
| Author: 		Anastasia MInina, Cristopher García, Raúl Medina, Paúl Proaño (2021)
| File Date: Tue Jul 27 21:25:09 COT 2021
| 
 -------------------------------------------------------------------
																*/
package com.conagopare.conagoparech.controllers;

import com.conagopare.conagoparech.services.representanteService;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.representante;

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
public class representanteController {
	@Autowired
	representanteService service;
	
	@GetMapping("/representante")
	public ResponseEntity<List<representante>> getAll() {
		List<representante> list = service.getAll();
		return new ResponseEntity<List<representante>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/representante/{id}")
	public ResponseEntity<representante> getrepresentanteByIdRepresentante(@PathVariable("id") Long idRepresentante) throws RecordNotFoundException {
		representante entity = service.findByIdRepresentante(idRepresentante);
		return new ResponseEntity<representante>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/representante/findbycedulaRepresentante/{cedulaRepresentante}")
	public ResponseEntity<List<representante>> getByCedulaRepresentante(@PathVariable("cedulaRepresentante") String cedulaRepresentante){
		List<representante> list = service.findByCedulaRepresentanteContaining(cedulaRepresentante);
		return new ResponseEntity<List<representante>>(list, new HttpHeaders(), HttpStatus.OK);
	}				
	@GetMapping("/representante/findbynombreRepresentante/{nombreRepresentante}")
	public ResponseEntity<List<representante>> getByNombreRepresentante(@PathVariable("nombreRepresentante") String nombreRepresentante){
		List<representante> list = service.findByNombreRepresentanteContaining(nombreRepresentante);
		return new ResponseEntity<List<representante>>(list, new HttpHeaders(), HttpStatus.OK);
	}				


	@PostMapping("/representante")
	public ResponseEntity<representante> createrepresentante(@RequestBody representante representante){
		service.createrepresentante(representante);
		return new ResponseEntity<representante>(representante, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/representante")
	public ResponseEntity<representante> updaterepresentante(@RequestBody representante representante) throws RecordNotFoundException{
		service.updaterepresentante(representante);
		return new ResponseEntity<representante>(representante, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/representante/{id}")
	public HttpStatus deleterepresentanteByIdRepresentante(@PathVariable("id") Long idRepresentante) throws RecordNotFoundException {
		service.deleterepresentanteByIdRepresentante(idRepresentante);
		return HttpStatus.OK;
	}
}				
