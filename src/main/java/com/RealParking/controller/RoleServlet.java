package com.RealParking.controller;

import com.RealParking.persitence.service.RoleService;
import com.RealParking.persitence.service.RoleServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(service.findAllRoles());
        resp.setContentType("application/json");
        resp.getWriter().write(json);
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
