package com.RealParking.controller;

import com.RealParking.persitence.entity.Role;
import com.RealParking.persitence.service.RoleService;
import com.RealParking.persitence.service.RoleServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/roles/agregar")
public class RoleAgregarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = req.getParameter("rol");
        String estado = req.getParameter("estado");

        if (role.isBlank() || estado.isBlank()) {
            resp.sendRedirect(req.getContextPath() + "/roles");
        } else {
            Role rol = new Role();
            rol.setDescription(role);
            rol.setState(estado);

            RoleService service = new RoleServiceImpl();
            service.insertRole(rol);
            resp.sendRedirect(req.getContextPath() + "/roles");
        }
    }
}
