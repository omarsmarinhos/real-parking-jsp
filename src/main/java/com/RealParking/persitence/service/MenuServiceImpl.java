package com.RealParking.persitence.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MenuServiceImpl implements MenuService{

    public MenuServiceImpl() {

    }

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public List<String> findAllMenus(String rol) {
        List<String> menus = new ArrayList<>();
        String sql = "SELECT mi.menu_item " +
                "FROM rol as r inner join rol_menu_items as rmi on r.id_rol = rmi.id_rol " +
                "inner join menu_items as mi on rmi.id_menu_item = mi.id " +
                "where r.descripcion ='" + rol + "'";
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                menus.add(rs.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return menus;
    }

}
