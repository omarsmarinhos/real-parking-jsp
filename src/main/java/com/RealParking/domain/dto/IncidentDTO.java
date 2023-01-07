package com.RealParking.domain.dto;

import com.RealParking.domain.Ticket;
import com.RealParking.domain.User;

import java.time.LocalDateTime;

public class IncidentDTO {

    private int id;
    private Ticket ticket;
    private User user;
    private String dni;
    private String fullName;
    private LocalDateTime date;

    public IncidentDTO(int id, Ticket ticket, User user, String dni, String fullName, LocalDateTime date) {
        this.id = id;
        this.ticket = ticket;
        this.user = user;
        this.dni = dni;
        this.fullName = fullName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "IncidentDTO{" +
                "id=" + id +
                ", ticket=" + ticket +
                ", user=" + user +
                ", dni='" + dni + '\'' +
                ", fullName='" + fullName + '\'' +
                ", date=" + date +
                '}';
    }
}
