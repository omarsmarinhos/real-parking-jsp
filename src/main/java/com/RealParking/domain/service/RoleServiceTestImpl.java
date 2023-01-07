package com.RealParking.domain.service;

import com.RealParking.persitence.entity.Role;

import java.util.Arrays;
import java.util.List;

public class RoleServiceTestImpl implements RoleService{



    @Override
    public List<Role> listar() {
        return Arrays.asList(new Role(1, "", ""),
                new Role(1, "", ""),
                new Role(1, "", ""));
    }
}
