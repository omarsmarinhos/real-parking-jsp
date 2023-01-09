package com.RealParking.domain.service;

import com.RealParking.persitence.entity.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TicketServiceTestImpl implements TicketService{

    @PersistenceContext(unitName="RealParkingPersistence")
    EntityManager em;

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
