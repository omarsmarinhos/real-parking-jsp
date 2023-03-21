package com.RealParking.controller;

import com.RealParking.configs.RoleServicePrinc;
import com.RealParking.persitence.entity.Role;
import com.RealParking.service.RoleService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/roles/deshabilitar")
public class RoleDeshabilitarServlet extends HttpServlet {

    @Inject
    @RoleServicePrinc
    private RoleService service;

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

        //rol = roleService.findRoleById(rol);
        if (rol.getState().equals("Activo")) {
            rol.setState("Inactivo");
        } else {
            rol.setState("Activo");
        }
        //roleService.updateRole(rol);
        resp.sendRedirect(req.getContextPath() + "/roles");
    }
}
