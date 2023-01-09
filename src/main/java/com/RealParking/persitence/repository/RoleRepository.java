package com.RealParking.persitence.repository;

import com.RealParking.persitence.entity.Role;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface RoleRepository {

     List<Role> listarRoles();

     Role encontrarRolPorId(Role role);

     void registrarRol(Role role);

     void modificarRol(Role role);

     void eliminarRol(Role role);

}
