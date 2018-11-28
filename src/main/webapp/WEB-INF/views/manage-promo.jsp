<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <jsp:include page="template-imports.jsp" />
    <title>Manage Users</title>
</head>

<body>

<jsp:include page="menu-template.jsp" />

<br><br><br><br><br>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title" id="exampleModalLabel">Add new promo</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    &times;
                </button>
            </div>
            <div class="modal-body">
                <form id="newPromoForm" action="/a/promos/new" method="post">
                    <div class="form-group">
                        <label>Promo Code</label>
                        <input type="text" name="code" class="form-control" placeholder="Code">
                    </div>
                    <div class="form-group">
                        <label>Expiration data</label>
                        <input type="date" name="expirationDate" class="form-control" placeholder="Expiration date">
                        <br>
                        <label>Discount Percent</label>
                        <input type="number" name="discountPercent" class="form-control" placeholder="Discount Percent">
                        <br>
                    </div>
                    <button type="submit" class="btn btn-primary btn-sm">Submit</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn-sm btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn-sm btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<div class="container">

    <form action="#">
        <div class="form-group">
            <div class="row">
                <div class="col-md-3">
                    <input type="text" id="myInput" class="form-control" placeholder="Search Promo"> <br>
                    <input type="submit" class="btn btn-primary btn-sm">

                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#exampleModal">
                        Add new Promo
                    </button>

                </div>
            </div>
        </div>
    </form>

    <br><br>
    <table class="table table-hover" id="myTable">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Code</th>
            <th scope="col">Expiration Date</th>
            <th scope="col">Discount Percent</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${promos}" var="promo" >
            <tr zid="${promo.id}">
                <th scope="row">${promo.id}</th>
                <td>${promo.code}</td>
                <td>${promo.expirationDate}</td>
                <td>${promo.discountPercent}</td>
                <td><a href="#" class="btn btn-danger btn-sm btn-delete-promo">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="<c:url value="/resources/js/promo.js" />" type="application/javascript">
</script>
</body>
</html>