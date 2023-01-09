package com.RealParking.persitence.service;

import com.RealParking.persitence.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class UserServiceImpl implements UserService{

    private EntityManagerFactory emf;
    private EntityManager em;

    public UserServiceImpl() {
        emf = Persistence.createEntityManagerFactory("RealParkingPersistence");
        em = emf.createEntityManager();
    }

    @Override
    public List<User> findAllUsers() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    @Override
    public User findUserById(User user) {
        return em.find(User.class,user.getUsername());
    }

    @Override
    public User findUserByUser(User user) {

        return em.find(User.class,user.getUsername());
    }

    @Override
    public void insertUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        em.remove(em.merge(user));
    }
}
