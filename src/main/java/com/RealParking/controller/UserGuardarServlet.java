package com.RealParking.controller;

import com.RealParking.configs.RoleServicePrinc;
import com.RealParking.configs.UserServicePrinc;
import com.RealParking.domain.Menu;
import com.RealParking.persitence.entity.Role;
import com.RealParking.persitence.entity.User;
import com.RealParking.service.*;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/usuarios/guardar")
public class UserGuardarServlet extends HttpServlet {

    @Inject
    @UserServicePrinc
    private UserService service;

    @Inject
    @RoleServicePrinc
    private RoleService roleService;

    private int nivelPermiso;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        nivelPermiso = ((Map<String, Menu>) req.getSession().getAttribute("menus"))
                .get("Usuarios").getNivelPermiso();

        if (nivelPermiso < 2) {
            throw new PermisosException("Permiso denegado!");
        }

        Integer id;
        try {
            id = Integer.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = null;
        }
        User user = new User();
        Role role = new Role();
        user.setRole(role);
        if (id != null) {
            if (nivelPermiso >= 2) {
                Optional<User> userOptional = service.porId(id);
                if (userOptional.isPresent()) {
                    user = userOptional.get();
                }
            } else {
                throw new PermisosException("Usted no cuenta con los permisos para acceder a esta información.");
            }
        }
        req.setAttribute("roles", roleService.listar());
        req.setAttribute("user", user);
        req.setAttribute("title", "Formulario de usuario");
        getServletContext().getRequestDispatcher("/userForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String dni = req.getParameter("dni");
        String nombre = req.getParameter("nombre");
        String estado = req.getParameter("estado");
        String password = req.getParameter("password");
        String filaNameDB = req.getParameter("file_name");


        Map<String, String> errores = new HashMap<>();
        if (dni == null || dni.isBlank()) {
            errores.put("dni", "El DNI es requerido.");
        }
        if (nombre == null || nombre.isBlank()) {
            errores.put("nombre", "El nombre es requerido.");
        }
        if (estado == null || estado.isBlank()) {
            errores.put("estado", "EL estado es requerido.");
        }
        if (password == null || password.isBlank()) {
            errores.put("password", "EL password es requerido.");
        }
        Integer idRol;

        try {
            idRol = Integer.valueOf(req.getParameter("cargo"));
        } catch (NumberFormatException e) {
            idRol = null;
        }

        if (idRol == null) {
            errores.put("cargo", "El cargo es requerido.");
        }

        Integer idUser;

        try {
            idUser = Integer.valueOf(req.getParameter("idUser"));
        } catch (NumberFormatException e) {
            idUser = null;
        }

        User user = new User();
        user.setIdUser(idUser);
        user.setUsername(dni);
        user.setFullName(nombre);
        user.setPassword(password);
        user.setState(estado);
        if (idUser != null) {
            user.setUrl(filaNameDB);
        }
        user.setUrl(filaNameDB);
        Role role = new Role();
        role.setIdRol(idRol);
        user.setRole(role);

        if (errores.isEmpty()) {

            Part filePart = req.getPart("file");
            String fileName = filePart != null ? filePart.getSubmittedFileName() : "";
            if (fileName != null && !fileName.isEmpty()) {
                fileName = fileName.replaceAll("[^a-zA-Z0-9.-]", "_");
                user.setUrl(fileName);
            }

            if (idUser == null && nivelPermiso >= 3) {
                //guarda
                service.guardar(user);
            } else if (idUser != null && nivelPermiso >= 2) {
                //edita
                service.guardar(user);
            } else {
                throw new PermisosException("Permiso denegado!");
            }

            if (filePart != null && filePart.getSize() > 0) {
                String rutaDirectorio = req.getContextPath() + "/fotos/" + user.getIdUser() + "/";
                Path directorio = Paths.get(rutaDirectorio);

                if (Files.notExists(directorio)) {
                    FileUtils.forceMkdirParent(directorio.toFile());
                }

                if (fileName != null && !fileName.isEmpty()) {
                    String rutaArchivo = rutaDirectorio + fileName;
                    File target = new File(rutaArchivo);
                    try (InputStream input = filePart.getInputStream()) {
                        FileUtils.copyInputStreamToFile(input, target);
                    }
                }
            } else {
                log.info("No hace nada |||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            }


            resp.sendRedirect(req.getContextPath() + "/users.jsp");
        } else {
            req.setAttribute("errores", errores);
            req.setAttribute("roles", roleService.listar());
            req.setAttribute("user", user);
            req.setAttribute("title", "Formulario de producto");
            getServletContext().getRequestDispatcher("/userForm.jsp").forward(req, resp);
        }

    }

    Logger log = Logger.getLogger(UserGuardarServlet.class.getName());

}
