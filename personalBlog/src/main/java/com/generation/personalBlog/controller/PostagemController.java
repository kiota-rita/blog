package com.generation.personalBlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.personalBlog.model.Postagem;
import com.generation.personalBlog.repository.PostagemRepository;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;

@RestController //informa que esta classse é um controlador
@RequestMapping("/postagens")
@CrossOrigin("*") //indica que essa API aceitará requisições de qualquer lugar
public class PostagemController {

	@Autowired
	private PostagemRepository repository;
	
	@GetMapping //quando a api for consumida acessará esse metodo
	public ResponseEntity<List<Postagem>> GetAll(){ //metodo
		return ResponseEntity.ok(repository.findAll()); //chama o findAll que esta na interface repository
	}
	
	@GetMapping("/{id}") //quando a api for consumida acessará esse metodo quando a pesquisa for por id
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
		public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
			return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		}
	
}
