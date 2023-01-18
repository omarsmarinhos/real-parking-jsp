<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layout/header.jsp"/>
<h3 class="my-4">${requestScope.title}</h3>

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
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#userAgregar">
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
            <td>
                <button onclick="userUpdate('${u.idUser}', '${u.username}', '${u.fullName}',
                        '${u.role.description}',  '${u.state}', '${u.password}')"
                        type="button" class="btn btn-sm btn-success"
                        data-bs-toggle="modal" data-bs-target="#userEditar">Editar
                </button>
            </td>
            <td><a class="btn btn-sm btn-${u.state.equals("Activo") ? "danger" : "outline-danger"}"
                   href="${pageContext.request.contextPath}/users/deshabilitar?id=${u.idUser}">
                    ${u.state.equals("Activo") ? "Deshabilitar" : "Habilitar&nbsp;&nbsp;&nbsp;&nbsp;"}
            </a></td>
        </tr>
    </c:forEach>
</table>

<div class="modal fade" id="userAgregar" tabindex="-1" aria-labelledby="example" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="example">Agregar Usuario</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/users/agregar" method="post">
                <div class="modal-body">
                    <div class="row mb-2">
                        <label class="col-form-label col-sm-2" for="dni">DNI</label>
                        <div class="col-sm-8">
                            <input class="form-control" type="number" name="dni" id="dni" value="">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label class="col-form-label col-sm-2" for="nombre">Nombre completo</label>
                        <div class="col-sm-8">
                            <input class="form-control" type="text" name="nombre" id="nombre" value="">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label class="col-form-label col-sm-2" for="cargo">Cargo</label>
                        <div class="col-sm-8">
                            <select class="form-select" name="cargo" id="cargo">
                                <option value="0">--- Seleccionar ---</option>
                                <c:forEach items="${requestScope.roles}" var="r">
                                    <option value="${r.idRol}">${r.description}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label class="col-form-label col-sm-2" for="estado">Estado</label>
                        <div class="col-sm-8">
                            <select class="form-select" name="estado" id="estado">
                                <option value="">--- Seleccionar ---</option>
                                <option value="Activo">Activo</option>
                                <option value="Inactivo">Inactivo</option>
                            </select>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label class="col-form-label col-sm-2" for="password">Password</label>
                        <div class="col-sm-8">
                            <input class="form-control" type="password" name="password" id="password" value="">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input type="submit" value="Agregar" class="btn btn-primary"/>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="userEditar" tabindex="-1" aria-labelledby="examplee" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="examplee">Editar Usuario</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/users/editar" method="post">
                <div class="modal-body">
                    <div class="row mb-2">
                        <label class="col-form-label col-sm-2" for="dnie">DNI</label>
                        <div class="col-sm-8">
                            <input class="form-control" type="number" name="dnie" id="dnie" value="">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label class="col-form-label col-sm-2" for="nombree">Nombre completo</label>
                        <div class="col-sm-8">
                            <input class="form-control" type="text" name="nombree" id="nombree" value="">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label class="col-form-label col-sm-2" for="cargoe">Cargo</label>
                        <div class="col-sm-8">
                            <select class="form-select" name="cargoe" id="cargoe">
                                <option value="0">--- Seleccionar ---</option>
                                <c:forEach items="${requestScope.roles}" var="r">
                                    <option value="${r.idRol}">${r.description}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label class="col-form-label col-sm-2" for="estadoe">Estado</label>
                        <div class="col-sm-8">
                            <select class="form-select" name="estadoe" id="estadoe">
                                <option value="">--- Seleccionar ---</option>
                                <option value="Activo">Activo</option>
                                <option value="Inactivo">Inactivo</option>
                            </select>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label class="col-form-label col-sm-2" for="passworde">Password</label>
                        <div class="col-sm-8">
                            <input class="form-control" type="password" name="passworde" id="passworde" value="">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input type="submit" value="Editar" class="btn btn-primary"/>
                </div>
                <input type="hidden" value="" name="idUser" id="idUser" >
            </form>
        </div>
    </div>
</div>

<script>
    function userUpdate(id, dni, nombre, cargo, estado, password) {
        document.getElementById('idUser').value = id
        document.getElementById('dnie').value = dni
        document.getElementById('nombree').value = nombre
        document.getElementById('passworde').value = password

        const estadoSelect = document.getElementById('estadoe')
        const estadoOptions = estadoSelect.options
        let estadoIndex = Array.prototype.findIndex.call(estadoOptions, function(option) {
            return option.text === estado;
        });
        estadoOptions[estadoIndex].selected = true

        const cargoSelect = document.getElementById('cargoe')
        const cargoOptions = cargoSelect.options
        let cargoIndex = Array.prototype.findIndex.call(cargoOptions, function(option) {
            return option.text === cargo;
        });
        cargoOptions[cargoIndex].selected = true
    }

</script>

<jsp:include page="layout/footer.jsp"/>
