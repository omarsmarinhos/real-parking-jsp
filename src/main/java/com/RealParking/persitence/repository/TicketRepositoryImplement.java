package com.RealParking.persitence.repository;

import com.RealParking.domain.service.TicketService;
import com.RealParking.persitence.entity.Ticket;
import jakarta.inject.Inject;

import java.util.List;

public class TicketRepositoryImplement implements TicketRepository{

    @Inject
    private TicketService ticketService;

    @Override
    public List<Ticket> listarTickets() {
        return ticketService.findAllTickets();
    }

    @Override
    public Ticket encontrarTicketPorId(Ticket ticket) {
        return ticketService.findTicketById(ticket);
    }

    @Override
    public void registrarTicket(Ticket ticket) {
        ticketService.insertTicket(ticket);
    }

    @Override
    public void modificarTicket(Ticket ticket) {
        ticketService.updateTicket(ticket);
    }

    @Override
    public void eliminarTicket(Ticket ticket) {
        ticketService.deleteTicket(ticket);
    }
}
