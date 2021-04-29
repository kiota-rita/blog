package com.generation.personalBlog.model;

import java.util.List; //import da lista

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;


@Entity//indica que é uma entidade
@Table(name="tb_tema")//indica que esta entidade é uma tabela de nome tb_tema
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; //atributo
	
	@NotNull
	private String descricao; //atributo
	
	@OneToMany(mappedBy ="tema", cascade = CascadeType.ALL)//essa tabela se conecta com outras 
	@JsonIgnoreProperties("tema") //não entendi essa parte
	private List<Postagem>postagem; //lista de postagem do tipo postagem
	
	//get and set
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Postagem> getPostagem() {
		return postagem;
	}
	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	
}
