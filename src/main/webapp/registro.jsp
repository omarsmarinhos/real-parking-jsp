<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layout/header.jsp"/>
<h3 class="my-4">${requestScope.title}</h3>
<h5>Espacios libres: ${""}</h5>
<form action="" method="post">
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="placa">Placa</label>
        <div class="col-sm-4">
            <input class="form-control" type="text" name="placa" id="placa"/>
        </div>
        <div class="col-sm-4">
            <input class="btn btn-primary" type="submit" value="Ingresar">
        </div>
    </div>
</form>
<form action="" method="post">
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="buscar">Buscar</label>
        <div class="col-sm-4">
            <input class="form-control" type="text" name="buscar" id="buscar"/>
        </div>
        <div class="col-sm-4">
            <input class="btn btn-secondary" type="submit" value="Buscar">
        </div>
    </div>
</form>
<table class="table table-hover table-striped">
    <tr>
        <th>Id</th>
        <th>Placa</th>
        <th>Hora de ingreso</th>
        <th>Estado</th>
        <th>Retirar</th>
        <th>Eliminar</th>
    </tr>
    <c:forEach items="${requestScope.tickets}" var="t">
        <tr>
            <td>${t.idTicket}</td>
            <td>${t.numberPlate}</td>
            <td>${t.hourEntry}</td>
            <td>${t.state}</td>
            <td><a class="btn btn-sm btn-success"
                   href="">Retirar</a></td>
            <td><a class="btn btn-sm btn-danger"
                   href="">Eliminar</a></td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="layout/footer.jsp"/>