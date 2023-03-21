package com.RealParking.persitence.repositories;

import com.RealParking.domain.Menu;

import java.util.Map;

public interface MenuRepository {

    Map<String, Menu> listarMenus(String rol);

}
