package com.RealParking.domain.service;

import com.RealParking.persitence.entity.Ticket;

import java.util.List;

public interface TicketService {

     List<Ticket> findAllTickets();

     Ticket findTicketById(Ticket ticket);

     void insertTicket(Ticket ticket);

     void updateTicket(Ticket ticket);

     void deleteTicket(Ticket ticket);

}
