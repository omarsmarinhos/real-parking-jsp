package test;


import com.RealParking.persitence.entity.Incident;
import com.RealParking.persitence.entity.Role;
import com.RealParking.persitence.entity.Ticket;
import com.RealParking.persitence.entity.User;
import com.RealParking.persitence.service.*;

import java.time.LocalDateTime;


public class Test {

    public static void main(String[] args) {

        //IncidentService incidentService = new IncidentServiceImpl();
        RoleService roleService = new RoleServiceImpl();


        System.out.println(roleService.findRoleByRole("a"));
        /*TicketService ticketService = new TicketServiceImpl();
        UserService userService = new UserServiceImpl();
        VoucherService voucherService = new VoucherServiceImpl();

        System.out.println(incidentService.findAllIncidents());
        System.out.println(roleService.findAllRoles());
        System.out.println(ticketService.findAllTickets());
        System.out.println(userService.findAllUsers());
        System.out.println(voucherService.findAllVouchers());*/

    }

}
