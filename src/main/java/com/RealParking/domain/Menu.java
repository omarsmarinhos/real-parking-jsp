package com.RealParking.domain;

import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

@SessionScoped
public class Menu implements Serializable {

    private String url;
    private int nivelPermiso;

    public Menu() {
    }

    public Menu(String url, int nivelPermiso) {
        this.url = url;
        this.nivelPermiso = nivelPermiso;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNivelPermiso() {
        return nivelPermiso;
    }

    public void setNivelPermiso(int nivelPermiso) {
        this.nivelPermiso = nivelPermiso;
    }

    @Override
    public String toString() {
        return "MenuPermiso{" +
                "url='" + url + '\'' +
                ", nivelPermiso=" + nivelPermiso +
                '}';
    }
}
