<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid" style="background-color:#303f9f"></div>
<div class="container-fluid p-3">
    <div class="row">
        <div class="col-md-3">
            <h3 class="text-success"><i class="fas fa-map-marker-alt"></i><a style="text-decoration: none" href="../index.jsp">TOUR</a></h3>
        </div>
        <div class="col-md-6">
            <form style="margin-left: 100px;" class="form-inline my-2 my-lg-0" action="../searchTour" method="post">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="ch">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><i class="fa-solid fa-magnifying-glass"></i>Search</button>
            </form>
        </div>
        <c:if test="${not empty userobj}">
            <div class="col-md-3">
                <a href="" class="btn btn-success">
                    <i class="fa-solid fa-user"></i>${userobj.name}
                </a>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                    <i class="fa-solid fa-registered"></i> Logout
                </button>
                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel"> Logout</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Do you want logout ?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <a href="../logout">
                                    <button type="button" class="btn btn-primary"> Logout</button>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
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
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
    </div>
</nav>