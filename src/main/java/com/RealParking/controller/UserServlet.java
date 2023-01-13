package com.RealParking.controller;

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
        UserService service = new UserServiceImpl();
        req.setAttribute("users", service.findAllUsers());
        req.setAttribute("title", "Listado de Usuarios");
        getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        String dni = req.getParameter("filtro_dni");
        req.setAttribute("users", service.findAllUsers());
        req.setAttribute("title", "Listado de Usuarios");
        getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);
    }
}
