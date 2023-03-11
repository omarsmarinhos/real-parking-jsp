package com.RealParking.persitence.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "comprobante")
@NamedQueries({
        @NamedQuery(name = "Voucher.findAll", query = "SELECT v FROM Voucher v")
})
public class Voucher implements Serializable {
    public static long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprobante")
    private Integer idVoucher;

    @OneToOne
    @JoinColumn(name = "id_ticket")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;

    @Column(name = "fecha")
    private LocalDateTime date;

    @Column(name = "importe")
    private Double amount;

    public Voucher() {
    }

    public Voucher(Integer idVoucher, Ticket ticket, User user, LocalDateTime date, Double amount) {
        this.idVoucher = idVoucher;
        this.ticket = ticket;
        this.user = user;
        this.date = date;
        this.amount = amount;
    }

    public Voucher(Ticket ticket, User user, LocalDateTime date, Double amount) {
        this.ticket = ticket;
        this.user = user;
        this.date = date;
        this.amount = amount;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Voucher.serialVersionUID = serialVersionUID;
    }

    public Integer getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(Integer idVoucher) {
        this.idVoucher = idVoucher;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "idVoucher=" + idVoucher +
                ", ticket=" + ticket +
                ", user=" + user +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
