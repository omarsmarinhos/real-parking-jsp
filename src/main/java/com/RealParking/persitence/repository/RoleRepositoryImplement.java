package com.RealParking.persitence.repository;

import com.RealParking.domain.service.RoleService;
import com.RealParking.persitence.entity.Role;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class RoleRepositoryImplement implements RoleRepository{

    @Inject
    private RoleService roleService;


    @Override
    public List<Role> listarRoles() {
        return roleService.findAllRoles();
    }

    @Override
    public Role encontrarRolPorId(Role role) {
        return roleService.findRoleById(role);
    }

    @Override
    public void registrarRol(Role role) {
        roleService.insertRole(role);
    }

    @Override
    public void modificarRol(Role role) {
        roleService.updateRole(role);
    }

    @Override
    public void eliminarRol(Role role) {
        roleService.deleteRole(role);
    }
}
