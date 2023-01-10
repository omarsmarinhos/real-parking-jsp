package test;


import com.RealParking.persitence.entity.Incident;
import com.RealParking.persitence.entity.Ticket;
import com.RealParking.persitence.entity.User;
import com.RealParking.persitence.service.IncidentService;
import com.RealParking.persitence.service.IncidentServiceImpl;
import com.RealParking.persitence.service.RoleService;
import com.RealParking.persitence.service.RoleServiceImpl;

import java.time.LocalDateTime;


public class Test {

    public static void main(String[] args) {

        LocalDateTime ahora = LocalDateTime.now();
        IncidentService incidentService = new IncidentServiceImpl();
        Ticket ticket = new Ticket();
        ticket.setIdTicket(26);

        User user = new User();
        user.setIdUser(1);


        Incident incident = new Incident();
        incident.setTicket(ticket);
        incident.setUser(user);
        incident.setDni("71397835");
        incident.setFullName("Omar Mariños");
        incident.setDate(ahora);

        incidentService.insertIncident(incident);
    }

}
