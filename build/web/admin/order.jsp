<%-- 
    Document   : order
    Created on : 25 thg 6, 2023, 14:54:36
    Author     : bravee06
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${empty userobj}">
            <c:redirect url="../login.jsp"></c:redirect>
        </c:if>
        <h1>Hello World!</h1>
    </body>
</html>
