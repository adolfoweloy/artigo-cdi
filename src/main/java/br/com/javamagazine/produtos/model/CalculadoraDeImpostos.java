package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;

public interface CalculadoraDeImpostos {

  public abstract BigDecimal calcular(BigDecimal valorTotal);

}