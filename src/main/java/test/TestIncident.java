package test;

import com.RealParking.persitence.entity.Incident;
import com.RealParking.persitence.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestIncident {
    private static EntityManagerFactory emf;
    private static EntityManager manager;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("RealParkingPersistence");
        manager = emf.createEntityManager();


        List<Incident> incidents = (List<Incident>) manager.createQuery("FROM Incident",Incident.class).getResultList();

        for (Incident incident:
                incidents) {
            System.out.println("idIncident:"+incident.getIdIncident());
            System.out.println("idTicket:"+incident.getTicket());
            System.out.println("idUser:"+incident.getUser());
            System.out.println("dni:"+incident.getDni());
            System.out.println("fullName:"+incident.getFullName());
            System.out.println("date:"+incident.getDate());

        }


    }


}
