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
public class DayWeatherClient implements Closeable {

    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://api.worldweatheronline.com/free/v2/weather.ashx";

    public DayWeatherClient() {
        this.client = javax.ws.rs.client.ClientBuilder.newClient();
        this.webTarget = client.target(BASE_URI);
    }

    public <T> T getSingleTemp(Class<T> responseType, String cityName) {
        WebTarget resource = webTarget.queryParam("q", cityName)
                .queryParam("num_of_days", "1").queryParam("tp", "24")
                .queryParam("format", "json")
                .queryParam("key", "ad884201893d47f3fe4bc8934319e");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    @Override
    public void close() throws IOException {
        client.close();
    }
}
