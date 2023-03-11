package com.RealParking.service;

import com.RealParking.persitence.entity.Role;

import java.util.List;

public interface RoleService {

     List<Role> listar();
     void guardar(Role role);

}
