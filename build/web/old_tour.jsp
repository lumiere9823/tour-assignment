<%@page import="java.util.*" %>
<%@page import="dal.*" %>
<%@page import="model.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
   <%@include file="all_component/allCss.jsp"%>
       
    </head>
    <body>
        <c:if test="${ empty userobj}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <%@include file="all_component/navbar.jsp"%>
        <div class="container mt-3">
             <c:if test="${not empty successMsg}">
                            <p class="text-center text-success">${successMsg}</p>
                            <c:remove scope="session" var="successMsg"/>
                                
                        </c:if>
                            <c:if test="${not empty failedMsg}">
                            <p class="text-center text-danger">${failedMsg}</p>
                            <c:remove scope="session" var="failedMsg"/>
                                
                        </c:if>
            <table class="table " >
                <thead class="bg-primary text-white">
    <tr>
     
      <th scope="col">Tour Name</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
       <th scope="col">Category</th>
      <th scope="col">Action</th> 
    </tr>
  </thead>
  <tbody>
      <%
      User u = (User) session.getAttribute("userobj");
      String email = u.getEmail();
      TourDAO bd = new TourDAO();
      List<Tour> list = bd.getTourByOld("admin","Old");
      for(Tour b : list){
      %>
      <tr>
      <th scope="row"><%=b.getName()%></th>
      <td><%=b.getAuthor()%></td>
      <td><%=b.getPrice()%></td>
       <td><%=b.getCategory()%></td>
      <td>
          <a href="delete_old_tour?em=<%=email%>" class="btn btn-sm btn-danger">Delete</a>
      </td>
    </tr>
      <%
          }
      %>
    
   
  </tbody>
</table>
        </div>
        
    </body>
</html>
