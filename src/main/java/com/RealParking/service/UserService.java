package com.RealParking.service;

import com.RealParking.persitence.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> login (String username, String password);
    List<User> listar(int start, int regPorPag, String username, String fullName, String description, String state);
    Long getTotal(String username, String fullName, String description, String state);
    Optional<User> porId (Integer id);
    User porUsername (String username);
    void guardar(User user);



}
