package com.RealParking.persitence.repositories;

import com.RealParking.persitence.entity.Role;

import java.util.List;

public interface RoleRepository {

    List<Role> listar();
    void guardar(Role role);

}
