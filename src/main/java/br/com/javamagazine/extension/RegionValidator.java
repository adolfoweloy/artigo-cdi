package br.com.javamagazine.extension;

import br.com.javamagazine.region.Region;
import br.com.javamagazine.region.ServerWebServiceClient;

public class RegionValidator {

    public boolean unsupported(Region region) {
        ServerWebServiceClient swsClient = new ServerWebServiceClient();
        
        // recupera a regiao através da api fornecida pelo servidor na nuvem.
        Region bucketLocation = swsClient.getBucketLocation();
        return !bucketLocation.equals(region);
    }

}
