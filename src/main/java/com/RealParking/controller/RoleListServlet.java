package com.RealParking.controller;

import com.RealParking.configs.RoleServicePrinc;
import com.RealParking.service.RoleService;
import com.RealParking.service.RoleServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/roles/listar")
public class RoleListServlet extends HttpServlet {

    @Inject
    @RoleServicePrinc
    private RoleService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(service.listar());
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

}
