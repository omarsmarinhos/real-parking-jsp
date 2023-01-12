package com.RealParking.controller;

import com.RealParking.persitence.entity.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/roles/agregar")
public class RoleAgregarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = req.getParameter("rol");
        String estado = req.getParameter("estado");

        Role rol = new Role();
        rol.setDescription(role);
        rol.setState(estado);

        HttpSession session = req.getSession();
        /*RoleServicePruebaImpl roles = (RoleServicePruebaImpl) session.getAttribute("roles");
        roles.insertRole(rol);

        getServletContext().getRequestDispatcher("/roles").forward(req, resp);*/

    }
}
