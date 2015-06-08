/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consumerest.servlets;

import com.mycompany.consumerest.beans.City;
import com.mycompany.consumerest.restservices.SplashBaseClient;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
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
@WebServlet(name = "Main", urlPatterns = {"/home"})
public class Main extends HttpServlet {

    /*
     We will use LinkedHashSet for faster access time and because of relati-
     vely small number of contained items. Static "synchronizedSet" method
     assures that the set is thread-safe.
     */
    Set<City> cities = Collections.synchronizedSet(new LinkedHashSet<City>());
    private SplashBaseClient sbc;

    @Override
    public void init() throws ServletException {
        sbc = new SplashBaseClient();
        //add cities (id numbers found manually)
        City newYork = sbc.getOneCity(City.class, "544");
        City paris = sbc.getOneCity(City.class, "238");
        City london = sbc.getOneCity(City.class, "353");
        City sanFrancisco = sbc.getOneCity(City.class, "556");
        City athens = sbc.getOneCity(City.class, "44");
        cities.add(newYork);
        cities.add(paris);
        cities.add(london);
        cities.add(sanFrancisco);
        cities.add(athens);
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

        try {
            request.setAttribute("cityList", cities);
            request.setAttribute("error", "An error produced on the "
                    + "server side and the list of cities cannot be shown."
                    + " We're sorry!");
            String url = "main.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            System.out.println("We couldn't even get it properly to the client"
                    + ", Vasile. Please trace the error: "+e.getMessage());
        }
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
