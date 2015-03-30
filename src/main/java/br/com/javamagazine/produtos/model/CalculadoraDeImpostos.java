package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;

public interface CalculadoraDeImpostos {

    BigDecimal calcular(BigDecimal valorTotal);

}