package com.RealParking.persitence.repositories;

import com.RealParking.configs.MysqlConn;
import com.RealParking.configs.Repository;
import com.RealParking.domain.Permiso;
import jakarta.inject.Inject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
@RepositoryJdbc
public class MenuRepositoryImpl implements MenuRepository{

    @Inject
    @MysqlConn
    private Connection conn;

    @Override
    public List<Permiso> listarMenus(String rol) {
        List<Permiso> menusPermisos = new ArrayList<>();
        String sql = "SELECT mi.menu_item as menu, p.permiso " +
                "FROM rol as r inner join rol_menu_items as rmi on r.id_rol = rmi.id_rol " +
                "inner join menu_items as mi on rmi.id_menu_item = mi.id " +
                "inner join rol_menu_iems_permisos as rmip on rmip.id_rol_menu_items = rmi.id " +
                "inner join permisos as p on p.id = rmip.id_permiso " +
                "where r.descripcion ='" + rol + "'";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Permiso permiso = new Permiso();
                permiso.setMenu(rs.getString(1));
                permiso.setPermiso(rs.getString(2));
                menusPermisos.add(permiso);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return menusPermisos;
    }
}
