
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  isELIgnored="false"%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sell old tour</title>
        <%@include file="all_component/allCss.jsp"%>
       
    </head>
    <body>
        <%@include file="all_component/navbar.jsp"%>
        <c:if test="${ empty userobj}">
                     <c:redirect url="login.jsp"></c:redirect>
            </c:if>
        <div class="container">
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <div class="card">
                        <div class="card-body">
                            <c:if test="${not empty successMsg}">
                            <p class="text-center text-success">${successMsg}</p>
                            <c:remove scope="session" var="successMsg"/>
                                
                        </c:if>
                            <c:if test="${not empty failedMsg}">
                            <p class="text-center text-danger">${failedMsg}</p>
                            <c:remove scope="session" var="failedMsg"/>
                                
                        </c:if>
                            <p class="text-center text-primary">Sell Old Book</p>
                            <form action="add_old_tours" method="post" enctype='multipart/form-data'>
                                Email contact: <input class="form-control" type="text" readonly name="email" placeholder="${userobj.email}">
                                <div class="form-group">
                                    <label for="exampleFormControlInput1">Tour name</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Tour Name" name="name">
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlInput1">Book author</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Tour Provider" name="author">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Price</label>
                                    <input type="number" class="form-control" id="exampleInputEmail1" name="price" aria-describedby="emailHelp" placeholder="Enter price">
                                </div>
                                
                               
                                <form>
                                    <div class="form-group">
                                        <label for="exampleFormControlFile1">Choose file image</label>
                                        <input name="bimg" type="file" class="form-control-file" id="exampleFormControlFile1">
                                    </div>

                                    <button class="btn btn-primary" type="submit">Sell</button>
                                </form>
                        </div>
                    </div>
                </div>
            </div>
                
            
        </div>
    </body>
</html>
