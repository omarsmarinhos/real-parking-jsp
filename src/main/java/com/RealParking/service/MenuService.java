package com.RealParking.service;

import com.RealParking.domain.Menu;

import java.util.Map;

public interface MenuService {

    Map<String, Menu> listarMenus(String rol);
}
