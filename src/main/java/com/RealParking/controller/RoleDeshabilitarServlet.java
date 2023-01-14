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

@WebServlet("/roles/deshabilitar")
public class RoleDeshabilitarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;
        Role rol = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
            rol = new Role();
            rol.setIdRol(id);
        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/roles");
        }

        RoleService roleService = new RoleServiceImpl();
        rol = roleService.findRoleById(rol);
        if (rol.getState().equals("Activo")) {
            rol.setState("Inactivo");
        } else {
            rol.setState("Activo");
        }
        roleService.updateRole(rol);
        resp.sendRedirect(req.getContextPath() + "/roles");
    }
}
