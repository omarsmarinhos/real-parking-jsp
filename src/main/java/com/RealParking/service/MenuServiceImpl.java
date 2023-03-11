package com.RealParking.service;

import com.RealParking.domain.Permiso;
import com.RealParking.persitence.repositories.MenuRepository;
import com.RealParking.persitence.repositories.RepositoryJdbc;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class MenuServiceImpl implements MenuService{

    @Inject
    @RepositoryJdbc
    private MenuRepository menuRepository;


    @Override
    public List<Permiso> listarMenus(String rol) {
        return menuRepository.listarMenus(rol);
    }

}
