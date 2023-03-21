<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layout/header.jsp"/>
<h3>${requestScope.title}</h3>
<form action="${pageContext.request.contextPath}/usuarios/guardar" method="post" enctype='multipart/form-data'>
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="dni">DNI</label>
        <div class="col-sm-8">
            <input class="form-control" type="number" name="dni" id="dni" value="${requestScope.user.username}">
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('dni')}">
            <div style="color: red;">${requestScope.errores.dni}</div>
        </c:if>
    </div>
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="nombre">Nombre completo</label>
        <div class="col-sm-8">
            <input class="form-control" type="text" name="nombre" id="nombre" value="${requestScope.user.fullName}">
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('nombre')}">
            <div style="color: red;">${requestScope.errores.nombre}</div>
        </c:if>
    </div>
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="cargo">Cargo</label>
        <div class="col-sm-8">
            <select class="form-select" name="cargo" id="cargo">
                <option value="">--- Seleccionar ---</option>
                <c:forEach items="${requestScope.roles}" var="c">
                    <option value="${c.idRol}" ${c.idRol.equals(requestScope.user.role.idRol)? "selected": ""}>${c.description}</option>
                </c:forEach>
            </select>
        </div>
        <c:if test="${requestScope.errores != null && not empty requestScope.errores.cargo}">
            <div style="color: red;">${requestScope.errores.cargo}</div>
        </c:if>
    </div>
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="estado">Estado</label>
        <div class="col-sm-8">
            <select class="form-select" name="estado" id="estado">
                <option value="">--- Seleccionar ---</option>
                <option value="Activo" ${requestScope.user.state.equals("Activo") ? "selected": ""}>Activo</option>
                <option value="Inactivo" ${requestScope.user.state.equals("Inactivo") ? "selected": ""}>Inactivo
                </option>
            </select>
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('estado')}">
            <div style="color: red;">${requestScope.errores.estado}</div>
        </c:if>
    </div>
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="password">Password</label>
        <div class="col-sm-8">
            <input class="form-control" type="password" name="password" id="password"
                   value="${requestScope.user.password}">
        </div>
    </div>
    <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('password')}">
        <div style="color: red;">${requestScope.errores.password}</div>
    </c:if>
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="file">Foto</label>
        <div class="col-sm-8">
            <input class="form-control" type="file" name="file" id="file">
        </div>
    </div>
    <div class="row mb-2">
        <div>
            <input class="btn btn-primary" type="submit"
                   value="${requestScope.user.idUser != null && requestScope.user.idUser > 0 ? "Editar" : "Crear"}">
        </div>
    </div>
    <input class="form-control" type="hidden" name="file_name" id="file_name"
           value="${requestScope.user.url}">
    <input type="hidden" name="idUser" id="idUser" value="${requestScope.user.idUser}">
    </div>

</form>
<jsp:include page="layout/footer.jsp"/>

