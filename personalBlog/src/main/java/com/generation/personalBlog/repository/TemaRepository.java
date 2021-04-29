package com.generation.personalBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.personalBlog.model.Tema; //importa a classe de tema

public interface TemaRepository extends JpaRepository <Tema, Long>{

	public List<Tema>findAllByDescricaoContainingIgnoreCase(String descricao);
}
