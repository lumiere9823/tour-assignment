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
                <div class="col-md-4 offset-md-1">
                    <div class="card">
                        <div class="card-body ">
                            <form action="login" method="post">
                                <h4 class="text-center">Login</h4>
                                <c:if test="${not empty succMsg}">
                                    <p class="text-center text-success">${succMsg}
                                    </p>
                                    <c:remove var="succMsg" scope="session"></c:remove>
                                </c:if>
                                <c:if test="${not empty failedMsg}">
                                    <p class="text-center text-danger">${failedMsg}
                                    </p>
                                    <c:remove var="failedMsg" scope="session"></c:remove>
                                </c:if>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email </label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp" placeholder="Email">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input type="password" class="form-control" id="exampleInputPassword1" name="pass" placeholder="Password">
                                </div>
                                <div class="form-check">
                                    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="check">
                                    <label class="form-check-label" for="exampleCheck1" >Remember me</label>
                                </div>
                                <button type="submit" class="btn btn-primary">Login</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div style="margin-top: 170px;">
            <%@include file="all_component/footer.jsp" %>
        </div>
    </body>
</html>
