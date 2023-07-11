<%@page import="model.*" %>
<%@page import="java.util.*" %>
<%@page import="dal.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Home</title>
        <%@include file="allCss.jsp"%>
    </head>
    <body>
        <c:if test="${empty userobj}">
            <c:redirect url="../login.jsp"></c:redirect>
        </c:if>
        <%
            User u = (User) request.getSession().getAttribute("userobj");
        %>
        <%@include file="navbar.jsp"%>
        <div style="margin-top:50px" class="text-success text-center">
            <h1> Chào Admin nhé, Đây là những gì mày có thể làm </h1>
        </div>
        <div class="container" style="top: 50%;position: absolute;left: 20%">
            <div class="row">
                <div class="col-md-3">
                    <div class="card">
                        <div style="padding-left: 5px; margin:5px 10px;text-align: center" class="card-body">
                            <a href="add_tour.jsp">
                                <button class="btn btn-primary">
                                    <i class="fa-solid fa-plus"></i> ADD tour Đi THÀNH 
                                </button>
                            </a>
                        </div>
                    </div>

                </div>
                <div class="col-md-3">
                    <div class="card">
                        <div style="padding-left: 5px; margin:5px 10px" class="card-body">
                            <a href="../all_tour">
                                <button class="btn btn-outline-success">
                                    <i class="fa-solid fa-list"></i>TẤT CẢ tour MÀ MÀY CÓ 
                                </button>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card">
                        <div style="padding-left: 5px; margin:5px 10px;text-align: center" class="card-body">
                            <a href="../index.jsp">
                                <button class="btn btn-success">
                                    <i class="fa-solid fa-cart-shopping"></i> ĐẶT HÀNG 
                                </button>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card">
                        <div style="padding-left: 5px; margin:5px 10px;text-align: center" class="card-body">
                            <a href="../logout">
                                <button class="btn btn-danger">
                                    <i class="fa-solid fa-right-from-bracket"></i> ĐĂNG XUẤT 
                                </button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
