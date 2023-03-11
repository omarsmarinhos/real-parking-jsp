package com.RealParking.domain;

import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

@SessionScoped
public class Permiso implements Serializable {

    private String menu;
    private String permiso;

    public Permiso() {
    }

    public Permiso(String menu, String permiso) {
        this.menu = menu;
        this.permiso = permiso;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    @Override
    public String toString() {
        return "Permiso{" +
                "menu='" + menu + '\'' +
                ", permiso='" + permiso + '\'' +
                '}';
    }
}
