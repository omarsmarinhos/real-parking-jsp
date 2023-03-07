package test;


import com.RealParking.persitence.entity.Incident;
import com.RealParking.persitence.entity.Role;
import com.RealParking.persitence.entity.Ticket;
import com.RealParking.persitence.entity.User;
import com.RealParking.persitence.service.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Test {

    public static void main(String[] args) {

        /*MenuService service = new MenuServiceImpl();
        String rol = "Cajero";
        String url = "http://localhost:8080/RealParkingJsp/usuarios";
        List<String> menus = Arrays.asList("Caja", "Reportes");

        Optional<String> menuActual = menus.stream()
                .filter(m -> url.contains(m.toLowerCase())).findAny();*/

        String username = "";
        String nombre = "";
        String rol = "1";
        String estado = "";

        UserService userService = new UserServiceImpl();
        System.out.println(userService.getNumDeRegistros(username, nombre, rol, estado));

        List<User> usuarios = userService
                .findAllUsers(0, 4, username, nombre, rol, estado);
        usuarios.forEach(System.out::println);




    }

}
