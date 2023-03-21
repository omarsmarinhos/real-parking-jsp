package com.RealParking.persitence.repositories;

import com.RealParking.configs.MysqlConn;
import com.RealParking.configs.Repository;
import com.RealParking.domain.Menu;
import jakarta.inject.Inject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RepositoryJdbc
public class MenuRepositoryImpl implements MenuRepository{

    @Inject
    @MysqlConn
    private Connection conn;

    @Override
    public Map<String, Menu> listarMenus(String rol) {
        Map<String, Menu> menuMap = new HashMap<>();
        String sql = "select m.nombre_menu, m.url, pm.nivel_permiso " +
                "from permisos_menus as pm inner join menus as m on pm.id_menu = m.id_menu " +
                "inner join rol as r on pm.id_rol = r.id_rol " +
                "where r.descripcion ='" + rol + "'";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Menu menuPermiso = new Menu();
                String nombreMenu = rs.getString("nombre_menu");
                menuPermiso.setUrl(rs.getString("url"));
                menuPermiso.setNivelPermiso(rs.getInt("nivel_permiso"));
                menuMap.put(nombreMenu, menuPermiso);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return menuMap;
    }
}
