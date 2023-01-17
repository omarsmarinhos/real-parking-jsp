package com.RealParking.controller;

import com.RealParking.persitence.entity.Role;
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

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        RoleService roleService = new RoleServiceImpl();
        req.setAttribute("users", userService.findAllUsers());
        req.setAttribute("roles", roleService.findAllRoles());
        req.setAttribute("title", "Listado de Usuarios");
        getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        RoleService roleService = new RoleServiceImpl();
        String dni = req.getParameter("filtro_dni");
        req.setAttribute("users", userService.findAllUserByUser(dni));
        req.setAttribute("roles", roleService.findAllRoles());
        req.setAttribute("title", "Listado de Usuarios");
        getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);
    }
}
