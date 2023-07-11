<%-- 
    Document   : all_books
    Created on : 25 thg 6, 2023, 14:44:42
    Author     : bravee06
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: All Tour</title>
        <%@include file="allCss.jsp"%>


    </head>
    <body>
        <%@include file="navbar.jsp"%>
        <h1 class="text-center">ALL TOUR ON DATABASE </h1>
        <c:if test="${not empty successMsg}">
            <p class="text-center text-success">${successMsg}</p>
            <c:remove scope="session" var="successMsg"></c:remove>
        </c:if>
        <table class="table">
            <thead class="bg-primary">
                <tr>
                    <th scope="col">Tour ID</th>
                    <th scope="col">Tour Image</th>
                    <th scope="col">Tour Name</th>
                    <th scope="col">Tour Author</th>
                    <th scope="col">Price</th>
                    <th scope="col">Category</th>
                    <th scope="col">Status</th>
                    <th scope="col">Action</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach var="b" items="${sessionScope.listTour}">
                    <tr>
                        <th scope="row">${b.id}</th>
                        <td>
                            <img style="width: 100px;height: 100px" src="../tour/${b.photo}" alt="tour">
                        </td>
                        <td>
                            ${b.name}
                        </td>
                        <td>
                            ${b.author}
                        </td>
                        <td>
                            ${b.price}
                        </td>
                        <td>
                            ${b.category}
                        </td>
                        <td>
                            ${b.status}
                        </td>
                        <td>
                            <a href="../update_Tour?id=${b.id}">
                                <button class="btn btn-primary"><i class="fa-solid fa-pen-to-square"></i></button>
                            </a>
                            <a onclick="doDelete(${b.id})">

                                <button  class="btn btn-danger">  <i class="fa-solid fa-trash-can"></i></button>

                            </a>
                        </td>

                    </tr>
                </c:forEach>


            </tbody>
        </table>
        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("Are you sure to delete tour by ID =" + id)) {
                    window.location = "../delete_tour?id=" + id;
                }
            }
        </script>
    </body>
</html>
