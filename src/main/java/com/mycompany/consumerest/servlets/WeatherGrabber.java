/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consumerest.servlets;

import com.mycompany.consumerest.beans.WeatherRepr;
import com.mycompany.consumerest.parsers.JsonWeatherParser;
import com.mycompany.consumerest.restservices.DayWeatherClient;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vasigorc
 */
@WebServlet(name = "OneWeather", urlPatterns = {"/oneweather"})
public class WeatherGrabber extends HttpServlet {

    private DayWeatherClient dwc;
    /*
        As there's no need to store just a few entries in a database, we'll hold
    them in a Map
    */
    private static final Map<Integer, String> citiesDb = new Hashtable<>();
    
    /*
        The names of the cities will be store in request format required by
        the Web Service provider.
    */
    static{
        citiesDb.put(544, "New+York");
        citiesDb.put(238, "Paris,france");
        citiesDb.put(353, "London,united+kingdom");
        citiesDb.put(556, "San+Francisco");
        citiesDb.put(44, "Athens,greece");
        citiesDb.put(550, "Bangkok");
        citiesDb.put(644, "Venice,italy");
    }

    @Override
    public void init() throws ServletException {
        dwc  = new DayWeatherClient();
    }
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cityId = request.getParameter("cityId");
        String str ="";
        if (WeatherGrabber.citiesDb.containsKey(Integer.parseInt(cityId))) {
            str = dwc.getSingleTemp(String.class, WeatherGrabber.citiesDb.get(Integer.parseInt(cityId)));
        }else{
            str = dwc.getSingleTemp(String.class, "San+Francisco");
        }        
        JsonWeatherParser jwp = new JsonWeatherParser(str);
        WeatherRepr wr =jwp.getWeatherRepr();
        request.setAttribute("weather", wr);
        String url = "aparticularweather.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
