<%@page import="model.*" %>
<%@page import="java.util.*" %>
<%@page import="dal.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tour Home</title>
        <%@include file="all_component/allCss.jsp"%>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

        <style type="text/css">
            .back-img{
                background: url("img/TourTemplate001.jpg");
                height: 50vh;
                width: 100%;
                background-repeat: no-repeat;
                background-size: cover;
            }
            .col-hover:hover{
                background-color: #f2da96;
            }
        </style>
    </head>
    <body>
        <%
            User u = (User) request.getSession().getAttribute("userobj");
            
        %>
        <%@include file="all_component/navbar.jsp"%>

        <div class="container-fluid back-img">
            <h2 class="text-center text-danger">
                Tour Management System
            </h2>
        </div>
        <!-- Start Recent Tour  -->
        <div class="container-fluid" style="background-color:white;padding-top: 50px">
            <h3 class="text-center">Recent Tour</h3><!-- comment -->
            <div class="row">

                <%
                TourDAO bd = new TourDAO();
                List<Tour> recentList = bd.getRecentTour();
                for(Tour b : recentList){
                %>
                <div class="col-md-4 ">
                    <div class="card col-hover">
                        <div class="card-body text-center">
                            <img alt="" src="img/<%=b.getPhoto()%>" style="width: 80%;height: 250px" class="img-thumblin" >
                            <p>Tour Name:<%=b.getName()%></p>
                            <p>Creator:<%=b.getAuthor()%></p>
                            <%
                                if(b.getCategory().equals("Old")){
                            %>
                            <p>Categorie: <%=b.getCategory()%></p>
                            <div class="row" style="justify-content: center">
                                <a href="view_tour.jsp?id=<%=b.getId()%>" class="btn btn-success btn-sm ml-4">View Details</a>
                                <a href="#" class="btn btn-danger btn-sm ml-1"><%= b.getPrice()%></a>

                            </div>
                            <% }else{
                            
                            %>
                            <p>Categorie: <%=b.getCategory()%></p>
                            <div class="row" style="justify-content: center">
                                <% if (u != null) { %>
                                <a href="cart?id=<%= b.getId() %>&uid=<%= u.getId() %>" class="btn btn-danger btn-sm ml-4">Add Cart</a>
                                <% } else { %>
                                <a href="login.jsp" class="btn btn-danger btn-sm ml-5">Add Cart</a>
                                <% } %>
                                <a href="view_tour.jsp?id=<%=b.getId()%>" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="#" class="btn btn-danger btn-sm ml-1"><%= b.getPrice()%></a>

                            </div>
                            <%
                                }
                            %>

                        </div>
                    </div>
                </div>
                <%
                    }    
                %>

            </div>
        </div>

        <!-- End Recent Book  -->
        <!-- Start New Book -->
        <div class="container-fluid" style="background-color:white;padding-top: 50px">
            <h3 class="text-center">New Tour</h3><!-- comment -->
            <div class="row">

                <%
                    
                List<Tour> newList = bd.getNewTour();
                for(Tour b  : newList){
                %>
                <div class="col-md-4 ">
                    <div class="card col-hover">
                        <div class="card-body text-center">
                            <img alt="" src="img/<%=b.getPhoto()%>" style="width: 80%;height: 250px" class="img-thumblin" >
                            <p><%=b.getName()%></p>
                            <p><%=b.getAuthor()%></p>
                            <p>Categorie: <%=b.getCategory()%></p>
                            <div class="row" style="justify-content: center">
                                <%
                                      if(u != null){
                                %>
                                <a href="cart?id=<%=b.getId()%>&&uid=<%=u.getId()%>" class="btn btn-danger btn-sm ml-4">Add Cart</a>
                                <%
                                    }else{
                                %>
                                <a href="login.jsp" class="btn btn-danger btn-sm ml-4">Add Cart</a>
                                <%
                                    }
                                %>
                                <a href="view_tour.jsp?id=<%=b.getId()%>" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="#" class="btn btn-danger btn-sm ml-1"><%= b.getPrice()%></a>
                            </div>
                        </div>

                    </div><!-- comment -->
                </div>
                <%
                    }
                %>
            </div>
        </div>

        <!-- End New Book -->

        <!-- Start Old Book  -->
        <div class="container-fluid" style="background-color:white;padding: 50px 0">
            <h3 class="text-center">Old Tour</h3><!-- comment -->
            <div class="row">

                <%
                    
                List<Tour> oldList = bd.getOldTour();
                for(Tour b : oldList){
                %>
                <div class="col-md-4 ">
                    <div class="card col-hover">
                        <div class="card-body text-center">
                            <img alt="" src="img/<%=b.getPhoto()%>" style="width: 80%;height: 250px" class="img-thumblin" >
                            <p><%=b.getName()%></p>
                            <p><%=b.getAuthor()%></p>
                            <p>Categorie: <%=b.getCategory()%></p>
                            <div class="row" style="justify-content: center">
                                <a href="view_tour.jsp?id=<%=b.getId()%>" class="btn btn-success btn-sm ml-5">View Details</a>
                                <a href="#" class="btn btn-danger btn-sm ml-1"><%= b.getPrice()%></a>

                            </div>
                        </div>

                    </div><!-- comment -->
                </div>
                <%
                    }
                %>
            </div>
        </div>

            <%@include file="all_component/footer.jsp"%>
    </body>
</html>
