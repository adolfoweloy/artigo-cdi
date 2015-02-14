package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;

import br.com.javamagazine.region.Region;
import br.com.javamagazine.region.ServerWebServiceClient;

public class CalculadoraDeImpostos {
  
  private ServerWebServiceClient swsClient;
  
  public CalculadoraDeImpostos (ServerWebServiceClient swsClient) {
    this.swsClient = swsClient;
  }
  
  public BigDecimal calcular(BigDecimal valorTotal) {
    Region region = swsClient.getBucketLocation();
    
    // calculos sao todos ficticios
    switch (region) {
      case SA_SaoPaulo:
        BigDecimal percentualSA = valorTotal.multiply(new BigDecimal("0.15"));
        valorTotal = valorTotal.add(percentualSA);
        break;

      case US_West:
        BigDecimal percentualUS = valorTotal.multiply(new BigDecimal("0.20"));
        
        if (valorTotal.compareTo(new BigDecimal("100.00")) > 0) {
          percentualUS = percentualUS.add(new BigDecimal("0.04"));
        }
        
        valorTotal = valorTotal.add(percentualUS);
        break;
        
    }

    return valorTotal;
  }

}