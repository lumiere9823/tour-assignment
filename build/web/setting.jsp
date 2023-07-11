<%-- 
    Document   : setting
    Created on : 28 thg 6, 2023, 17:00:00
    Author     : bravee06
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  isELIgnored="false"%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="all_component/allCss.jsp"%>
        <style>
            a{
                text-decoration: none;
                color:black;

            }
            a:hover{
                text-decoration: none;
            }
        </style>

    </head>
    <body>
        <%@include file="all_component/navbar.jsp"%>
        <div class="container">
            <c:if test="${ empty userobj}">
                <c:redirect url="login.jsp"></c:redirect>
            </c:if>
            <c:if test="${not empty userobj}">
                <h3 class="text-center">Hello ${userobj.name}</h3>

            </c:if>


            <div class="row p-5">

                <div class="col-md-4">

                    <div class="card">
                        <div class="card-body text-center">
                            <div class="text-primary">
                                <i class="fas fa-book-open fa-3x"></i>
                            </div>

                            <a href="sell_tour.jsp"><h3>Sell old Tour</h3></a>
                        </div>

                    </div>
                </div>
                <div class="col-md-4">
                    <a href=""></a>
                    <div class="card">
                        <div class="card-body text-center">
                            <a href="old_tour.jsp">
                            <div class="text-primary">
                                <i class="fa-solid fa-book fa-3x"></i>
                            </div>

                            <h3>Old tours</h3></a>
                        </div>

                    </div>
                </div>
                <div class="col-md-4">
                    <a href=""></a>
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="text-primary">
                                <i class="fa-sharp fa-solid fa-lock fa-3x"></i>
                            </div>

                            <a href="edit_profile.jsp"><h3>Edit Profile</h3></a>
                        </div>

                    </div>
                </div>
                <div class="col-md-4 mt-3">
                    <a href="edit_profile.jsp"></a>
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="text-primary">
                                <i class="fa-solid fa-location-dot fa-3x" style="color: red"></i>                            </div>

                            <h3>Your Address </h3>
                            <h4>Edit Address</h4>
                        </div>

                    </div>
                </div>
                <div class="col-md-4 mt-3">
                    <a href="cart.jsp">
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="text-primary">
                                <i class="fa-sharp fa-solid fa-cube fa-3x"style="color: yellow"></i>
                            </div>

                            <h3>My Order </h3>
                            <h4>Track your Order</h4>
                        </div>

                    </div></a>
                </div>
                <div class="col-md-4 mt-3">
                    <a href=""></a>
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="text-primary">
                                <i class="fa-solid fa-user fa-3x" style="color: green"></i>                                <div>
                                    <h3>Help Center </h3>
                                    <h4>24/7 Services</h4>
                                </div>

                            </div>
                        </div>


                    </div>
                </div>

                </body>
                </html>
