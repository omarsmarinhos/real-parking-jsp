<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layout/header.jsp"/>
<h3 class="my-4">Listado de usuarios</h3>
<c:set var="menu" value="${sessionScope.menus['Usuarios']}"/>
<div class="row mb-2">
    <label class="col-form-label col-sm-2" for="username">DNI</label>
    <div class="col-sm-4">
        <input class="form-control" type="text" name="username" id="username" value=""/>
    </div>
    <div class="col-sm-2">
        <button class="btn btn-secondary" onclick="updateTable(1)">Filtrar</button>
        <a id="pdf" href="#"><img width="30" src="images/pdf_icon.svg"></a>
        <a id="excel" href="#"><img width="30" src="images/excel_icon.svg"></a>
    </div>
    <c:if test="${not empty menu and menu.nivelPermiso >= 3}">
        <div class="col-sm-2">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/usuarios/guardar">
                Agregar Usuario
            </a>
        </div>
    </c:if>
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
        <th>Foto</th>
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

<script>
    let paginaActual
    let numDePaginas
    let nivelPermiso = ${menu.nivelPermiso};
    updateTable(1);
    ocultarFiltros()

    function updateTable(page) {
        document.getElementById("table").innerHTML = "";

        let dni = document.getElementById("username").value;
        let nombreCompleto = document.getElementById("nombre_completo").value;
        let rol = document.getElementById("id_rol").value;
        let estado = document.getElementById("estado_usuario").value;

        let url = "${pageContext.request.contextPath}/usuarios/listar?page=" + page;
        let urlFoto = "http://localhost:8080/fotos/";

        let filtros = dni ? "&username=" + dni : "";
        filtros += nombreCompleto ? "&nombre_completo=" + nombreCompleto : "";
        filtros += rol ? "&id_rol=" + rol : "";
        filtros += estado ? "&estado_usuario=" + estado : "";

        url += filtros;

        const linkPdf = document.getElementById('pdf')
        const linkExcel = document.getElementById('excel')
        linkPdf.href = "${pageContext.request.contextPath}/reportes?reporte=pdf&page=" + page;
        linkPdf.href += filtros
        linkExcel.href = "${pageContext.request.contextPath}/reportes?reporte=excel&page=" + page;
        linkExcel.href += filtros


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
                            "<td>" + user.idUser + "</td>";
                        if (user.url == null || user.url === "") {
                            fila += "<td> " + "<img width='30' src='" + urlFoto + "/user.png'/>" + "</td>";
                        } else {
                            fila += "<td> " + "<img width='30' src='" + urlFoto + user.idUser + "/" + user.url + "'/>" + "</td>";
                        }
                        fila += "<td>" + user.username + "</td>" +
                            "<td>" + user.fullName + "</td>" +
                            "<td>" + user.role.description + "</td>" +
                            "<td>" + user.state + "</td>";

                        if (nivelPermiso >= 2) {
                            fila += "<td>" +
                                "<a class='btn btn-sm btn-success' " +
                                "href='${pageContext.request.contextPath}/usuarios/guardar?id=" + user.idUser + "' >" +
                                "Editar" +
                                "</a>" +
                                "</td>";
                        }
                        if (nivelPermiso >= 3) {
                            fila += "<td>" +
                                "<a class='btn btn-sm btn-" + (user.state === "Activo" ? "danger" : "outline-danger") + "' " +
                                "href='${pageContext.request.contextPath}/usuarios/deshabilitar?id=" + user.idUser + "' >" +
                                (user.state === "Activo" ? "Deshabilitar" : "Habilitar&nbsp;&nbsp;&nbsp;&nbsp;") +
                                "</a>" +
                                "</td>";
                        }

                        fila += "</tr>";

                        let tr = document.createElement("TR");
                        tr.innerHTML = fila;
                        document.getElementById("table").appendChild(tr);
                    });
                }, error: function () {
                    alert("error usuarios")
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
            url: "${pageContext.request.contextPath}/roles/listar",
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                $.each(data, function (index, rol) {
                    let fila = "<option value='" + rol.idRol + "'>" + rol.description + "</option>"
                    let option = document.createElement("option");
                    option.innerHTML = fila;
                    document.getElementById("id_rol").appendChild(option);
                });
            }, error: function () {
                alert("error roles")
            }
        });
    });

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
