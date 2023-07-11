<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid" style="background-color:white ">
</div>
<div class="container-fluid p-3">
    <div class="row">
        <div class="col-md-3">
            <h3 class="text-success"><i class="fas fa-map-marker-alt"></i><a style="text-decoration: none" href="index.jsp">TOUR</a></h3>
        </div>
        <div class="col-md-6">
            <form style="margin-left: 100px;
                  "  class="form-inline my-2 my-lg-0" action="searchTour" method="post">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="ch">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><i class="fa-solid fa-magnifying-glass"></i>Search</button>
            </form>
        </div>
        <c:if test="${not empty userobj}">
            <div class="col-md-3">
                <a href="cart.jsp"> 
                    <button class="btn btn-danger">
                        <i class="fa-solid fa-cart-shopping"></i>Cart
                    </button>
                </a>
                <a href="" class="btn btn-success">
                    <i class="fa-solid fa-user"></i>${userobj.name}
                </a>
                <a href="logout" class="btn btn-primary text-white">
                    <i class="fas fa-sign-in-alt">Logout</i>
                </a>
            </div>

        </c:if>
        <c:if test="${ empty userobj}">
            <div class="col-md-3">

                <a href="login.jsp" class="btn btn-success"><i class="fa-solid fa-right-to-bracket"></i>Login</a><!-- comment -->
                <a href="register.jsp" class="btn btn-primary"><i class="fa-solid fa-registered"></i>Register</a><!-- comment -->
            </div>
        </c:if>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-light bg-primary">
    <a class="navbar-brand" href="#"><i class="fa-solid fa-house"></i>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse bg-primary" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto" style="display: flex;
  justify-content: space-between;">
            <li class="nav-item active" style="font-size: 20px; font-weight: 600">
                <a class="nav-link" href="index.jsp">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active" style="font-size: 20px; font-weight: 600">
                <a class="nav-link " href="all_recent_tours.jsp">Recent Tour</a>
            </li>
            <li class="nav-item active" style="font-size: 20px; font-weight: 600">
                <a class="nav-link" href="all_new_tours.jsp">New Tour</a>
            </li>
            <li class="nav-item active" style="font-size: 20px; font-weight: 600">
                <a class="nav-link disabled" href="all_old_tours.jsp">Old Tour</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <button class="btn btn-light my-2 my-sm-0" type="submit"> <a href="setting.jsp"><i class="fa-solid fa-gear"></i>Setting </a></button>
            <button class="btn btn-light my-2 my-sm-0 ml-1" type="submit"><i class="fa-solid fa-phone"></i>Contact Us</button>
        </form>
    </div>
</nav>