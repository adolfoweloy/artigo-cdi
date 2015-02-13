package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;

public class Livro {
  private int id;
  private String nome;
  private BigDecimal preco;

  public Livro(int id, String nome, BigDecimal preco) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
  }

  public String getNome() {
    return nome;
  }

  public BigDecimal getPreco() {
    return preco;
  }
  
  public int getId() {
    return id;
  }
}
