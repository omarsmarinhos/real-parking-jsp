package com.RealParking.domain.service;

import com.RealParking.persitence.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserServiceTestImpl implements UserService{

    @PersistenceContext(unitName="RealParkingPersistence")
    EntityManager em;

    @Override
    public List<User> findAllUsers() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    @Override
    public User findUserById(User user) {
        return em.find(User.class,user.getIdUser());
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
