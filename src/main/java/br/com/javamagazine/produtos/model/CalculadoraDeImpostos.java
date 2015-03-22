package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;

import br.com.javamagazine.region.Region;
import br.com.javamagazine.region.ServerWebServiceClient;

public class CalculadoraDeImpostos {

  public BigDecimal calcular(BigDecimal valorTotal) {
      
      // guarda o valor do percentual
      BigDecimal percentual = BigDecimal.ZERO;
      
      // recupera a regiao através da api fornecida pelo servidor na nuvem.
      ServerWebServiceClient swsClient = new ServerWebServiceClient();
      Region bucketLocation = swsClient.getBucketLocation();
      
      // imposto de 15% para a região de sao paulo e 4% para US_West
      if (bucketLocation.equals(Region.SA_SaoPaulo)) {
          percentual = new BigDecimal("0.15");
      } else if(bucketLocation.equals(Region.US_West)) {
          percentual = new BigDecimal("0.04");
      }
      
      return valorTotal.add(valorTotal.multiply(percentual));
  }

}