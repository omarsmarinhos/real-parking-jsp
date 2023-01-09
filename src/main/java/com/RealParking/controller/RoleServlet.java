package com.RealParking.controller;

import com.RealParking.persitence.entity.Role;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/roles")
public class RoleServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Connection conn = (Connection) req.getAttribute("conn");
        //RoleService roleService = new RoleServiceTesImpl();
        //List<Role> roles = repository.listarRoles();

        //req.setAttribute("roles", roles);
        req.setAttribute("title", "Listado de Roles");
        getServletContext().getRequestDispatcher("/rolesListar.jsp").forward(req, resp);
    }
}
