<%-- 
    Document   : aparticularweather
    Created on : 10 juin 2015, 20:11:06
    Author     : vasigorc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
        <div class="row">
            <div class="large-4 columns">
                <img src="<c:url value="${weather.weatherIconUrl}"/>">
            </div>
            <div class="large-8 columns">
                <h4><span class="calligraphic"><c:out value="${weather.cityName}"/></span></h4>
                <div class="row">
                    <div class="large-6 columns">
                        <p>
                            The weather is <c:out value="${fn:toLowerCase(weather.weatherDesc)}"/>.
                            The felt temperature is <c:out value="${weather.feelsLikeC}"/>&#176;C.
                            Visibility is <c:out value="${weather.visibility}"/> stature miles and 
                            air pressure constitutes <c:out value="${weather.pressure}"/> atmospheres.
                        </p>
                    </div>
                    <div class="large-6 columns">
                        <p>
                        <h5><span style="color: #333333">Other info:</span></h5>
                        <table style="border-width: 0">
                            <tr>
                                <td><img src='images/Temperature-2-32.png'/></td>
                                <td><c:out value="${weather.temp_C}"/>&#176;C</td>
                            </tr>
                            <tr>
                                <td><img height="32" width="32" src='images/Chance-Rain-256.png'/></td>
                                <td><c:out value="${weather.humidity}"/>%</td>
                            </tr>
                            <tr>
                                <td><img height="32" width="32" src='images/Green-Windmill-128.png'/></td>
                                <td><c:out value="${weather.windspeedKmph}"/> km/h</td>
                            </tr>
                        </table>
                        </p>
                    </div>
                </div>
            </div>
        </div>
