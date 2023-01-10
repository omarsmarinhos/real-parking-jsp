package com.RealParking.persitence.service;

import com.RealParking.persitence.entity.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleServicePruebaImpl implements RoleService{

    private List<Role> items;

    public RoleServicePruebaImpl() {
        this.items = new ArrayList<>();
    }

    @Override
    public List<Role> findAllRoles() {
        return items;
    }

    @Override
    public Role findRoleById(Role role) {
        return null;
    }

    @Override
    public void insertRole(Role role) {
        items.add(role);
    }

    @Override
    public void updateRole(Role role) {

    }

    @Override
    public void deleteRole(Role role) {

    }

}
