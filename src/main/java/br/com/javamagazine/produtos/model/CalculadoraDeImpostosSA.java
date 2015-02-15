package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;

import br.com.javamagazine.extension.Include;
import br.com.javamagazine.extension.RegionExpressionInterpreter;
import br.com.javamagazine.region.Region;

@Include(
  onExpression=Region.SA_SaoPaulo,
  interpretedBy=RegionExpressionInterpreter.class)
public class CalculadoraDeImpostosSA implements CalculadoraDeImpostos {

  @Override
  public BigDecimal calcular(BigDecimal valorTotal) {

    System.out.println("utilizando a calculadora de impostos SA");
    
    BigDecimal percentualSA = valorTotal.multiply(new BigDecimal("0.15"));
    valorTotal = valorTotal.add(percentualSA);    
    return valorTotal;
    
  }

}
