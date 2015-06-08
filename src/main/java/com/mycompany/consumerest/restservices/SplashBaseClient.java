/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consumerest.restservices;

import java.io.Closeable;
import java.io.IOException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author vasigorc
 */
public class SplashBaseClient implements Closeable{
    
    private final WebTarget manyC;
    private final WebTarget singleC;
    private final Client client;
    private static final String BASE_URI = "http://www.splashbase.co/api/v1/images";

    public SplashBaseClient() {
        this.client = javax.ws.rs.client.ClientBuilder.newClient();        
        this.singleC = client.target(BASE_URI).path("{id}");
        this.manyC = client.target(BASE_URI).path("search");
    }
    
    public <T> T getOneCity(Class<T> responseType, String cityId){
        WebTarget resource = singleC.resolveTemplate("id", cityId);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);    
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
