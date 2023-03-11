package com.RealParking.persitence.repositories;

import com.RealParking.configs.Repository;
import com.RealParking.persitence.entity.Role;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@Repository
@RepositoryJpa
public class RoleRepositoryImpl implements RoleRepository{

    @Inject
    EntityManager em;


    @Override
    public List<Role> listar() {
        return em.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public void guardar(Role role) {
        if (role.getIdRol() == null) {
            em.persist(role);
        } else {
            em.merge(role);
        }
    }
}
