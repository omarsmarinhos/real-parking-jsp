package com.RealParking.service;

import com.RealParking.configs.RoleServicePrinc;
import com.RealParking.configs.Service;
import com.RealParking.interceptors.TransactionalJpa;
import com.RealParking.persitence.entity.Role;
import com.RealParking.persitence.repositories.RepositoryJpa;
import com.RealParking.persitence.repositories.RoleRepository;
import jakarta.inject.Inject;

import java.util.List;

@Service
@TransactionalJpa
@RoleServicePrinc
public class RoleServiceImpl implements RoleService{

    @Inject
    @RepositoryJpa
    private RoleRepository roleRepository;

    @Override
    public List<Role> listar() {
        return roleRepository.listar();
    }

    @Override
    public void guardar(Role role) {
        roleRepository.guardar(role);
    }
}
