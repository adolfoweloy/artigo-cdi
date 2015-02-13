package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Fatura {
  private List<Livro> livros;
  private BigDecimal valorTotalFatura;
  
  public Fatura(List<Livro> livros, BigDecimal valorTotalFatura) {
    this.livros = livros;
    this.valorTotalFatura = valorTotalFatura;
  }

  public List<Livro> getLivros() {
    return Collections.unmodifiableList(livros);
  }
  
  public BigDecimal getValorTotal() {
    return valorTotalFatura;
  }
  
}
