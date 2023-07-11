<%-- 
    Document   : register
    Created on : 21 thg 6, 2023, 18:41:22
    Author     : bravee06
--%>

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
        <%@include file="all_component/navbar.jsp"%>
        <div class="container" style="padding: 70px 0">
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <div class="card">
                        <div class="card-body ">
                            <form action="register" method="post">
                                <h4 class="text-center">Registration</h4>
                                <c:if test="${not empty successMsg}">
                                    <p class="text-center text-success">${successMsg}</p>
                                    <c:remove var="successMsg" scope="session"/>


                                </c:if>
                                <c:if test="${not empty failedMsg}">
                                    <p class="text-center text-danger">${failedMsg}</p>
                                    <c:remove var="failedMsg" scope="session"/>

                                </c:if>
                                <c:if test="${not empty errorMsg}">
                                    <p class="text-center text-danger">${errorMsg}</p>
                                    <c:remove var="errorMsg" scope="session"/>

                                </c:if>

                                <div class="form-group">
                                    <label for="exampleInputName">Enter Full Name</label>
                                    <input type="text" class="form-control" id="exampleInputPassword1" name="fname" placeholder="Full Name">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email </label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp" placeholder="Email ">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Phone Number</label>
                                    <input type="number" class="form-control" id="exampleInputEmail1" name="phone"aria-describedby="emailHelp" placeholder="Enter phone number">
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input type="password" class="form-control" id="exampleInputPassword1" name="pass" placeholder="Password">
                                </div>
                                <div class="form-check">
                                    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="check">
                                    <label class="form-check-label" for="exampleCheck1" >Agree Term Of Us</label>
                                </div>
                                <button type="submit" class="btn btn-primary">Submit</button>
                                


                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <%@include file="all_component/footer.jsp" %>
    </body>
</html>
