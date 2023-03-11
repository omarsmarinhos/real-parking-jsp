package com.RealParking.controller;

import com.RealParking.configs.UserServicePrinc;
import com.RealParking.persitence.entity.User;
import com.RealParking.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/usuarios/listar")
public class UserListServlet extends HttpServlet {

    @Inject
    @UserServicePrinc
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username") == null ? "" : req.getParameter("username");
        String fullName = req.getParameter("nombre_completo") == null ? "" : req.getParameter("nombre_completo");
        String rol = req.getParameter("id_rol") == null ? "" : req.getParameter("id_rol");
        String estado = req.getParameter("estado_usuario") == null ? "" : req.getParameter("estado_usuario");

        //Logger logger = Logger.getLogger(UserServlet.class.getName());
        int page = 1;
        int regPorPage = 8;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        long numDeRegistros = userService.getTotal(username, fullName, rol, estado);
        int numDePages = (int) Math.ceil(numDeRegistros * 1.0 / regPorPage);
        List<User> usuarios = userService
                .listar((page - 1) * regPorPage, regPorPage, username, fullName, rol, estado);
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

}
