package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;

public class Livro {
	private String nome;
	private BigDecimal preco;
	
	public Livro(String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
}
