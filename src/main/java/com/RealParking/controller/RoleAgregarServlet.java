package com.RealParking.controller;

import com.RealParking.configs.RoleServicePrinc;
import com.RealParking.persitence.entity.Role;
import com.RealParking.service.RoleService;
import com.RealParking.service.RoleServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/roles/agregar")
public class RoleAgregarServlet extends HttpServlet {

    @Inject
    @RoleServicePrinc
    private RoleService service;

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

            //aun falta modificar
            service.guardar(rol);
            resp.sendRedirect(req.getContextPath() + "/roles");
        }
    }
}
