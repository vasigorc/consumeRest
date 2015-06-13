/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consumerest.parsers;

import com.mycompany.consumerest.beans.WeatherRepr;
import java.io.Closeable;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

/**
 *
 * @author vasigorc
 */
public class JsonWeatherParser implements Closeable {

    private JsonParser parser;
    private StringReader reader;

    public JsonWeatherParser() {
        this.reader = new StringReader("[]");
        this.parser = Json.createParser(reader);
    }

    public JsonWeatherParser(String cityJson) {
        this.reader = new StringReader(cityJson);
        this.parser = Json.createParser(reader);
    }

    /*
     This method will return an instance of WeatherRepr - data
     grabbed from external Web Service.
     */
    public WeatherRepr getWeatherRepr() {
        if (reader.toString().equals("[]")) {
            return null;
        }
        Event event = null;
        WeatherRepr weather = new WeatherRepr();
        while (parser.hasNext()) {
            event = parser.next();
            if (event == Event.KEY_NAME) {
                String keyValue = parser.getString();
                switch (keyValue) {
                    case "request":
                        while (event != Event.END_ARRAY) {
                            event = parser.next();
                            if (event == Event.KEY_NAME && "query".equals(parser.getString())) {
                                parser.next();
                                weather.setCityName(parser.getString());
                            }
                        }
                        break;
                    case "current_condition":
                        /*
                         here var charsRemaining stays for characters still
                         remaining in the current_condition object
                         */
                        boolean charsRemaining = true;
                        while (parser.hasNext() && charsRemaining) {
                            event = parser.next();
                            if (event == Event.KEY_NAME && "windspeedMiles".equals(parser.getString())) {
                                charsRemaining = false;
                            }
                            if (event == Event.KEY_NAME) {
                                keyValue = parser.getString();                                
                                switch (keyValue) {
                                    case "FeelsLikeC":
                                        parser.next();
                                        weather.setFeelsLikeC(parser.getString());
                                        break;
                                    case "humidity":
                                        parser.next();
                                        weather.setHumidity(parser.getString());
                                        break;
                                    case "pressure":
                                        parser.next();
                                        weather.setPressure(parser.getString());
                                        break;
                                    case "temp_C":
                                        parser.next();
                                        weather.setTemp_C(parser.getString());
                                        break;
                                    case "visibility":
//                                        Logger.getLogger(JsonWeatherParser.class.getName()).log(Level.INFO, keyValue);
                                        parser.next();
                                        weather.setVisibility(parser.getString());
                                        break;
                                    case "weatherDesc":
                                        while (event != Event.END_ARRAY) {
                                            event = parser.next();
                                            if (event == Event.KEY_NAME && "value".equals(parser.getString())) {
                                                parser.next();
                                                weather.setWeatherDesc(parser.getString());
                                            }
                                        }
                                        break;
                                    case "weatherIconUrl":
                                        while (event != Event.END_ARRAY) {
                                            event = parser.next();
                                            if (event == Event.KEY_NAME && "value".equals(parser.getString())) {
                                                parser.next();
                                                String prettyUrl = 
                                                        parser.getString().replace("\\", "");
                                                weather.setWeatherIconUrl(prettyUrl);
                                            }
                                        }
                                        break;
                                    case "windspeedKmph":
                                        parser.next();
                                        weather.setWindspeedKmph(parser.getString());
                                        break;
                                    default: {
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    default: {
                    }
                }
            }
        }
        return weather;
    }

    @Override
    public void close() throws IOException {
        this.parser.close();
        this.reader.close();
    }
}
