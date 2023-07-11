
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<%@page import="dal.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Old Tour</title>
        <%@include file="all_component/allCss.jsp"%>
    </head>
    <body style="background: white">
        <%@include file="all_component/navbar.jsp"%>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            TourDAO tourDao = new TourDAO();
            Tour b = tourDao.getTourById(id);
            User u = (User) request.getSession().getAttribute("userobj");
        %>
        <div class="row p-3 ">
            <div class="col-md-6 text-center p-5 border bg-white">
                <img src="tour/<%=b.getPhoto()%>" style="height: 80%;width:200px"></br>
                <h4>Tour name:<span class="text-success"><%= b.getName()%></span> </h4>
                <h4>Author Name:<span class="text-success"><%= b.getAuthor()%></span></h4>
                <h3>Category:<span class="text-success"><%= b.getCategory()%></span> </h4><!-- comment -->
            </div>
            <div class="col-md-6 text-center p-5 border bg-white">
                
                <div class="row">
                    <div class="col-md-4 text-danger text-center p-2">
                        <i class="fas fa-money-bill-wave fa-3x"></i>
                        <p>Cash on delivey</p>
                    </div>
                    <div class="col-md-4 text-danger text-center p-2">
                        <i class="fas fa-undo-alt fa-3x"></i>
                        <p>Return Availiable</p>
                    </div>
                    <div class="col-md-4 text-danger text-center p-2">
                        <i class="fas fa-truck-moving fa-3x"></i>
                        <p>Free Delivery</p>
                    </div>
                </div>
                <div class="row text-center p-3">
                    <% if(b.getCategory().equals("Old")){
                    %>
                    <p class="text-primary text-center">Contact to seller</br>Emai:<%=b.getUser_email()%></p>

                    <a href="index.jsp">
                        <button class="btn btn-primary">
                            Back Home Page 
                        </button>
                    </a>

                    <%
                        }
                    else{ %>
                    <div class="col-md-6">
                        <a href="cart?id=<%= b.getId() %>&uid=<%= u.getId() %>" class="btn btn-primary">Add Cart</a>
                    </div>
                    <div class="col-md-6">
                        <a href="" class="btn btn-primary">Price:<%=b.getPrice()%></a>

                    </div>
                    <%
                        }
                    %>




                </div>
            </div>


        </div>
    </body>
</html>
