package com.RealParking.controller;

import com.RealParking.persitence.entity.Role;
import com.RealParking.persitence.service.RoleServicePruebaImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/roles")
public class RoleServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Listado de Roles");
        getServletContext().getRequestDispatcher("/roles.jsp").forward(req, resp);
    }
}
