package com.RealParking.controller;

import com.RealParking.persitence.entity.User;
import com.RealParking.persitence.service.RoleService;
import com.RealParking.persitence.service.RoleServiceImpl;
import com.RealParking.persitence.service.UserService;
import com.RealParking.persitence.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/usuarios/get")
public class UserGetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        if (req.getParameter("id") != null) {
            Integer idUser = Integer.valueOf(req.getParameter("id"));
            User usuario = new User();
            usuario.setIdUser(idUser);
            usuario = userService.findUserById(usuario);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(usuario);
            resp.setContentType("application/json");
            resp.getWriter().write(json);
        };
    }
}
