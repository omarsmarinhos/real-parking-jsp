package com.RealParking.domain.service;

import com.RealParking.persitence.entity.Role;

import java.util.Arrays;
import java.util.List;

public class RoleServiceMemoryImpl implements RoleService{
    @Override
    public List<Role> findAllRoles() {
        return Arrays.asList(
                new Role(1, "Administrador", "Habilitado"),
                new Role(2, "Digitador", "Habilitado"),
                new Role(3, "Cajero", "Habilitado")
        );
    }

    @Override
    public Role findRoleById(Role role) {
        return null;
    }

    @Override
    public void insertRole(Role role) {

    }

    @Override
    public void updateRole(Role role) {

    }

    @Override
    public void deleteRole(Role role) {

    }
}
