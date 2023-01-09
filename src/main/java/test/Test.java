package test;


import com.RealParking.persitence.service.RoleService;
import com.RealParking.persitence.service.RoleServiceImpl;


public class Test {

    public static void main(String[] args) {


        RoleService roleService = new RoleServiceImpl();
        System.out.println(roleService.findAllRoles());
    }

}
