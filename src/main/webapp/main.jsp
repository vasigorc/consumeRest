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
            <div class="large-9 columns">
                <ul class="button-group right">
                    <li><a href="#" class="button">Link 1</a></li>
                    <li><a href="#" class="button">Link 2</a></li>
                    <li><a href="#" class="button">Link 3</a></li>
                    <li><a href="#" class="button">Link 4</a></li>
                </ul>
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
                                <div class="item"><img style="width: 287px; height: 191px;" id="${city.id}" class="lazyOwl" data-src="${city.url}" alt="Lazy Owl Image"></div>
                            </c:forEach>
                        </div>
                    </c:otherwise>
                </c:choose>
                <hr>
            </div>
        </div>

        <div class="row">
            <div class="large-4 columns">
                <img src="http://placehold.it/400x300&text=[img]">
            </div>
            <div class="large-8 columns">
                <h4>This is a content section.</h4>
                <div class="row">
                    <div class="large-6 columns">
                        <p>Bacon ipsum dolor sit amet nulla ham qui sint exercitation eiusmod commodo, chuck duis velit. Aute in reprehenderit, dolore aliqua non est magna in labore pig pork biltong. Eiusmod swine spare ribs reprehenderit culpa. Boudin aliqua adipisicing rump corned beef.</p>
                    </div>
                    <div class="large-6 columns">
                        <p>Pork drumstick turkey fugiat. Tri-tip elit turducken pork chop in. Swine short ribs meatball irure bacon nulla pork belly cupidatat meatloaf cow. Nulla corned beef sunt ball tip, qui bresaola enim jowl. Capicola short ribs minim salami nulla nostrud pastrami.</p>
                    </div>
                </div>
            </div>
        </div>




        <div class="row">
            <div class="large-8 columns">
                <h4>This is a content section.</h4>

                <p>Bacon ipsum dolor sit amet nulla ham qui sint exercitation eiusmod commodo, chuck duis velit. Aute in reprehenderit, dolore aliqua non est magna in labore pig pork biltong. Eiusmod swine spare ribs reprehenderit culpa. Boudin aliqua adipisicing rump corned beef.</p>

                <p>Pork drumstick turkey fugiat. Tri-tip elit turducken pork chop in. Swine short ribs meatball irure bacon nulla pork belly cupidatat meatloaf cow. Nulla corned beef sunt ball tip, qui bresaola enim jowl. Capicola short ribs minim salami nulla nostrud pastrami.</p>

            </div>
            <div class="large-4 columns">
                <img src="http://placehold.it/400x300&text=[img]">
            </div>
        </div>



        <footer class="row">
            <div class="large-12 columns">
                <hr/>
                <div class="row">
                    <div class="large-6 columns">
                        <p>© Copyright no one at all. Go to town.</p>
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
        <script src="js/owl-carousel/assets/js/bootstrap-collapse.js"></script>
        <script src="js/owl-carousel/assets/js/bootstrap-transition.js"></script>
        <script src="js/owl-carousel/assets/js/bootstrap-tab.js"></script>
        <script src="js/owl-carousel/assets/js/google-code-prettify/prettify.js"></script>
        <script src="js/owl-carousel/assets/js/application.js"></script>
    </body>
</html>
