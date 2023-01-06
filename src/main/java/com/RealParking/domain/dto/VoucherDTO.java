package com.RealParking.domain.dto;

import com.RealParking.domain.Ticket;
import com.RealParking.domain.User;

import java.time.LocalDateTime;

public class VoucherDTO {

    private int id;
    private Ticket ticket;
    private User user;
    private LocalDateTime date;
    private double amount;

    public VoucherDTO() {

    }

    public VoucherDTO(int id, Ticket ticket, User user, LocalDateTime date, double amount) {
        this.id = id;
        this.ticket = ticket;
        this.user = user;
        this.date = date;
        this.amount = amount;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "VoucherDTO{" +
                "id=" + id +
                ", ticket=" + ticket +
                ", user=" + user +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
