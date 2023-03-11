package com.RealParking.persitence.repositories;

import com.RealParking.persitence.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAllUsers(int start, int regPorPag, String username, String fullName, String description, String state);

    Long getNumDeRegistros(String username, String fullName, String description, String state);

    Optional<User> findUserById(Integer id);

    User findUserByUser(String username);

    void guardarUser(User user);

    void deleteUser(User user);
}
