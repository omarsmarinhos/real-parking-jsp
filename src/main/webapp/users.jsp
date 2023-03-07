<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layout/header.jsp"/>
<h3 class="my-4">Listado de usuarios</h3>

<div class="row mb-2">
    <label class="col-form-label col-sm-2" for="username">DNI</label>
    <div class="col-sm-4">
        <input class="form-control" type="text" name="username" id="username" value=""/>
    </div>
    <div class="col-sm-2">
        <button class="btn btn-secondary" onclick="updateTable(1)">Filtrar</button>
    </div>
    <div class="col-sm-2">
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#userGuardar">
            Agregar Usuario
        </button>
    </div>
</div>
<a class="link-primary" style="cursor: pointer;" id="mas-filtros" onclick="mostrarFiltros()">Mostrar más filtros</a>
<div id="filtros">
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="nombre_completo">Nombre</label>
        <div class="col-sm-4">
            <input class="form-control" type="text" name="nombre_completo" id="nombre_completo" value=""/>
        </div>
    </div>
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="id_rol">Cargo</label>
        <div class="col-sm-4">
            <select class="form-select" name="id_rol" id="id_rol">
                <option value="">--- Seleccionar ---</option>

            </select>
        </div>
    </div>
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="estado_usuario">Estado</label>
        <div class="col-sm-4">
            <select class="form-select" name="estado_usuario" id="estado_usuario">
                <option value="">--- Seleccionar ---</option>
                <option value="Activo">Activo</option>
                <option value="Inactivo">Inactivo</option>
            </select>
        </div>
    </div>
    <a class="link-primary" style="cursor: pointer;" onclick="ocultarFiltros()">Ocultar filtros</a>
</div>


<table class="table table-hover table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>DNI</th>
        <th>Nombre</th>
        <th>Cargo</th>
        <th>Estado</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody id="table">

    </tbody>
</table>

<ul class="pagination justify-content-end">

</ul>


<div class="modal fade" id="userGuardar" tabindex="-1" aria-labelledby="example" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="example">Guardar Usuario</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/usuarios/agregar" method="post">
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
                                <option id="cargos" value="0">--- Seleccionar ---</option>

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
                    <input type="submit" value="Guardar" class="btn btn-primary"/>
                </div>
                <input type="hidden" name="idUser" id="idUser" value="0">
            </form>
        </div>
    </div>
</div>

<script>
    let paginaActual
    let numDePaginas
    updateTable(1);
    ocultarFiltros()

    function updateTable(page) {
        document.getElementById("table").innerHTML = "";

        let dni = document.getElementById("username").value;
        let nombreCompleto = document.getElementById("nombre_completo").value;
        let rol = document.getElementById("id_rol").value;
        let estado = document.getElementById("estado_usuario").value;

        let url = "${pageContext.request.contextPath}/usuarios?page=" + page;

        url += dni ? "&username=" + dni : "";
        url += nombreCompleto ? "&nombre_completo=" + nombreCompleto : "";
        url += rol ? "&id_rol=" + rol : "";
        url += estado ? "&estado_usuario=" + estado : "";


        $(document).ready(function () {
            $.ajax({
                url: url,
                type: 'GET',
                dataType: 'json',
                success: function (data) {
                    paginaActual = data.paginaActual;
                    numDePaginas = data.numeroDePaginas;
                    updatePagination()

                    $.each(data.users, function (index, user) {
                        let fila =
                            "<tr>" +
                            "<td>" + user.idUser + "</td>" +
                            "<td>" + user.username + "</td>" +
                            "<td>" + user.fullName + "</td>" +
                            "<td>" + user.role.description + "</td>" +
                            "<td>" + user.state + "</td>" +
                            "<td>" +
                            "<button onclick=userUpdate(" + user.idUser + ") " +
                            "type='button' class='btn btn-sm btn-success' " +
                            "data-bs-toggle='modal' data-bs-target='#userGuardar'>Editar" +
                            "</button>" +
                            "</td>" +
                            "<td>" +
                            "<a class='btn btn-sm btn-" + (user.state === "Activo" ? "danger" : "outline-danger") + "' " +
                            "href='${pageContext.request.contextPath}/usuarios/deshabilitar?id=" + user.idUser + "' >" +
                            (user.state === "Activo" ? "Deshabilitar" : "Habilitar&nbsp;&nbsp;&nbsp;&nbsp;") +
                            "</a>" +
                            "</td>" +
                            "</tr>";

                        let tr = document.createElement("TR");
                        tr.innerHTML = fila;
                        document.getElementById("table").appendChild(tr);
                    });
                }, error: function () {
                    alert("error")
                }
            });
        });

    }

    function updatePagination() {
        console.log(paginaActual + " " + numDePaginas)
        document.querySelector(".pagination").innerHTML = ""
        $(document).ready(function () {
            let lip = document.createElement("li");
            lip.classList.add("page-item");
            if (paginaActual === 1) {
                lip.classList.add("disabled");
            }
            lip.innerHTML =
                "<button class='page-link' onclick='updateTable(" + (paginaActual - 1) + ")'>" +
                "Previus</button>";
            document.querySelector(".pagination").appendChild(lip);

            let li1 = document.createElement("li")
            li1.classList.add("page-item")
            li1.classList.add("active")
            li1.innerHTML =
                "<button class='page-link' onclick='updateTable(" + paginaActual + ")'>" +
                paginaActual + "</button>";
            document.querySelector(".pagination").appendChild(li1);

            let lin = document.createElement("li");
            lin.classList.add("page-item")
            if (paginaActual === numDePaginas) {
                lin.classList.add("disabled")
            }
            lin.innerHTML =
                "<button class='page-link' onclick='updateTable(" + (paginaActual + 1) + ")'>" +
                "Next</button>" +
                "</li>";
            document.querySelector(".pagination").appendChild(lin)


        })
    }

    $(document).ready(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/roles",
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                $.each(data, function (index, rol) {
                    let fila = "<option value='" + rol.idRol + "'>" + rol.description + "</option>"
                    let otherFila = "<option value='" + rol.description + "'>" + rol.description + "</option>"
                    let option = document.createElement("option");
                    let otherOption = document.createElement("option")
                    option.innerHTML = fila;
                    otherOption.innerHTML = otherFila;
                    document.getElementById("cargo").appendChild(option);
                    document.getElementById("id_rol").appendChild(otherOption);
                });
            }, error: function () {
                alert("error")
            }
        });
    });

    function userUpdate(id) {
        $(document).ready(function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/usuarios/get?id=" + id,
                type: 'GET',
                dataType: 'json',
                success: function (data) {
                    console.log(data)
                    document.getElementById('idUser').value = id
                    document.getElementById('dni').value = data.username
                    document.getElementById('nombre').value = data.fullName
                    document.getElementById('password').value = data.password

                    const estadoSelect = document.getElementById('estado')
                    const estadoOptions = estadoSelect.options
                    let estadoIndex = Array.prototype.findIndex.call(estadoOptions, function (option) {
                        return option.text === data.state;
                    });
                    estadoOptions[estadoIndex].selected = true

                    const cargoSelect = document.getElementById('cargo')
                    const cargoOptions = cargoSelect.options
                    let cargoIndex = Array.prototype.findIndex.call(cargoOptions, function (option) {
                        return option.text === data.role.description;
                    });
                    cargoOptions[cargoIndex].selected = true
                }, error: function () {
                    alert("error")
                }
            });
        })
    }

    function mostrarFiltros() {
        $("#mas-filtros").hide()
        $("#filtros").show()
    }

    function ocultarFiltros() {
        $("#mas-filtros").show()
        $("#filtros").hide()
    }
</script>

<jsp:include page="layout/footer.jsp"/>
