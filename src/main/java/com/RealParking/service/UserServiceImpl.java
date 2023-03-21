package com.RealParking.service;

import com.RealParking.configs.Service;
import com.RealParking.configs.UserServicePrinc;
import com.RealParking.interceptors.TransactionalJpa;
import com.RealParking.persitence.entity.User;

import com.RealParking.persitence.repositories.RepositoryJpa;
import com.RealParking.persitence.repositories.UserRepository;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Service
@TransactionalJpa
@UserServicePrinc
public class UserServiceImpl implements UserService {

    @Inject
    @RepositoryJpa
    private UserRepository userRepository;

    @Override
    public Optional<User> login(String username, String password) {
        return Optional.ofNullable(userRepository.findUserByUser(username))
                .filter(u -> u.getPassword().equals(password) && u.getState().equals("Activo"));
    }

    @Override
    public List<User> listar(int start, int regPorPag, String username, String fullName, String description, String state) {
        return userRepository.findAllUsers(start, regPorPag, username, fullName, description, state);
    }

    @Override
    public Long getTotal(String username, String fullName, String description, String state) {
        return userRepository.getNumDeRegistros(username, fullName, description, state);
    }

    @Override
    public Optional<User> porId(Integer id) {
        return userRepository.findUserById(id);
    }


    @Override
    public void guardar(User user) {
        userRepository.guardarUser(user);
    }

    @Override
    public User porUsername(String username) {
        return userRepository.findUserByUser(username);
    }
}
