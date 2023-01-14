package com.RealParking.persitence.service;

import com.RealParking.persitence.entity.User;

import java.util.List;

public interface UserService {

     List<User> findAllUsers();

     List<User> findAllUserByUser(String filter);

     User findUserById(User user);

     User findUserByUser(User user);

     void insertUser(User user);

     void updateUser(User user);

     void deleteUser(User user);

}
