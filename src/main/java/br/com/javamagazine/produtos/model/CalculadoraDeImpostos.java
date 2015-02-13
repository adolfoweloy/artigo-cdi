package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;

public class CalculadoraDeImpostos {
  
  public BigDecimal calcular(BigDecimal valorTotal) {
    BigDecimal percentual = valorTotal.multiply(new BigDecimal("0.15"));
    return valorTotal.add(percentual);
  }

}
