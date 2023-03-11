package com.RealParking.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebFilter({"/registro/*", "/caja/*", "/configuracion/*",
        "/reportes/*", "/roles/*", "/usuarios/*"})
public class RolFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) req).getSession();
        String url = ((HttpServletRequest)req).getRequestURL().toString();

        Optional<String> menuActual = ((List<String>) session.getAttribute("menus")).stream()
                .filter(m -> url.contains(m.toLowerCase())).findAny();

        if (menuActual.isPresent()) {
            filterChain.doFilter(req, resp);
        } else {
            ((HttpServletResponse) resp).sendRedirect(((HttpServletRequest) req).getContextPath() + "/index.jsp");
        }

    }
}
