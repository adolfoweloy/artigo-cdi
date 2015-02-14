package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;

import javax.enterprise.inject.Alternative;

@Alternative
public class CalculadoraDeImpostosUS implements CalculadoraDeImpostos {

  @Override
  public BigDecimal calcular(BigDecimal valorTotal) {
    System.out.println("utilizando a calculadora de impostos US");
    
    BigDecimal percentualUS = valorTotal.multiply(new BigDecimal("0.20"));

    if (valorTotal.compareTo(new BigDecimal("100.00")) > 0) {
      percentualUS = percentualUS.add(new BigDecimal("0.04"));
    }

    valorTotal = valorTotal.add(percentualUS);
    return valorTotal;
  }

}
