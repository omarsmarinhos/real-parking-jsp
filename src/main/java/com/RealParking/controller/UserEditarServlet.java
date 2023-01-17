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

@WebServlet("/users/editar")
public class UserEditarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idUser"));
        String dni = req.getParameter("dnie");
        String nombre = req.getParameter("nombree");
        int idRol = Integer.parseInt(req.getParameter("cargoe"));
        String estado = req.getParameter("estadoe");
        String password = req.getParameter("passworde");

        if (dni.isBlank() || nombre.isBlank() || idRol == 0 || estado.isBlank() || password.isBlank()) {
            resp.sendRedirect(req.getContextPath() + "/users");
        } else {
            User user = new User();
            Role role = new Role();
            user.setIdUser(id);
            user.setUsername(dni);
            user.setFullName(nombre);
            role.setIdRol(idRol);
            user.setRole(role);
            user.setState(estado);
            user.setPassword(password);
            UserService userService = new UserServiceImpl();
            userService.updateUser(user);
            resp.sendRedirect(req.getContextPath() + "/users");
        }
    }
}
