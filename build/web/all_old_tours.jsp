<%-- 
    Document   : all_old_books
    Created on : 27 thg 6, 2023, 17:12:49
    Author     : bravee06
--%>
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
    <body>
        <%@include file="all_component/navbar.jsp"%>
         
        <!-- Start Old Book  -->
        <div class="container-fluid" style="background-color:white">
            <h3 class="text-center">Old Tour</h3><!-- comment -->
            
            <%
            User u = (User) request.getSession().getAttribute("userobj");
            
            %>
            
            <div class="row">
               
                    <%
                    TourDAO bd = new TourDAO();
                    List<Tour> oldList = bd.getAllOldTour();
                    for(Tour b : oldList){
                    %>
                     <div class="col-md-3 ">
                    <div class="card col-hover">
                        <div class="card-body text-center">
                            <img alt="" src="img/<%=b.getPhoto()%>" style="width: 80%;height: 200px" class="img-thumblin" >
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
    </body>
</html>
