package com.RealParking.persitence.service;

import com.RealParking.persitence.entity.Ticket;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

public class TicketServiceImpl implements TicketService{

    private EntityManagerFactory emf;
    private EntityManager em;

    public TicketServiceImpl() {
        emf = Persistence.createEntityManagerFactory("RealParkingPersistence");
        em = emf.createEntityManager();
    }

    @Override
    public List<Ticket> findAllTickets() {
        return em.createNamedQuery("Ticket.findAll").getResultList();
    }

    @Override
    public Ticket findTicketById(Ticket ticket) {
        return em.find(Ticket.class,ticket.getIdTicket());
    }

    @Override
    public void insertTicket(Ticket ticket) {
        em.getTransaction().begin();
        em.persist(ticket);
        em.getTransaction().commit();
    }

    @Override
    public void updateTicket(Ticket ticket) {
        em.getTransaction().begin();
        em.merge(ticket);
        em.getTransaction().commit();
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        em.getTransaction().begin();
        em.remove(em.merge(ticket));
        em.getTransaction().commit();
    }
}
