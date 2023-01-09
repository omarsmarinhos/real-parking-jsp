package com.RealParking.persitence.repository;

import com.RealParking.persitence.entity.Ticket;
import com.RealParking.persitence.entity.User;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface UserRepository {

     List<User> listarUsuarios();

     User encontrarUsuarioPorId(User user);

     void registrarUsuario(User user);

     void modificarUsuario(User user);

     void eliminarUsuario(User user);

}
