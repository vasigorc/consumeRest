<%-- 
    Document   : main
    Created on : 4 juin 2015, 19:42:28
    Author     : vasigorc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html >
<html>
    <head>
        <title>Place & Weather</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="images/Tent.ico"/>
        <link rel="stylesheet" href="css/foundation.min.css"></link>
        <link rel="stylesheet" href="css/foundation.css"></link>
        <link rel="stylesheet" href="css/owl-carousel/owl.carousel.css"></link>
        <link rel="stylesheet" href="css/owl-carousel/owl.theme.css"></link>
        <link rel="stylesheet" href="css/owl-carousel/owl.transitions.css"></link>
        <link rel="stylesheet" href="css/mainpage.css"></link>
        <!--        <script type="text/javascript" src="js/jquery.min.js"></script>-->        
    </head>
    <body>


        <div class="row">
            <div class="large-3 columns">
                <h1><img src="images/Gnome-Weather-Few-Clouds-64.png"></h1>
            </div>
            
        </div>

        <div class="row">
            <div class="large-12 columns">
                <!--                <img src="http://placehold.it/1000x400&text=[img]">-->
                <c:choose>
                    <c:when test="${cityList.size()<1}">
                        <h3><c:out value="${error}"/></h3>
                    </c:when>
                    <c:otherwise>
                        <div id="homecarousel" class="owl-carousel">
                            <c:forEach items="${cityList}" var="city">
                                <div class="item"><img style="width: 287px; height: 191px;" id="${city.id}" class="lazyOwl" data-src="${city.url}" alt="Lazy Owl Image" data-bind="event:{click: grabInfo, mouseover: displayCity, mouseout: hideCity}"></div>
                                </c:forEach>
                        </div>
                    </c:otherwise>
                </c:choose>
                <hr>
            </div>
        </div>

        <div id="weathercontent">
            <div class="row">
                <div id="initAnnounce" class="confetti" style="font-size: 5em; color: crimson; margin-left: 1em;">
                    Get current weather for a city
                </div>
                <div id="particularCity" class="confetti" style="font-size: 4em; color: #007ba4; margin-left: 1em;">
                    <span data-bind="text: cityName"></span>
                </div>
            </div>
        </div>


        <footer class="row">
            <div class="large-12 columns">
                <hr/>
                <div class="row">
                    <div class="large-6 columns">
                        <p>© A Vasile Gorcinschi's project for Concordia University.</p>
                    </div>
                    <div class="large-6 columns">
                        <ul class="inline-list right">
                            <li><a href="#">Link 1</a></li>
                            <li><a href="#">Link 2</a></li>
                            <li><a href="#">Link 3</a></li>
                            <li><a href="#">Link 4</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>

        <script type="text/javascript" src="js/knockout-3.3.0.js"></script>
        <script type="text/javascript" src="js/knockout.mapping-latest.js"></script>
        <script type="text/javascript" src="js/owl-carousel/assets/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/owl-carousel/owl.carousel.js"></script>        
        <script>
            $(document).ready(function () {

                $("#homecarousel").owlCarousel({
                    items: 4,
                    lazyLoad: true,
                    navigation: true
                });
            });
        </script>
        <script>
            function WeatherModel() {
                var self = this;

                self.cityName = ko.observable("");

                self.citiesMap = [];
                self.citiesMap["544"] = "New York, US";
                self.citiesMap["238"] = "Paris, FR";
                self.citiesMap["353"] = "London, UK";
                self.citiesMap["556"] = "San Francisco, US";
                self.citiesMap["44"] = "Athens, GR";
                self.citiesMap["550"] = "Bangkok, TH";
                self.citiesMap["644"] = "Venice, IT";

                self.displayCity = function (data, event) {
                    $("#initAnnounce").text("Get today's weather in");
                    self.cityName(self.citiesMap[event.target.id]);
                };

                self.hideCity = function (data, event) {
                    $("#initAnnounce").text("Get current weather for a city");
                    self.cityName("");
                };

                self.grabInfo = function (data, event) {
                    //alert(event.target.id);
                    $("#weathercontent").load("oneweather", {cityId: event.target.id});
                };
            }
            ;
            var weatherModel = new WeatherModel();
            ko.applyBindings(weatherModel);
        </script>
        <script src="js/owl-carousel/assets/js/bootstrap-collapse.js"></script>
        <script src="js/owl-carousel/assets/js/bootstrap-transition.js"></script>
        <script src="js/owl-carousel/assets/js/bootstrap-tab.js"></script>
        <script src="js/owl-carousel/assets/js/google-code-prettify/prettify.js"></script>
        <script src="js/owl-carousel/assets/js/application.js"></script>
    </body>
</html>
