package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;

import javax.enterprise.inject.Alternative;

@Alternative
public class CalculadoraDeImpostosUS implements CalculadoraDeImpostos {

    @Override
    public BigDecimal calcular(BigDecimal valorTotal) {
        System.out.println("Utilizando a calculadora de impostos dos EUA");
        BigDecimal percentual = new BigDecimal("0.04");
        return valorTotal.add(valorTotal.multiply(percentual));
    }

}
