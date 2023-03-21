package com.RealParking.controller;

import com.RealParking.configs.UserServicePrinc;
import com.RealParking.domain.Menu;
import com.RealParking.persitence.entity.User;
import com.RealParking.service.PermisosException;
import com.RealParking.service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@WebServlet("/usuarios/deshabilitar")
public class UserDeshabilitarServlet extends HttpServlet {

    @Inject
    @UserServicePrinc
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int nivelPermiso = ((Map<String, Menu>) req.getSession().getAttribute("menus"))
                .get("Usuarios").getNivelPermiso();

        if (nivelPermiso < 3) {
            throw new PermisosException("Permiso denegado");
        }

        Integer id;
        User user = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
            user = new User();
            user.setIdUser(id);
        } catch (NumberFormatException e) {
            id = null;
            resp.sendRedirect(req.getContextPath() + "/usuarios");
        }

        Optional<User> userOptional = userService.porId(id);
        if (userOptional.isPresent()) {
            user = userOptional.get();
            if (user.getState().equals("Activo")) {
                user.setState("Inactivo");
            } else {
                user.setState("Activo");
            }
        }
        userService.guardar(user);
        resp.sendRedirect(req.getContextPath() + "/usuarios");
    }
}
