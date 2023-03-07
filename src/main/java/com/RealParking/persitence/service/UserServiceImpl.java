package com.RealParking.persitence.service;

import com.RealParking.persitence.entity.User;

import javax.persistence.*;

import java.util.List;

public class UserServiceImpl implements UserService{

    private EntityManagerFactory emf;
    private EntityManager em;

    public UserServiceImpl() {
        emf = Persistence.createEntityManagerFactory("RealParkingPersistence");
        em = emf.createEntityManager();
    }

    @Override
    public List<User> findAllUsers(int start, int regPorPag, String username, String fullName, String description, String state) {
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u " +
                        "INNER JOIN u.role r " +
                        "WHERE " +
                        "u.username LIKE :usuario AND " +
                        "u.fullName LIKE :nombreCompleto AND " +
                        "r.description LIKE :descripcionRol AND " +
                        "u.state LIKE :estado " +
                        "ORDER BY u.idUser", User.class);
        query.setFirstResult(start);
        query.setMaxResults(regPorPag);
        query.setParameter("usuario", "%" + username + "%");
        query.setParameter("nombreCompleto", "%" + fullName + "%");
        query.setParameter("descripcionRol", "%" + description + "%");
        query.setParameter("estado", state + "%");
        return query.getResultList();
    }

    @Override
    public Long getNumDeRegistros(String username, String fullName, String description, String state) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT count(u) FROM User u " +
                        "INNER JOIN u.role r " +
                        "WHERE " +
                        "u.username LIKE :usuario AND " +
                        "u.fullName LIKE :nombreCompleto AND " +
                        "r.description LIKE :descripcionRol AND " +
                        "u.state LIKE :estado " +
                        "ORDER BY u.idUser", Long.class);
        query.setParameter("usuario", "%" + username + "%");
        query.setParameter("nombreCompleto", "%" + fullName + "%");
        query.setParameter("descripcionRol", "%" + description + "%");
        query.setParameter("estado", state + "%");
        return query.getSingleResult();
    }

    @Override
    public List<User> findAllUserByUser(String filter) {
        String jpql = "SELECT u FROM User u WHERE u.username LIKE '%" + filter.toUpperCase() + "%'";
        return em.createQuery(jpql, User.class).getResultList();
    }

    @Override
    public User findUserById(User user) {
        return em.find(User.class,user.getIdUser());
    }

    @Override
    public User findUserByUser(User user) {
        //Chamo encontré una solución, pero lo malo es que lanza una excepción si no encuentra nada
        Query query = em.createQuery("select u from User u where u.username = ?1", User.class);
        query.setParameter(1, user.getUsername());
        return (User) query.getSingleResult();
    }

    @Override
    public void insertUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    @Override
    public void deleteUser(User user) {
        em.getTransaction().begin();
        em.remove(em.merge(user));
        em.getTransaction().commit();
    }
}
