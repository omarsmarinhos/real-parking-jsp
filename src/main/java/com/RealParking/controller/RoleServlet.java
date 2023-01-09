package com.RealParking.controller;

import com.RealParking.domain.service.RoleService;
import com.RealParking.domain.service.RoleServiceMemoryImpl;
import com.RealParking.domain.service.RoleServiceTestImpl;
import com.RealParking.persitence.entity.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/roles")
public class RoleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Connection conn = (Connection) req.getAttribute("conn");
        RoleService service = new RoleServiceMemoryImpl();
        List<Role> roles = service.findAllRoles();

        req.setAttribute("roles", roles);
        req.setAttribute("title", "Listado de Roles");
        getServletContext().getRequestDispatcher("/rolesListar.jsp").forward(req, resp);
    }
}
