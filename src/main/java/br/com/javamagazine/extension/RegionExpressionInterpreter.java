package br.com.javamagazine.extension;

import br.com.javamagazine.region.Region;
import br.com.javamagazine.region.ServerWebServiceClient;

public class RegionExpressionInterpreter { 

  public Boolean interpret(Region expression) {
    
    ServerWebServiceClient swsClient = new ServerWebServiceClient();
        
    // recupera a regiao atrav�s da api fornecida pelo servidor na nuvem.
    Region bucketLocation = swsClient.getBucketLocation();
    return bucketLocation.equals(expression);
    
  }

}
