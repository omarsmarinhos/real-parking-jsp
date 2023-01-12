package com.RealParking.controller;

import com.RealParking.persitence.service.LoginService;
import com.RealParking.persitence.service.LoginServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* LoginService service = new LoginServiceImpl();
        Optional<String> usernameOptional = service.getUsername(req);
        if (usernameOptional.isPresent()) {
            req.setAttribute("title", "Bienvenido");
            //ELiminar en un futuro
            HttpSession session = req.getSession();
            session.setAttribute("roles", new RoleServicePruebaImpl());
            //.------..-.
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.setAttribute("title", "Login");
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        req.setAttribute("title", "Index");
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
