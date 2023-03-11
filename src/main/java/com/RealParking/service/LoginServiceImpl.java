package com.RealParking.service;

import com.RealParking.persitence.entity.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

@ApplicationScoped
public class LoginServiceImpl implements LoginService {

    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("username");
        if (user != null) {
            return Optional.ofNullable(user.getFullName());
        }
        return Optional.empty();
    }

}
