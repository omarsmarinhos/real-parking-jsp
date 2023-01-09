package com.RealParking.persitence.repository;

import com.RealParking.persitence.entity.Ticket;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface TicketRepository {

     List<Ticket> listarTickets();

     Ticket encontrarTicketPorId(Ticket ticket);

     void registrarTicket(Ticket ticket);

     void modificarTicket(Ticket ticket);

     void eliminarTicket(Ticket ticket);

}
