package com.generation.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.generation.petshop.model.TipoPet;
import com.generation.petshop.repository.TipoPetRepository;

/*Anotações de definição de um controlador*/
@RestController
@RequestMapping("/tipo-pet")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class TipoPetController {
	
	/*Injetar o meu repositorio*/
	@Autowired
	private TipoPetRepository repository;
			
	/*End points*/
	@GetMapping
	public ResponseEntity<List<TipoPet>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoPet> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	public ResponseEntity<TipoPet> post(@RequestBody TipoPet tipoPet){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(tipoPet));
	}
	
	@PutMapping
	public ResponseEntity<TipoPet> put(@RequestBody TipoPet tipoPet){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(tipoPet));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}

}
