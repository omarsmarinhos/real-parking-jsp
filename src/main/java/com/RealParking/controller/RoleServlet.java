package com.RealParking.controller;

import com.RealParking.persitence.service.RoleService;
import com.RealParking.persitence.service.RoleServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/roles")
public class RoleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoleService service = new RoleServiceImpl();
        req.setAttribute("roles", service.findAllRoles());
        req.setAttribute("title", "Listado de Roles");
        getServletContext().getRequestDispatcher("/roles.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoleService service = new RoleServiceImpl();
        String role = req.getParameter("filtro_rol");
        req.setAttribute("roles", service.findRoleByRole(role));
        req.setAttribute("title", "Listado de Roles");
        getServletContext().getRequestDispatcher("/roles.jsp").forward(req, resp);
    }
}
