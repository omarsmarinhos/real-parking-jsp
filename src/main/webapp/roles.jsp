<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layout/header.jsp"/>
<h3>${requestScope.title}</h3>
<form action="" method="post">
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="rol">Ingresar rol</label>
        <div class="col-sm-4">
            <input class="form-control" type="text" name="rol" id="rol"/>
        </div>
        <div class="col-sm-2">
            <input class="btn btn-secondary" type="submit" value="Filtrar">
        </div>
        <div class="col-sm-2">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Agregar rol
            </button>
        </div>
    </div>
</form>

<table class="table table-hover table-striped">
    <tr>
        <th>Id</th>
        <th>Rol</th>
        <th>Estado</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${sessionScope.roles.items}" var="r">
    <tr>
        <td>${r.idRol}</td>
        <td>${r.description}</td>
        <td>${r.state}</td>
        <td><a class="btn btn-sm btn-success"
               href="">Editar</a></td>
        <td><a class="btn btn-sm btn-danger"
               href="">Deshabilitar</a></td>
    </tr>
    </c:forEach>
</table>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Agregar rol</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/roles/agregar" method="post">
                    <input type="text" name="rol">
                    <input type="text" name="estado">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <input type="submit" value="Agregar" class="btn btn-primary"/>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
<jsp:include page="layout/footer.jsp"/>