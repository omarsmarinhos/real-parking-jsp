package com.RealParking.controller;

import com.RealParking.configs.UserServicePrinc;
import com.RealParking.domain.Permiso;
import com.RealParking.persitence.entity.User;
import com.RealParking.service.*;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Inject
    @UserServicePrinc
    private UserService userService;

    @Inject
    private LoginService loginService;

    @Inject
    private MenuService menuService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> usernameOptional = loginService.getUsername(req);
        if (usernameOptional.isPresent()) {
            req.setAttribute("title", "Bienvenido");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.setAttribute("title", "Login");
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            Optional<User> userOptional = userService.login(username, password);
            if (userOptional.isPresent()) {
                HttpSession session = req.getSession();
                session.setAttribute("username", userOptional.get());

                List<Permiso> menuYPermisos = menuService.listarMenus(userOptional.get().getRole().getDescription());
                List<String> menus = menuYPermisos.stream()
                        .map(Permiso::getMenu)
                        .distinct()
                        .collect(Collectors.toList());
                session.setAttribute("menus", menus);
                session.setAttribute("permisos", menuYPermisos);
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            } else {
                getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
