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

import com.conagopare.conagoparech.services.fallecidoService;
import com.conagopare.conagoparech.RecordNotFoundException;
import com.conagopare.conagoparech.entities.fallecido;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;	
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/conagopare")
public class fallecidoController {
	@Autowired
	fallecidoService service;
	
	@GetMapping("/fallecido")
	public ResponseEntity<List<fallecido>> getAll() {
		List<fallecido> list = service.getAll();
		return new ResponseEntity<List<fallecido>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/fallecido/{id}")
	public ResponseEntity<fallecido> getfallecidoByIdFallecido(@PathVariable("id") Long idFallecido) throws RecordNotFoundException {
		fallecido entity = service.findByIdFallecido(idFallecido);
		return new ResponseEntity<fallecido>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/fallecido/findbynombreFallecido/{nombreFallecido}")
	public ResponseEntity<List<fallecido>> getByNombreFallecido(@PathVariable("nombreFallecido") String nombreFallecido){
		List<fallecido> list = service.findByNombreFallecidoContaining(nombreFallecido);
		return new ResponseEntity<List<fallecido>>(list, new HttpHeaders(), HttpStatus.OK);
	}				

	@GetMapping("/fallecido/findbyfechFallecimiento/{fechFallecimiento}")
	public ResponseEntity<List<fallecido>> getByFechFallecimiento(@PathVariable("fechFallecimiento") String fechFallecimiento) throws ParseException{
		List<fallecido> list = service.findByFechFallecimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fechFallecimiento));
		return new ResponseEntity<List<fallecido>>(list, new HttpHeaders(), HttpStatus.OK);
	}				

	@PostMapping("/fallecido")
	public ResponseEntity<fallecido> createfallecido(@RequestBody fallecido fallecido){
		service.createfallecido(fallecido);
		return new ResponseEntity<fallecido>(fallecido, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/fallecido")
	public ResponseEntity<fallecido> updatefallecido(@RequestBody fallecido fallecido) throws RecordNotFoundException{
		service.updatefallecido(fallecido);
		return new ResponseEntity<fallecido>(fallecido, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/fallecido/{id}")
	public HttpStatus deletefallecidoByIdFallecido(@PathVariable("id") Long idFallecido) throws RecordNotFoundException {
		service.deletefallecidoByIdFallecido(idFallecido);
		return HttpStatus.OK;
	}
	
	@GetMapping("/fallecido/nicdeunrep/{cedulaRepresentante}")
	public ResponseEntity<List<fallecido>> getByVistaVentas(@PathVariable("cedulaRepresentante") String cedulaRepresentante) throws ParseException{
		List<fallecido> listanicdeunrep = service.findByVistaVentas(cedulaRepresentante);
		//System.out.println(listaVentas);
		return new ResponseEntity<List<fallecido>>(listanicdeunrep , new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/fallecido/bfxcn/{codigonicho}")
	public ResponseEntity<List<fallecido>> getFallByCodnicho(@PathVariable("codigonicho") String codigonicho) throws ParseException{
		List<fallecido> listfallxcodnich = service.findFallxCodnicho(codigonicho);
		//System.out.println(listaVentas);
		return new ResponseEntity<List<fallecido>>(listfallxcodnich , new HttpHeaders(),HttpStatus.OK);
	}
}				
