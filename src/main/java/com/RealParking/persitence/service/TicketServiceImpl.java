package com.RealParking.persitence.service;

import com.RealParking.persitence.entity.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
        em.persist(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        em.merge(ticket);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        em.remove(em.merge(ticket));
    }
}
