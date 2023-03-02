package com.RealParking.persitence.service;

import com.RealParking.persitence.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceImpl implements LoginService{

    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("username");
        if (user != null) {
            return Optional.ofNullable(user.getFullName());
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> login(String username, String password) {
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setUsername(username);
        return Optional.ofNullable(userService.findUserByUser(user))
                .filter(u -> u.getPassword().equals(password) && u.getState().equals("Activo"));
    }
}
