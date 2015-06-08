/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consumerest.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author vasigorc
 */
@XmlRootElement
@XmlType(name = "data")
public class WeatherData {

    protected WeatherRequest request;
    protected CurrentCondition current;

    public WeatherData(WeatherRequest request, CurrentCondition current) {
        this.request = request;
        this.current = current;
    }

    public WeatherData() {
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "request")
    public WeatherRequest getRequest() {
        return request;
    }

    @XmlElement(name = "current_condition")
    public CurrentCondition getCurrent() {
        return current;
    }

    public void setRequest(WeatherRequest request) {
        this.request = request;
    }

    public void setCurrent(CurrentCondition current) {
        this.current = current;
    }

    class WeatherRequest {

        private String cityName;

        public WeatherRequest(String cityName) {
            this.cityName = cityName;
        }

        public WeatherRequest() {
        }

        @XmlElement(name = "query")
        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

    }

    class CurrentCondition {

        private String temp_C, weatherIconUrl, windspeedKmph,
                humidity, visibility, pressure, feelsLikeC;

        public CurrentCondition(String temp_C, String weatherIconUrl, String windspeedKmph, String humidity, String visibility, String pressure, String feelsLikeC) {
            this.temp_C = temp_C;
            this.weatherIconUrl = weatherIconUrl;
            this.windspeedKmph = windspeedKmph;
            this.humidity = humidity;
            this.visibility = visibility;
            this.pressure = pressure;
            this.feelsLikeC = feelsLikeC;
        }

        public CurrentCondition() {
        }
        
        @XmlElement(name="temp_C")
        public String getTemp_C() {
            return temp_C;
        }

        public void setTemp_C(String temp_C) {
            this.temp_C = temp_C;
        }

        @XmlElement(name="weatherIconUrl")
        public String getWeatherIconUrl() {
            return weatherIconUrl;
        }

        public void setWeatherIconUrl(String weatherIconUrl) {
            this.weatherIconUrl = weatherIconUrl;
        }

        @XmlElement(name="windspeedKmph")
        public String getWindspeedKmph() {
            return windspeedKmph;
        }

        public void setWindspeedKmph(String windspeedKmph) {
            this.windspeedKmph = windspeedKmph;
        }

        @XmlElement(name="humidity")
        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        @XmlElement(name="visibility")
        public String getVisibility() {
            return visibility;
        }

        public void setVisibility(String visibility) {
            this.visibility = visibility;
        }

        @XmlElement(name="pressure")
        public String getPressure() {
            return pressure;
        }

        public void setPressure(String pressure) {
            this.pressure = pressure;
        }

        @XmlElement(name="FeelsLikeC")
        public String getFeelsLikeC() {
            return feelsLikeC;
        }

        public void setFeelsLikeC(String feelsLikeC) {
            this.feelsLikeC = feelsLikeC;
        }
        
    }
}
