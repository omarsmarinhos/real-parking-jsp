package com.RealParking.domain.service;

import com.RealParking.persitence.entity.User;

import java.util.List;

public interface UserService {

     List<User> findAllUsers();

     User findUserById(User user);

     void insertUser(User user);

     void updateUser(User user);

     void deleteUser(User user);

}
