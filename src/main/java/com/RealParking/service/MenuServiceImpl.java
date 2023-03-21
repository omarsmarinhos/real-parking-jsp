package com.RealParking.service;

import com.RealParking.domain.Menu;
import com.RealParking.persitence.repositories.MenuRepository;
import com.RealParking.persitence.repositories.RepositoryJdbc;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Map;

@ApplicationScoped
public class MenuServiceImpl implements MenuService{

    @Inject
    @RepositoryJdbc
    private MenuRepository menuRepository;


    @Override
    public Map<String, Menu> listarMenus(String rol) {
        return menuRepository.listarMenus(rol);
    }

}
