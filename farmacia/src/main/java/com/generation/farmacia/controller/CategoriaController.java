package com.generation.farmacia.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmacia.Model.CategoriaModel;
import com.generation.farmacia.repository.CategoriaRepository;

@RestController                 //API faz a comunicação do site com o banco de dados. 
@RequestMapping("/categoria")  //Ele vai mapear o que está na model, está mais ligado a URL.
@CrossOrigin(origins = "*", allowedHeaders ="*") //Lembrete: toda requisição tem um cabeçalho, * diz que vai aceitar qualquer caracter..

public class CategoriaController {

	@Autowired                              ///Essa anotação instancia a classe automáticamente, não importa o que está lá, traz tudo.
	private CategoriaRepository repository; //Aqui estamos instanciando a classe, precisamos fazer isso pra acessá-la.

	@GetMapping  
	public ResponseEntity<List<CategoriaModel>>getAll(){
	return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") //Esse ID está relacionado a anotação
	public ResponseEntity<CategoriaModel> GetById(@PathVariable long id){
	    return repository.findById(id).map(resp -> ResponseEntity.ok(resp)) //esse id está relacionado a Model
	    		.orElse(ResponseEntity.notFound().build());			       //build é puxado do JPA	
	}
	
	@GetMapping("/titulo/{titulo}") // Busca o {o que está aqui} na URL. No postman fica http://localhost:8080/titulo/titulo
	public ResponseEntity<List<CategoriaModel>> GetByTitulo(@PathVariable String titulo){ // PathVariable = Caminho da variável
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	@PostMapping   
	public ResponseEntity <CategoriaModel>post(@RequestBody CategoriaModel titulo){ //produto pkeno é o objeto da classe, tudo que tem na model
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(titulo)); 
	}

	@PutMapping 
	public ResponseEntity <CategoriaModel>put(@RequestBody CategoriaModel categoria){ 
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}