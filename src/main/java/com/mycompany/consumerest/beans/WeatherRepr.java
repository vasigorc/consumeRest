/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consumerest.beans;

/**
 *
 * @author vasigorc
 */
public class WeatherRepr {
    private String cityName;
    private String temp_C, weatherIconUrl, windspeedKmph,weatherDesc,
                humidity, visibility, pressure, feelsLikeC;

    public WeatherRepr(String cityName, String temp_C, String weatherIconUrl, String windspeedKmph, String humidity, String visibility, String weatherDesc, String pressure, String feelsLikeC) {
        this.cityName = cityName;
        this.temp_C = temp_C;
        this.weatherIconUrl = weatherIconUrl;
        this.windspeedKmph = windspeedKmph;
        this.humidity = humidity;
        this.weatherDesc = weatherDesc;
        this.visibility = visibility;
        this.pressure = pressure;
        this.feelsLikeC = feelsLikeC;
    }

    public WeatherRepr() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTemp_C() {
        return temp_C;
    }

    public void setTemp_C(String temp_C) {
        this.temp_C = temp_C;
    }

    public String getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(String weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    public void setWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getFeelsLikeC() {
        return feelsLikeC;
    }

    public void setFeelsLikeC(String feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }
}
