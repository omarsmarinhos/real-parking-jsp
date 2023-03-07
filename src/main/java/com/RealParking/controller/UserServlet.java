package com.RealParking.controller;

import com.RealParking.persitence.entity.User;
import com.RealParking.persitence.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/usuarios")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();

        String username = req.getParameter("username") == null ? "" : req.getParameter("username");
        String fullName = req.getParameter("nombre_completo") == null ? "" : req.getParameter("nombre_completo");
        String rol = req.getParameter("id_rol") == null ? "" : req.getParameter("id_rol");
        String estado = req.getParameter("estado_usuario") == null ? "" : req.getParameter("estado_usuario");

        //Logger logger = Logger.getLogger(UserServlet.class.getName());
        int page = 1;
        int regPorPage = 4;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        long numDeRegistros = userService.getNumDeRegistros(username, fullName, rol, estado);
        int numDePages = (int) Math.ceil(numDeRegistros * 1.0 / regPorPage);
        List<User> usuarios = userService
                .findAllUsers((page - 1) * regPorPage, regPorPage, username, fullName, rol, estado);
        req.setAttribute("numDePages", numDePages);
        req.setAttribute("paginaActual", page);

        ObjectMapper mapper = new ObjectMapper();
        int finalPage = page;
        String json = mapper.writeValueAsString(new Object() {
            public final List<User> users = usuarios;
            public final int paginaActual = finalPage;
            public final int numeroDePaginas = numDePages;
        });
        resp.setContentType("application/json");
        resp.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        RoleService roleService = new RoleServiceImpl();
        String dni = req.getParameter("filtro_dni");
        req.setAttribute("users", userService.findAllUserByUser(dni));
        req.setAttribute("roles", roleService.findAllRoles());
        req.setAttribute("title", "Listado de Usuarios");
        getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);
    }
}
