package com.RealParking.domain.service;

import com.RealParking.persitence.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoleServiceTestImpl implements RoleService{

<<<<<<< HEAD
    @Override
    public List<Role> listar() {
        return Arrays.asList(
                new Role(1, "Administrador", "Habilitado"),
                new Role(2, "Digitador", "Habilitado"),
                new Role(3, "Cajero", "Habilitado"));
=======
    @PersistenceContext(unitName="RealParkingPersistence")
    EntityManager em;

    @Override
    public List<Role> findAllRoles() {
        return em.createNamedQuery("Role.findAll").getResultList();
    }

    @Override
    public Role findRoleById(Role role) {
        return em.find(Role.class,role.getIdRol());
    }

    @Override
    public void insertRole(Role role) {
        em.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        em.merge(role);
    }

    @Override
    public void deleteRole(Role role) {
        em.remove(em.merge(role));
>>>>>>> 30ce9f420c505742ed89631084634dc450001727
    }
}
