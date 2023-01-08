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
            <a class="btn btn-primary" href="">Crear Rol</a>
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
    <c:forEach items="${requestScope.roles}" var="r">
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
</div>
</body>
</html>
<jsp:include page="layout/footer.jsp"/>