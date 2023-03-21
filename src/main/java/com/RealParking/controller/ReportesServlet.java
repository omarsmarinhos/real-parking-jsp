package com.RealParking.controller;

import com.RealParking.configs.UserServicePrinc;
import com.RealParking.persitence.entity.User;
import com.RealParking.service.ReporteExcelServiceImpl;
import com.RealParking.service.ReportePdfServiceImpl;
import com.RealParking.service.ReporteService;
import com.RealParking.service.UserService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/reportes")
public class ReportesServlet extends HttpServlet {

    private ReporteService reporteService;

    @Inject
    @UserServicePrinc
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tipoReporte = req.getParameter("reporte");
        int page = Integer.parseInt(req.getParameter("page"));
        String username = req.getParameter("username") == null ? "" : req.getParameter("username");
        String fullName = req.getParameter("nombre_completo") == null ? "" : req.getParameter("nombre_completo");
        String rol = req.getParameter("id_rol") == null ? "" : req.getParameter("id_rol");
        String estado = req.getParameter("estado_usuario") == null ? "" : req.getParameter("estado_usuario");



        int regPorPage = 8;
        List<User> users = userService.listar((page - 1) * regPorPage, regPorPage, username, fullName, rol, estado);

        if (tipoReporte.equals("pdf")) {
            Logger log = Logger.getLogger(ReportesServlet.class.getName());
            log.info("=============Entrando a pdf ========================");
            reporteService = new ReportePdfServiceImpl();
            byte[] reporte = reporteService.generarReporte(users);
            // Configura los encabezados de la respuesta HTTP
            resp.setContentType("application/pdf");
            resp.setHeader("Content-disposition", "attachment; filename=reporte.pdf");

            // Escribe los bytes del reporte en la respuesta HTTP
            OutputStream outputStream = resp.getOutputStream();
            outputStream.write(reporte);
            outputStream.flush();

        } else {
            reporteService = new ReporteExcelServiceImpl();
            byte[] reporte = reporteService.generarReporte(users);
            resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            resp.setHeader("Content-disposition", "attachment; filename=reporte.xlsx");

            // Escribe los bytes del reporte en la respuesta HTTP
            OutputStream outputStream = resp.getOutputStream();
            outputStream.write(reporte);
            outputStream.flush();
        }

    }
}