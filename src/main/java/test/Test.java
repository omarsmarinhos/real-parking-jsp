package test;


import com.RealParking.persitence.entity.Incident;
import com.RealParking.persitence.entity.Role;
import com.RealParking.persitence.entity.Ticket;
import com.RealParking.persitence.entity.User;
import com.RealParking.persitence.service.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Test {

    public static void main(String[] args) {

        MenuService service = new MenuServiceImpl();
        String rol = "Cajero";
        String url = "http://localhost:8080/RealParkingJsp/usuarios";
        List<String> menus = Arrays.asList("Caja", "Reportes");

        Optional<String> menuActual = menus.stream()
                .filter(m -> url.contains(m.toLowerCase())).findAny();


    }

}
