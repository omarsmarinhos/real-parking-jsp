package test;


import com.RealParking.service.UserService;
import com.RealParking.service.UserServiceImpl;


public class Test {

    public static void main(String[] args) {

        /*MenuService service = new MenuServiceImpl();
        String rol = "Cajero";
        //String url = "http://localhost:8080/RealParkingJsp/usuarios";

        List<Permiso> permisoList = service.findAllMenus(rol);
        permisoList.forEach(System.out::println);*/

        /*String username = "";
        String nombre = "";
        String rol = "1";
        String estado = "";

        UserService userService = new UserServiceImpl();
        System.out.println(userService.getNumDeRegistros(username, nombre, rol, estado));

        List<User> usuarios = userService
                .findAllUsers(0, 4, username, nombre, rol, estado);
        usuarios.forEach(System.out::println);*/


        UserService userService = new UserServiceImpl();
        System.out.println(userService.porUsername("71397835"));

    }

}
