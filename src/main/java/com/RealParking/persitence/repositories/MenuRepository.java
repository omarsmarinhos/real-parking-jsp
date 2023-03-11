package com.RealParking.persitence.repositories;

import com.RealParking.domain.Permiso;

import java.util.List;

public interface MenuRepository {

    List<Permiso> listarMenus(String rol);

}
