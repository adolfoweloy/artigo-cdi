package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
  private List<Livro> livros = new ArrayList<>();
  
  public void adicionar(Livro livro) {
    livros.add(livro);
  }

  public Fatura gerarFatura(CalculadoraDeImpostos calculadora) {
    BigDecimal valorTotal = BigDecimal.ZERO;
    
    for (Livro livro : livros) {
      valorTotal = valorTotal.add(livro.getPreco());
    }
    
    BigDecimal valorTotalCalculado = calculadora.calcular(valorTotal);
    return new Fatura(livros, valorTotalCalculado);
  }

}
