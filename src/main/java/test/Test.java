package test;


import com.RealParking.persitence.entity.Incident;
import com.RealParking.persitence.entity.Role;
import com.RealParking.persitence.entity.Ticket;
import com.RealParking.persitence.entity.User;
import com.RealParking.persitence.service.*;

import java.time.LocalDateTime;


public class Test {

    public static void main(String[] args) {

        UserService service = new UserServiceImpl();
        User user = new User();
        //user.setIdUser(1);
        user.setUsername("71397835");
        System.out.println(service.findUserByUser(user));


    }

}
