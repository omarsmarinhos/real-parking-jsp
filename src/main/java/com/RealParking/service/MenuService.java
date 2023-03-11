package com.RealParking.service;

import com.RealParking.domain.Permiso;

import java.util.List;

public interface MenuService {

    List<Permiso> listarMenus(String rol);
}
