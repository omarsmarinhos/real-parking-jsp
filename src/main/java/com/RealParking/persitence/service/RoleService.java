package com.RealParking.persitence.service;

import com.RealParking.persitence.entity.Role;

import java.util.List;

public interface RoleService {

     List<Role> findAllRoles();

     Role findRoleById(Role role);

     List<Role> findRoleByRole(String role);

     void insertRole(Role role);

     void updateRole(Role role);

     void deleteRole(Role role);

}
