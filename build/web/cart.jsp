<%@page import="java.util.*" %>
<%@page import="dal.*" %>
<%@page import="model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart page </title>
        <%@include file="all_component/allCss.jsp"%>
    </head>
    <body>
        <%@include file="all_component/navbar.jsp"%>
        <c:if test="${empty userobj}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>

        <c:if test="${not empty succMsg}">
            <div class="alert alert-success" role="alert">
                ${succMsg}
            </div>
            <c:remove scope="session" var="succMsg"></c:remove>
        </c:if>
        <c:if test="${not empty failMsg}">
            <div class="alert alert-danger" role="alert">
                ${failMsg}
            </div>
            <c:remove scope="session" var="failMsg"></c:remove>
        </c:if>
        <div class="container">
            <div class="row">
                <div class="col-md-6  mt-3">
                    <h3 class="text-center text-success">You selected item </h3>
                    <div class="card">
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Tour Name</th>
                                        <th scope="col">Author</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        CartDAO cardDao = new CartDAO();
                                        User u = (User) session.getAttribute("userobj");
                                        List<Cart> list = cardDao.getTourByUser(u.getId());
                                        if(list != null && !list.isEmpty()){
                                        int i = 1;
                                        double total = 0;
                                        for(Cart c : list){         
                                    %>
                                    <tr>

                                        <th scope="row"><%=i%></th>
                                        <td><%=c.getTourname()%></td>
                                        <td><%=c.getAuthor()%></td>
                                        <td><%=c.getPrice()%></td>
                                        <td>
                                            <a href="remove_tour?cid=<%=c.getCid()%>" class="btn btn-danger">Remove</a>
                                        </td>
                                    </tr>
                                    <%
                                        total += c.getPrice();
                                        i++;
                                        }
                                        
                                    %>
                                    <tr>
                                        <th scope="row">Total Price</th>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td><%=total%></td>
                                    </tr>
                                    <% 
                                    }
                                    %>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 mt-3">
                    <h3 class="text-center text-success">You detailed for order </h3>
                    <div class="card">
                        <div class="card-body">
                            <form>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputEmail4">Name</label>
                                        <input type="text" class="form-control" id="inputEmail4" value="">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputPassword4">Email</label>
                                        <input type="text" class="form-control" id="inputPassword4">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputEmail4">Phone Number</label>
                                        <input type="text" class="form-control" id="inputEmail4" value="">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputPassword4">Address</label>
                                        <input type="text" class="form-control" id="inputPassword4">
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputEmail4">Landmark</label>
                                        <input type="text" class="form-control" id="inputEmail4" value="">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputPassword4">City</label>
                                        <input type="text" class="form-control" id="inputPassword4">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputEmail4">State</label>
                                        <input type="text" class="form-control" id="inputEmail4" value="">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputPassword4">Pin code</label>
                                        <input type="text" class="form-control" id="inputPassword4">
                                    </div>
                                </div>
                                <div class="form-group col-md-6 p-1">
                                    <label for="inputState">Payment Mode</label>
                                    <select id="inputState" class="form-control">
                                        <option selected>Online Banking</option>
                                        <option selected>Paypal</option>
                                    </select>
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary">Order Now</button>
                                    <button class="btn btn-secondary"><a style="text-decoration: none;color: white" href="index.jsp">
                                            Continue Shopping</a>
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
