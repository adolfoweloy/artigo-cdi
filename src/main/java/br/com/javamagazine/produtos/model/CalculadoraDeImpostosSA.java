package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;

import br.com.javamagazine.extension.IncludeRegion;
import br.com.javamagazine.region.Region;

@IncludeRegion(Region.SA_SaoPaulo)
public class CalculadoraDeImpostosSA implements CalculadoraDeImpostos {

    @Override
    public BigDecimal calcular(BigDecimal valorTotal) {
        System.out.println("Utilizando a calculadora de impostos de Sao Paulo");
        BigDecimal percentual = new BigDecimal("0.15");
        return valorTotal.add(valorTotal.multiply(percentual));
    }

}
