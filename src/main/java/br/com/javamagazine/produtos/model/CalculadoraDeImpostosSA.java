package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;

import javax.enterprise.inject.Alternative;

@Alternative
public class CalculadoraDeImpostosSA implements CalculadoraDeImpostos {

    @Override
    public BigDecimal calcular(BigDecimal valorTotal) {
        System.out.println("Utilizando a calculadora de impostos de Sao Paulo");
        BigDecimal percentual = new BigDecimal("0.15");
        return valorTotal.add(valorTotal.multiply(percentual));
    }

}
