package com.RealParking.controller;

import com.RealParking.persitence.entity.User;
import com.RealParking.persitence.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/login")
public class LoginServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService service = new LoginServiceImpl();
        Optional<String> usernameOptional = service.getUsername(req);
        if (usernameOptional.isPresent()) {
            HttpSession session = req.getSession();
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

        LoginService loginService = new LoginServiceImpl();
        try {
            Optional<User> userOptional = loginService.login(username, password);
            if (userOptional.isPresent()) {
                HttpSession session = req.getSession();
                session.setAttribute("username", userOptional.get());
                MenuService menuService = new MenuServiceImpl();
                session.setAttribute("menus", menuService.findAllMenus(userOptional.get().getRole().getDescription()));
                //getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                resp.sendRedirect(req.getContextPath() + "/users.jsp");
            } else {
                getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
