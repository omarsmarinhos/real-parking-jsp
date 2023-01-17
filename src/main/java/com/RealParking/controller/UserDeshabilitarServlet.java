package com.RealParking.controller;

import com.RealParking.persitence.entity.Role;
import com.RealParking.persitence.entity.User;
import com.RealParking.persitence.service.RoleService;
import com.RealParking.persitence.service.RoleServiceImpl;
import com.RealParking.persitence.service.UserService;
import com.RealParking.persitence.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/users/deshabilitar")
public class UserDeshabilitarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;
        User user = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
            user = new User();
            user.setIdUser(id);
        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/users");
        }

        UserService userService = new UserServiceImpl();
        user = userService.findUserById(user);
        if (user.getState().equals("Activo")) {
            user.setState("Inactivo");
        } else {
            user.setState("Activo");
        }
        userService.updateUser(user);
        resp.sendRedirect(req.getContextPath() + "/users");
    }
}
