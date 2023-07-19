<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Add Tourss</title>
        <%@include file="allCss.jsp"%>

    </head>
    <body>
        <%@include file="navbar.jsp"%>
        <div class="container" style="margin-left: 500px;">

            <div class="row">

                <div class="col-md-5">
                    <h3 class="text-center text-primary">Add Tour</h1>
                    <div class="card">
                        <c:if test="${not empty successMsg}">
                            <p class="text-center text-success">${successMsg}</p>
                            <c:remove scope="session" var="successMsg"/>
                                
                        </c:if>
                            <c:if test="${not empty failedMsg}">
                            <p class="text-center text-danger">${failedMsg}</p>
                            <c:remove scope="session" var="failedMsg"/>
                                
                        </c:if>
                        <div class="card-body">
                            
                            <form action="../add_tour" method="post" enctype='multipart/form-data'>
                                <div class="form-group">
                                    <label for="exampleFormControlInput1">Tour name</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Tour Name" name="name">
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlInput1">Tour author</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Tour Author" name="author">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Price</label>
                                    <input type="number" class="form-control" id="exampleInputEmail1" name="price" aria-describedby="emailHelp" placeholder="Enter price">
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlSelect1">Tour Category</label>
                                    <select class="form-control" id="exampleFormControlSelect1" name="category">
                                        <option>New</option>
                                        <option>Old</option>
                                        <option>Recent</option>

                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlSelect1">Tour Status</label>
                                    <select class="form-control" id="exampleFormControlSelect1" name="status">
                                        <option>Active</option>
                                        <option>Unactive</option>

                                    </select>
                                </div>
                                <form>
                                    <div class="form-group">
                                        <label for="exampleFormControlFile1">Choose file image</label>
                                        <input name="bimg" type="file" class="form-control-file" id="exampleFormControlFile1">
                                    </div>

                                    <button class="btn btn-primary" type="submit">Add</button>
                                </form>
                               
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
