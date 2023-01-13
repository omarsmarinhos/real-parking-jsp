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

@WebServlet("/roles/editar")
public class RoleEditarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = req.getParameter("role");
        String estado = req.getParameter("estadoe");
        int id = Integer.parseInt(req.getParameter("idRol"));


        if (role.isBlank() || estado.isBlank()) {
            resp.sendRedirect(req.getContextPath() + "/roles");
        } else {
            Role rol = new Role();
            rol.setIdRol(id);
            rol.setDescription(role);
            rol.setState(estado);

            RoleService service = new RoleServiceImpl();
            service.updateRole(rol);
            resp.sendRedirect(req.getContextPath() + "/roles");
        }
    }
}
