package test;

import com.RealParking.persitence.entity.Incident;
import com.RealParking.persitence.service.IncidentService;
import com.RealParking.persitence.service.IncidentServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestIncident {
    private static EntityManagerFactory emf;
    private static EntityManager manager;
    public static void main(String[] args) {
        IncidentService service = new IncidentServiceImpl();
        System.out.println(service.findAllIncidents());
    }


}
