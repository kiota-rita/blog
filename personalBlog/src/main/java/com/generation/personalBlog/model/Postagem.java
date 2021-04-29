package com.generation.personalBlog.model;

import java.util.Date; //biblioteca de data

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity //esta classe é uma entidade do jpa hibernate
@Table (name="postagem")//esta entidade cria uma tabela dentro do db 

public class Postagem {
	
	@Id //id da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)//chave primaria - autoincremento do id
	private long id;//argumentos
	
	@NotNull //indica que o argumento não pode ficar vazio no db
	@Size(min = 5 , max = 100) //indica a quantidade de caracteres
	private String titulo;
	
	@NotNull 
	@Size(min = 10 , max = 500)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP) //indica como será computado a data
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	//tabela tema
	@ManyToOne //indica que varias tabelas se conectam a esta
	@JsonIgnoreProperties("postagens") //não entendi o que essa anotação faz
	private Tema tema;
	
	//get and set
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	//get and set tabela tema
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
}
