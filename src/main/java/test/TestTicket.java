package test;

import com.RealParking.persitence.entity.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestTicket {

    private static EntityManagerFactory emf;
    private static EntityManager manager;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("RealParkingPersistence");
        manager = emf.createEntityManager();

        List<Ticket> tickets = manager.createQuery("FROM Ticket",Ticket.class).getResultList();

        for (Ticket ticket:
                tickets) {
            System.out.println("idTicket:"+ticket.getIdTicket()+"\n");
            System.out.println("placa:"+ticket.getNumberPlate()+"\n");
            System.out.println("horaIngreso:"+ticket.getHourEntry()+"\n");
            System.out.println("horaSalida:"+ticket.getDepartureTime()+"\n");
            System.out.println("estado:"+ticket.getState()+"\n");

        }
    }
}
