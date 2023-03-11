package com.RealParking.controller;

import com.RealParking.configs.UserServicePrinc;
import com.RealParking.persitence.entity.User;
import com.RealParking.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/usuarios/get")
public class UserGetServlet extends HttpServlet {

    @Inject
    @UserServicePrinc
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            Integer idUser = Integer.valueOf(req.getParameter("id"));
            Optional<User> usuario = userService.porId(idUser);
            ObjectMapper mapper = new ObjectMapper();
            if (usuario.isPresent()) {
                String json = mapper.writeValueAsString(usuario.get());
                resp.setContentType("application/json");
                resp.getWriter().write(json);
            }
        }
        ;
    }
}
