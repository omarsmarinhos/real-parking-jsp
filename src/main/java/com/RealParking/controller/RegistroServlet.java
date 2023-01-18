package com.RealParking.controller;

import com.RealParking.persitence.service.TicketService;
import com.RealParking.persitence.service.TicketServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TicketService ticketService = new TicketServiceImpl();
        req.setAttribute("tickets", ticketService.findAllTickets());
        req.setAttribute("title", "Registro");
        getServletContext().getRequestDispatcher("/registro.jsp").forward(req, resp);
    }
}
