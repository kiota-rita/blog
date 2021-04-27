package com.generation.personalBlog.repository;

import com.generation.personalBlog.model.Postagem;

import java.util.List;//lista

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //indica que é uma classe de repositorio
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo); //cria lista que busca as postagens por titulo
	
}
