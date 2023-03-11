package com.RealParking.filters;

import com.RealParking.service.LoginService;
import com.RealParking.service.LoginServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/index.jsp", "/users.jsp", "/registro/*", "/caja/*", "/configuracion/*",
        "/reportes/*", "/roles/*", "/usuarios/*"})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        LoginService loginService = new LoginServiceImpl();
        Optional<String> username = loginService.getUsername((HttpServletRequest) req);
        if (username.isPresent()) {
            filterChain.doFilter(req, resp);
        } else {
            ((HttpServletResponse) resp).sendRedirect(((HttpServletRequest) req).getContextPath() + "/login.jsp");
        }
    }
}
