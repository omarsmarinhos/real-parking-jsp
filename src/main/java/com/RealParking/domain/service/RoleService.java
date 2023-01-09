package com.RealParking.domain.service;

import com.RealParking.persitence.entity.Role;

import java.util.List;

public interface RoleService {

     List<Role> findAllRoles();

     Role findRoleById(Role role);

     void insertRole(Role role);

     void updateRole(Role role);

     void deleteRole(Role role);

}
