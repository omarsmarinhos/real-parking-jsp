<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layout/header.jsp"/>
<h3>${requestScope.title}</h3>

<form action="${pageContext.request.contextPath}/users" method="post">
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="filtro_dni">Ingresar DNI</label>
        <div class="col-sm-4">
            <input class="form-control" type="text" name="filtro_dni" id="filtro_dni"/>
        </div>
        <div class="col-sm-2">
            <input class="btn btn-secondary" type="submit" value="Filtrar">
        </div>
        <div class="col-sm-2">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Agregar Usuario
            </button>
        </div>
    </div>
</form>

<table class="table table-hover table-striped">
    <tr>
        <th>Id</th>
        <th>DNI</th>
        <th>Nombre</th>
        <th>Cargo</th>
        <th>Estado</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${requestScope.users}" var="u">
    <tr>
        <td>${u.idUser}</td>
        <td>${u.username}</td>
        <td>${u.fullName}</td>
        <td>${u.role.description}</td>
        <td>${u.state}</td>
        <td><a class="btn btn-sm btn-success"
               href="">Editar</a></td>
        <td><a class="btn btn-sm btn-danger"
               href="">Deshabilitar</a></td>
    </tr>
    </c:forEach>
</table>
<jsp:include page="layout/footer.jsp"/>
