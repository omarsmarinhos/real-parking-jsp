package com.RealParking.persitence.repositories;

import com.RealParking.configs.Repository;
import com.RealParking.persitence.entity.User;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryJpa
public class UserRepositoryJpaImpl implements UserRepository{

    @Inject
    EntityManager em;

    @Override
    public List<User> findAllUsers(int start, int regPorPag, String username, String fullName, String description, String state) {
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u LEFT JOIN FETCH u.role " +
                        "WHERE " +
                        "u.username LIKE :usuario AND " +
                        "u.fullName LIKE :nombreCompleto AND " +
                        "u.role.description LIKE :descripcionRol AND " +
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
                        "WHERE " +
                        "u.username LIKE :usuario AND " +
                        "u.fullName LIKE :nombreCompleto AND " +
                        "u.role.description LIKE :descripcionRol AND " +
                        "u.state LIKE :estado " +
                        "ORDER BY u.idUser", Long.class);
        query.setParameter("usuario", "%" + username + "%");
        query.setParameter("nombreCompleto", "%" + fullName + "%");
        query.setParameter("descripcionRol", "%" + description + "%");
        query.setParameter("estado", state + "%");
        return query.getSingleResult();
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        return Optional.ofNullable(em.find(User.class,id));
    }

    @Override
    public User findUserByUser(String username) {
        return em.createQuery("select u from User u where u.username = :username", User.class)
            .setParameter("username", username).getSingleResult();
    }

    @Override
    public void guardarUser(User user) {
        if (user.getIdUser() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
    }

    @Override
    public void deleteUser(User user) {

    }
}
