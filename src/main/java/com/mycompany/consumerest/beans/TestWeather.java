/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consumerest.beans;

import com.mycompany.consumerest.restservices.DayWeatherClient;
import com.mycompany.consumerest.restservices.SplashBaseClient;
import com.mycompany.consumerest.beans.City;

/**
 *
 * @author vasigorc
 */
public class TestWeather {
    private WeatherData wd;
    
    public TestWeather(){
        wd = new WeatherData();
    }

    public WeatherData getWd() {
        return wd;
    }

    public void setWd(WeatherData wd) {
        this.wd = wd;
    }
    
    public static void main(String[]args){
        TestWeather tw = new TestWeather();
        DayWeatherClient dwc = new DayWeatherClient();
        tw.setWd(dwc.getSingleTemp(WeatherData.class, "New+York"));
        System.out.println(tw.getWd().getCurrent().getPressure());
//        SplashBaseClient sbc = new SplashBaseClient();
//        City london = sbc.getOneCity(City.class, "353");
//        System.out.println(london.toString());
    }
}
