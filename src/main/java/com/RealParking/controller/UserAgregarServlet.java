package com.RealParking.controller;

import com.RealParking.persitence.entity.Role;
import com.RealParking.persitence.entity.User;
import com.RealParking.persitence.service.UserService;
import com.RealParking.persitence.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/users/agregar")
public class UserAgregarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dni = req.getParameter("dni");
        String nombre = req.getParameter("nombre");
        int idRol = Integer.parseInt(req.getParameter("cargo"));
        String estado = req.getParameter("estado");
        String password = req.getParameter("password");

        if (dni.isBlank() || nombre.isBlank() || idRol == 0 || estado.isBlank() || password.isBlank()) {
            resp.sendRedirect(req.getContextPath() + "/users");
        } else {
            User user = new User();
            Role role = new Role();
            user.setUsername(dni);
            user.setFullName(nombre);
            role.setIdRol(idRol);
            user.setRole(role);
            user.setState(estado);
            user.setPassword(password);
            UserService userService = new UserServiceImpl();
            userService.insertUser(user);
            resp.sendRedirect(req.getContextPath() + "/users");
        }
    }
}
