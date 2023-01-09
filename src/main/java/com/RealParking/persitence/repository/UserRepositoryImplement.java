package com.RealParking.persitence.repository;

import com.RealParking.domain.service.UserService;
import com.RealParking.persitence.entity.User;
import jakarta.inject.Inject;

import java.util.List;

public class UserRepositoryImplement implements UserRepository{

    @Inject
    private UserService userService;

    @Override
    public List<User> listarUsuarios() {
        return userService.findAllUsers();
    }

    @Override
    public User encontrarUsuarioPorId(User user) {
        return userService.findUserById(user);
    }

    @Override
    public void registrarUsuario(User user) {
        userService.insertUser(user);
    }

    @Override
    public void modificarUsuario(User user) {
        userService.updateUser(user);
    }

    @Override
    public void eliminarUsuario(User user) {
        userService.deleteUser(user);
    }
}
